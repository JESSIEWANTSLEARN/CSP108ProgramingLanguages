package QUIZ2;

public class Main {

	public static void main(String[] args) {
	        InventoryManager manager = new InventoryManager();

	        // Example: Testing the logic
	        System.out.println("AUDIT/ERROR LIST:");
	        System.out.println("P001: " + manager.processTransaction("A", "P001", "Keyboard", 100.0f));
	        System.out.println("P001: " + manager.processTransaction("C", "P001", "Mechanical Keyboard", 150.0f));
	        
	        manager.display();
	        
	}

}
