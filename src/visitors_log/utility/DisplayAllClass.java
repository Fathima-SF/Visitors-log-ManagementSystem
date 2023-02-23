package visitors_log.utility;

import java.util.Scanner;

public class DisplayAllClass {

	public static void main(String[] args) {
		
		finalDisaply();
		
	}
	public static void finalDisaply() {
		 Scanner input = new Scanner(System.in);
		 boolean  value = true;
		    int num;
		    do {
		    System.out.println("_________________________ WELCOME ________________________\n\n"
		    		+ "____________ VISITORS LOG MANAGEMENT SYSTEM ______________\n");	
		    System.out.println("1.STAFF-INFORMATION\n2.COMPANY-DETAILS\n3.VISITOR-INFO\n4.ENTRY-PASS" 
		    		+ "\n5.BLOCK-DETAILS\n6.VISITING-DETAILS\n7.EXIT");	
		    System.out.print("Enter a Choice: ");
		    num = input.nextInt();
		    
		    switch (num) {
		      case 1:
		    	  StaffInformationUtility.menuDisplay();
		        break;
		      case 2:
		    	  CompanyDetailsUtility.menuDisplay();
		        break;
		      case 3:
		    	  VisitorInfoUtility.menuDisplay();
		        break;
		      case 4:
		    	  EntryPassUtility.menuDisplay();
		        break;
		      case 5:
		    	  BlockDetailsUtility.menuDisplay();
		        break;
		      case 6:
		    	  VisitingDetailsUtility.menuDisplay();
		        break;
		//      case 7:
		//    	  PDFGenerator.menuDisplay();
		//        break;
		      case 7:
		    	 System.out.println("_______________ All THE BEST THANK YOU ______________");
		    	 value = false;
		        break;
		      default:
		        System.out.println("  Wrong choioce Try again...\n");
		    }
		    
		  }while(value);
	}

}
