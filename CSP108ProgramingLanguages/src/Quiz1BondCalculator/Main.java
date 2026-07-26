package Quiz1BondCalculator;


import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("$50:");
        Bond b50 = new Bond(50.0, 12);
        b50.displayTable();

        System.out.println("$100:");
        Bond b100 = new Bond(100.0, 12);
        b100.displayTable();

        System.out.println("$500:");
        Bond b500 = new Bond(500.0, 12);
        b500.displayTable();

        System.out.println("$1000:");
        Bond b1000 = new Bond(1000.0, 12);
        b1000.displayTable();

        scan.close();
    }
}