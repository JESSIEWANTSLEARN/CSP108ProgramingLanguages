package QUIZ2SecondSolution;
import java.util.Scanner;
import java.util.ArrayList;

public class InventoryManagementS2 {
	    // COMPOSITION: InventoryManagement "has-a" list of Parts
	    private ArrayList<Part> partsList;
	    Scanner input = new Scanner(System.in);

	    public InventoryManagementS2() {
	        this.partsList = new ArrayList<>();
	    }

	    //Method overloading both add and  add without parameter  for direct value
	    public void add() {
	        System.out.print("Enter Part Number: ");
	        String  partNumber = input.nextLine();

	        System.out.print("Enter Description: ");
	        String  description = input.nextLine();

	        System.out.print("Enter Price: ");
	        float     price = input.nextFloat();
	        input.nextLine(); // Consume the leftover newline

	        this.add(partNumber, description, price);
	        System.out.println("Part added successfully.");
	    }

	    public void add(String partNumber, String description, float price) {
	        partsList.add(new Part(partNumber, description, price));
	         System.out.println("Part added successfully.");
	    }

	   //For the Update Description
	    public void updateDescription() {
	        System.out.print("Enter Part Number to update: ");
	        String partNumber = input.nextLine();

	        System.out.print("Enter New Description: ");
	        String newDesc = input.nextLine();

	        for (Part p : partsList) {
	            if (p.getPartNumber().equals(partNumber)) {
	                p.setDescription(newDesc);
	                System.out.println("Description updated successfully.");
	                return;
	            }
	        }
	        System.out.println("Part not found.");
	    }

	       //Update for the price
	    public void updatePrice() {
	        System.out.print("Enter Part Number to update: ");
	        String partNumber = input.nextLine();

	        System.out.print("Enter New Price: ");
	        float newPrice = input.nextFloat();
	        input.nextLine(); // Consume the leftover newline

	        for (Part p : partsList) {
	            if (p.getPartNumber().equals(partNumber)) {
	                p.setPrice(newPrice);
	                System.out.println("Price updated successfully.");
	                return;
	            }
	        }
	        System.out.println("Part not found.");
	    }

	      //Deleted PartNumber
	    public void deleteByPartNumber() {
	        System.out.print("Enter Part Number to delete: ");
	        String partNumber = input.nextLine();

	        partsList.removeIf(p -> p.getPartNumber().equals(partNumber));
	        System.out.println("Operation attempted for ID: " + partNumber);
	    }

	//Display
	public void display() {
	    if (partsList.isEmpty()) {
	        System.out.println("Inventory is empty.");
	    } else {
	        for (Part p : partsList) {
	            System.out.println("ID: " + p.getPartNumber() +
	                               " | Desc: " + p.getDescription() +
	                               " | Price: " + p.getPrice());
	        }
	    }
	    
	}
}