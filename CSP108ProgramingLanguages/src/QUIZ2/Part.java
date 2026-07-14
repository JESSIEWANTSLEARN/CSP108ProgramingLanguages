package QUIZ2;

public class Part {
	
	private String partNumber;
	private String description;
	private float price;
	
	
	
 public 	Part (String partNumber ,String description ,float price ) {
	 this.partNumber=partNumber;
	 this.description=description;
	 this.price=price;
	 
 }


public String getPartNumber() {
	return partNumber;
}



public void setPartNumber(String partNumber) {
	this.partNumber = partNumber;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public float getPrice() {
	return price;
}



public void setPrice(float price) {
	this.price = price;
}
	
	
	

}
