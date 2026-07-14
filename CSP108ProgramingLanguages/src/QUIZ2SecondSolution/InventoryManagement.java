package QUIZ2SecondSolution;


import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {
    private ArrayList<Part> partsList;
    private ArrayList<String> auditLog; // stores "Part Number - Error/Status" for every transaction
    Scanner input = new Scanner(System.in);

    public InventoryManagement() {
        this.partsList = new ArrayList<>();
        this.auditLog = new ArrayList<>();
    }

    // ---- Field validation (10 chars for Part Number, 26 for Description) ----
    private boolean isValidPartNumber(String pn) {
        return pn != null && pn.length() > 0 && pn.length() <= 10;
    }

    private boolean isValidDescription(String desc) {
        return desc != null && desc.length() > 0 && desc.length() <= 26;
    }

    // ---- ADD ----
    ///Method overloading without parameter add
    public void add() {
        System.out.print("Enter Part Number (max 10 chars): ");
        String partNumber = input.nextLine();

        System.out.print("Enter Description (max 26 chars): ");
        String description = input.nextLine();

        System.out.print("Enter Price: ");
        float price;
        try {
            price = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price entered.");
            auditLog.add(partNumber + " - ERROR: Invalid price format");
            return;
        }

        System.out.print("Enter Entry Date (e.g. 2026-07-12): ");
        String entryDate = input.nextLine();

        add(partNumber, description, price, entryDate);
    }
    ///  Method overloading with parameter for direct value add
    public void add(String partNumber, String description, float price, String entryDate) {
        if (!isValidPartNumber(partNumber)) {
            System.out.println("Error: Part Number must be 1-10 characters.");
            auditLog.add(partNumber + " - ERROR: Invalid Part Number length");
            return;
        }
        if (!isValidDescription(description)) {
            System.out.println("Error: Description must be 1-26 characters.");
            auditLog.add(partNumber + " - ERROR: Invalid Description length");
            return;
        }
        // check duplicate part number
        for (Part p : partsList) {
            if (p.getPartNumber().equalsIgnoreCase(partNumber)) {
                System.out.println("Error: Part Number already exists.");
                auditLog.add(partNumber + " - ERROR: Duplicate Part Number");
                return;
            }
        }

        partsList.add(new Part(partNumber, description, price, entryDate));
        System.out.println("Part added successfully.");
        auditLog.add(partNumber + " - Added successfully");
    }

    // ---- CHANGE: Description ----
    public void updateDescription() {
        System.out.print("Enter Part Number to update: ");
        String partNumber = input.nextLine();

        System.out.print("Enter New Description (max 26 chars): ");
        String newDesc = input.nextLine();

        if (!isValidDescription(newDesc)) {
            System.out.println("Error: Description must be 1-26 characters.");
            auditLog.add(partNumber + " - ERROR: Invalid Description length");
            return;
        }

        for (Part p : partsList) {
            if (p.getPartNumber().equalsIgnoreCase(partNumber)) {
                p.setDescription(newDesc);
                System.out.println("Description updated successfully.");
                auditLog.add(partNumber + " - Description updated");
                return;
            }
        }
        System.out.println("Error: Part not found.");
        auditLog.add(partNumber + " - ERROR: Part not found");
    }

    // ---- CHANGE: Price ----
    public void updatePrice() {
        System.out.print("Enter Part Number to update: ");
        String partNumber = input.nextLine();

        System.out.print("Enter New Price: ");
        float newPrice;
        try {
            newPrice = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid price format.");
            auditLog.add(partNumber + " - ERROR: Invalid price format");
            return;
        }

        for (Part p : partsList) {
            if (p.getPartNumber().equalsIgnoreCase(partNumber)) {
                p.setPrice(newPrice);
                System.out.println("Price updated successfully.");
                auditLog.add(partNumber + " - Price updated");
                return;
            }
        }
        System.out.println("Error: Part not found.");
        auditLog.add(partNumber + " - ERROR: Part not found");
    }

    // ---- DELETE ----
    public void deleteByPartNumber() {
        System.out.print("Enter Part Number to delete: ");
        String partNumber = input.nextLine();

        boolean removed = partsList.removeIf(p -> p.getPartNumber().equalsIgnoreCase(partNumber));

        if (removed) {
            System.out.println("Part deleted successfully.");
            auditLog.add(partNumber + " - Deleted successfully");
        } else {
            System.out.println("Error: Part not found.");
            auditLog.add(partNumber + " - ERROR: Part not found, cannot delete");
        }
    }

    // ---- DISPLAY current inventory ----
    public void display() {
        if (partsList.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n--- Updated Inventory File ---");
            for (Part p : partsList) {
                System.out.println("ID: " + p.getPartNumber() +
                                   " | Desc: " + p.getDescription() +
                                   " | Price: " + p.getPrice() +
                                   " | Entry Date: " + p.getEntryDate());
            }
        }
    }

    // ---- DISPLAY audit/error list (required output) ----
    public void displayAuditLog() {
        System.out.println("\n--- Audit / Error List ---");
        if (auditLog.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            for (String entry : auditLog) {
                System.out.println(entry);
            }
        }
    }
}