package Polymorphsim;

import java.util.Scanner;

public class Enrollment {
    Scanner input = new Scanner(System.in);
protected String Names;
    protected String [] Section;
    protected String Strands;
    protected int index = 0;
   protected int count =0;
   
    
    public Enrollment (String Names,String []Section,String Strands) {
        this.Names=Names;
        this.Section= Section;
        this.Strands = Strands;
    }
    
    
    public Enrollment() {
        
    }
    
    public void Registering() {
        System.out.println("Enter Following");
       
  System.out.println("INDEX OF ARRAY");
  index = input.nextInt();
  this.Section = new String[index];
  input.nextLine();
        System.out.println("Section: ");
        Names =input.next();
        input.nextLine();
        System.out.println("Name of students: ");
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