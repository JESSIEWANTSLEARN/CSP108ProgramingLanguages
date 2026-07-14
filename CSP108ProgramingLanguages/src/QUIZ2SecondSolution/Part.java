package QUIZ2SecondSolution;

public class Part {
    private String partNumber;      // max 10 characters
    private String description;     // max 26 characters
    private float price;
    private String entryDate;       // minor key field

    public Part(String partNumber, String description, float price, String entryDate) {
        this.partNumber = partNumber;
        this.description = description;
        this.price = price;
        this.entryDate = entryDate;
    }

    public String getPartNumber() {
    	return partNumber; }
    
    public void setPartNumber(String partNumber) { 
    	this.partNumber = partNumber; }

    public String getDescription() { 
    	return description;
    }
    public void setDescription(String description) {
    	this.description = description; }

    public float getPrice() { 
    	return price; }
    
    public void setPrice(float price) 
    { this.price = price; }

    public String getEntryDate() { 
    	return entryDate; }
    
    public void setEntryDate(String entryDate) {
    	this.entryDate = entryDate; }
}