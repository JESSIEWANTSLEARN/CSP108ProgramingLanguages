package QUIZ2;
import java.util.ArrayList;
public class InventoryManager {

	private ArrayList<Part> inventory = new ArrayList<>();
	
	
  public String processTransaction (String Code,String partNum,String description ,float price )	{
	Part partFound = null;
	for(Part p: inventory) {
		if(p.getPartNumber().equalsIgnoreCase(partNum)) {
			partFound = p;
			break;
			}
	}	

	switch (Code.toUpperCase()) {
    case "A":
        if (partFound != null) 
        	return "Error: Part already exists.";
        inventory.add(new Part(partNum, description, price));
        return "Success: Part added.";

    case "C":
        if (partFound == null)
        	return "Error: Part not found.";
        partFound.setDescription(description);
        partFound.setPrice(price);
        return "Success: Part changed.";

    case "D":
        if (partFound == null) 
        	return "Error: Part not found.";
        inventory.remove(partFound);
        return "Success: Part deleted.";

    case "X":
        return "Exit";
        
    
  

    default:
        return "Error: Invalid code.";
        
	}
  }
        public void display () {
        	System.out.println("Display ");
        	for(Part p: inventory) {
        		System.out.println("PartNum: "+p.getPartNumber());
        		System.out.println("Description: "+p.getDescription());
        		System.out.println("Price: "+p.getPrice());
        }
        }

}