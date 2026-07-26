package Quiz1BondCalculator;


public class BondCalculator {

    // Computation method for tiered interest rates
    public void compute(double facevalue, int years) {
        double value = facevalue;

        for (int i = 1; i <= years; i++) {
            double rate;

            if (i <= 3) {
                rate = 0.075; // 7.5% for the first 3 years
            } else if (i <= 8) {
                rate = 0.08;  // 8% for the next 5 years
            } else {
                rate = 0.0825; // 8.25% for the remaining 4 years
            }

            double interest = value * rate;
            double newvalue = value + interest;

            System.out.println("Year: " + i + 
                    "\nFace Value: " + value + "\n" +
                    "Interest: " + interest + "\n" +
                    "New Face Value: " + newvalue);
            System.out.println(" ");

            value = newvalue;
        }
    }
}