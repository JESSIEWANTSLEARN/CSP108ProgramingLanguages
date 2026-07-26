package Quiz1BondCalculator;



public class Bond {

    private double faceValue;
    private int years;
    private BondCalculator calculator; // Composition

    public Bond(double facevalue, int years) {
        this.faceValue = facevalue;
        this.years = years;
        this.calculator = new BondCalculator(); 
    }

    // Display method utilizing OOP composition
    public void displayTable() {
        calculator.compute(faceValue, years);
    }
}