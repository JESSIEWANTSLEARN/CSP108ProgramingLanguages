package LabExamATM;
import java.util.Scanner;

public class ATM {
	private static Scanner input = new Scanner(System.in);
private float balanced;


  public void deposit() {
	  System.out.println("Enter Amount Deposit");
	 float deposit =input.nextFloat();
	 balanced +=   deposit; 
  }
  
  
  public void withDrawal() {
	  System.out.println("Enter Amount Deposit");
		 float withdraw =input.nextFloat();
		 if(withdraw > balanced) {
			 System.out.println("YOUR balanceds is not enough"+balanced);
			 
		 }else if(withdraw <= 0 ) {
				 System.out.println("its not VALID ");
	
		 }else {
	 balanced -= withdraw;
	 System.out.println("Your money that release successfully"+withdraw);
		 
	 }
		 }
		 
 
		 
 

public void checkBalance() {
	System.out.println("Balance"+balanced);
	
}


public void menu () {
	ATM  atm = new ATM();
	boolean Loop = true;
	while(Loop) {
System.out.println("Menu");

System.out.println("Enter you Insert Your card");
System.out.println("Enter the Pin Number");

System.out.println("Welcome to ATM MACHINE");
System.out.println("1:deposit");
System.out.println("2:withDrawal");
System.out.println("3:checkBalance");

System.out.println("Choose the operation you want");
	int choice =input.nextInt();
	
	
	switch (choice){
		
		
	case 1:
		atm.deposit();
 	  break;
	case 2:
		atm.withDrawal();
       break ;

	case 3:
		atm.checkBalance();
   break;
	case 4:
		Loop = false;
        break;
        
        default:
        	System.out.println("Error please try again");
	}

	
	}
	
	
}
	
	
	

	
	
	
	

}
