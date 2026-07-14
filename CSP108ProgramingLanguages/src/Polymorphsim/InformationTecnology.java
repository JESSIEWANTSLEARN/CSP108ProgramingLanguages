package Polymorphsim;
import java.util.Scanner;
public class InformationTecnology  extends Enrollment{
	private int count = 1;
	

		Scanner input = new Scanner(System.in);
    public InformationTecnology (String Names,String []Section,String Strands) {
	       
	    super(Names,Section,Strands);	
	    }
	    
	    public InformationTecnology() {
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
	        	count++;
	            System.out.println(Section[a]+" "+ count);
	        }
	        System.out.println("Strands "+Strands);
	    }
	}


