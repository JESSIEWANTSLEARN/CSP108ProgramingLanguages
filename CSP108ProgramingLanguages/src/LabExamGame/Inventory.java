package LabExamGame;
import java.util.ArrayList;
public class Inventory {
	
	private ArrayList  <Item> items = new ArrayList<>();

	
	
	
	public void addItem (Item item) {
		items.add(item);
		System.out.println("Item was succesfully added"+item.getName());
		
	
	}
	public void removedItem(Item item) {
  items.remove(item);
	System.out.println("Succesfully removed"+item.getName());
	}
	
	
	
	
  
	  public void display() {
		    if (items.isEmpty()) {
		        System.out.println("Nothing in here");
		    } else {
		        for (Item i : items) {
		            System.out.println("Item name " + i.getName());
		            System.out.println("Description Item " + i.getDescription());
		        }
		    }
		}
  
  
  public ArrayList<Item> getItems() {
      return items;
  }


}
