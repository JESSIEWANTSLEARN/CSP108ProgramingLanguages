package Polymorphsim;

import java.util.Scanner;


public class ComputerScience  extends Enrollment{
	Scanner input = new Scanner(System.in);
    public ComputerScience (String Names,String []Section,String Strands) {
       
    super(Names,Section,Strands);	
    }
    
    public ComputerScience() {
	}


    public void Registering() {
        System.out.println("Enter Following");
       
  System.out.println("INDEX OF ARRAY");
  index = input.nextInt();
  input.nextLine();
  this.Section = new String[index];
        System.out.println("Name Section: ");
        Names =input.next();
        input.nextLine();
        System.out.println("Name Student: ");
        for(int a = 0; a<Section.length; a++) 
        {
        	System.out.print(a+1);
        	this.Section[a]=input.next();
        }
        input.nextLine();
        System.out.println("Strands: ");
        Strands =input.next();
    }
    
    
    public void DisplayRecords() {
        System.out.println("Records of student enrollment");
        System.out.println("Name " +Names);
        System.out.println("Section");
        for(int a = 0; a<Section.length; a++) {
        	  System.out.println(a+1);
            System.out.println(Section[a]);
        }
        System.out.println("Strands "+Strands);
    }
}

