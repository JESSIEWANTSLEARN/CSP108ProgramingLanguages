package QUIZ2SecondSolution;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InventoryManagement In = new InventoryManagement();
        boolean loop = true;

        System.out.println("Loading initial inventory...");
        In.add("KB-01", "AULA WIN60 HE Pro Wireless", 65.99f, "2026-01-10");
        In.add("BAT-61", "ThinkPad T480 72Wh Battery", 45.50f, "2026-01-10");
        In.add("KB-02", "Irok FE87 V2 IMC", 55.00f, "2026-01-10");
        System.out.println("------------------------------");

        while (loop) {
        	//Menu//
            System.out.println("\nMenu");
            System.out.println("[A]: ADD PART");
            System.out.println("[C]: CHANGE DESCRIPTION OR PRICE");
            System.out.println("[D]: DELETE PART");
            System.out.println("[Y]: DISPLAY INVENTORY");
            System.out.println("[X]: EXIT");
            System.out.print("Choice: ");
            String choice = input.nextLine().trim().toUpperCase(); // accepts A/a, C/c, D/d, X/x
          try {
        	  //Main menu only for the choices
            switch (choice) {
                case "A":
                    In.add();
                    break;

                case "C":
                    System.out.println("1: Update Description");
                    System.out.println("2: Update Price");
                    System.out.print("Pick: ");
                    String pick = input.nextLine().trim();

                    if (pick.equals("1")) {
                        In.updateDescription();
                    } else if (pick.equals("2")) {
                        In.updatePrice();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case "D":
                    In.deleteByPartNumber();
                    break;

                case "Y":
                    In.display();
                    break;

                case "X":
                    System.out.println("Exiting program...");
                    In.display();          // show final updated file
                    In.displayAuditLog();  // show required audit/error list
                    loop = false;
                    break;

                default:
                    System.out.println("Wrong input. Use A, C, D, Y, or X.");
            }
        }
          catch (InputMismatchException e) {
        	  //Error Handling
             System.out.println("Invalid choice Or input Try again");
             input.nextLine() ;       
    }
        }
    }
}