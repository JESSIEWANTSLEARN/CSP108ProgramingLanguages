package Polymorphsim;

public class Main {

	public static void main(String[] args) {
		
		double PricePaper = 15.0;
    int sale = 40;
    double totalsale = sale * PricePaper;
    double commision;
    
    if(sale < 20) {
    	commision =  totalsale  * 0.03;
    	System.out.println("Commision 3 percent: "+commision);
    
    	return;
    }else if(sale >= 20 && sale < 40) {
    	commision =  totalsale  * 0.40;
    	   System.out.println("Commision 40 percent: "+commision);
    	
    	
	} else if (sale >=  40){
		commision = totalsale  * 0.10;
   	   System.out.println("Commision 10 percent: "+commision);
 
	
	}
		
	}


}
