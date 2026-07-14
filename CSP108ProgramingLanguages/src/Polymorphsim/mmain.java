package Polymorphsim;
import java.util.InputMismatchException;
import java.util.Scanner;
public class mmain {
	public static void main(String[] args) {
   Scanner input = new Scanner (System.in);
   
	boolean loop = true;
	Enrollment cs = new ComputerScience();
	Enrollment it = new InformationTecnology();
	
	while(loop) {
	  System.out.println("Menu");
	  System.out.println("1.Registration");
	  System.out.println("2.Display List Student");
	  System.out.println("3.Exit");
	  try {
	  System.out.println("Pick your choice");
	  int Choice = input.nextInt();
	  
	  
	switch (Choice) {
	case 1:
		System.out.println("Pick the  1.CS OR 2. IT");
		int choice1 =input.nextInt();
		if(choice1 == 1) {
			cs.Registering();
		}else {
			it.Registering();
		}
	break;
	case 2:
		System.out.println("DISPLAY 1 CS OR 2. IT");
		int choice2 =input.nextInt();
		if(choice2 == 1) {
			cs.DisplayRecords();
		}else {
			it.DisplayRecords();
		}
       break;
	case 3:
		System.out.println("Exit");
		loop = false;
       
       default:
    	   System.out.println("Wrong");
    	   loop  = true;
    	   break;
    	   
	}
	} catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter a number.");
                input.nextLine(); 
    }
}
	  
	  
	  input.close();
	  
	}
	}
	
	
	
	