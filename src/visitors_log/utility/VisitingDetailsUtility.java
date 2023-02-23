package visitors_log.utility;

import java.util.List;
import java.util.Scanner;

import visitors_log.entity.EntryPass;
import visitors_log.entity.VisitingDetails;
import visitors_log.entity.VisitorInfo;
import visitors_log.service.VisitingDetailsServiceImpl;

public class VisitingDetailsUtility {

	public static void main(String[] args) {

		menuDisplay();
		//getAllVisitingDetails();
		//insertIntoVisitingDetails();
		//updateIntoVisitingDetails();
		//deleteFromVisitingDetails();
		//getFindByRegisterId();
	}

	private static void getFindByRegisterId() {

		Scanner in = new Scanner(System.in);
		System.out.println("_____________Visiting-Details_____________");
		System.out.println("Enter the RegisterId to Find :");
		int regId = in.nextInt();
		
		VisitingDetailsServiceImpl visitingdetailsServiceImpl = new VisitingDetailsServiceImpl();
		VisitingDetails visitingdetails = visitingdetailsServiceImpl.findById(regId);
		display();
		if (visitingdetails != null) {
			System.out.println(visitingdetails.getRegisterId() + "		" + visitingdetails.getEntrypass().getPassid() + "	" +
					visitingdetails.getVisitorinfo().getVisitorId() + "		" +	visitingdetails.getDate() + "	" + visitingdetails.getVisitingPurpose());
		}
		else {
			System.out.println("No details found with the given ID,Try Again...");

		}
	}

	public static void menuDisplay() {

		Scanner input = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("______________ VISITING-DETAILS _______________\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Visiting-Details");
			System.out.println("2. Add new Visiting-Details");
			System.out.println("3. Update Visiting-Details");
			System.out.println("4. Delete Visiting-Details");
//			System.out.println("5. Find Details By ID");
			System.out.println("5. Choose a Particular Date and Show VisitorDetails :");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllVisitingDetails();
				;
				System.out.println("\n");
				break;
			case 2:     insertIntoVisitingDetails();
						getAllVisitingDetails();

				break;
			case 3:		updateIntoVisitingDetails();
						getAllVisitingDetails();
				break;

			case 4: 	deleteFromVisitingDetails();
						getAllVisitingDetails();
				break;
			case 5:		PDFGenerator.generateDetailsByDate();
			break;
			case 6:
				System.out.println("_______________ All THE BEST THANK YOU _______________\n");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again...\n");
			}

		} while (condition);

	}
	private static void getAllVisitingDetails() {
		
		VisitingDetailsServiceImpl visitingdetailsServiceImpl = new VisitingDetailsServiceImpl();
		List<VisitingDetails> visitingdetailsList = visitingdetailsServiceImpl.findAll();
		display();
		for (VisitingDetails visitingdetails : visitingdetailsList) {
			System.out.println(visitingdetails.getRegisterId() + "		" + visitingdetails.getEntrypass().getPassid() + "	" +
					visitingdetails.getVisitorinfo().getVisitorId() + "		" +	visitingdetails.getDate() + "	" + visitingdetails.getVisitingPurpose());
		}
		
	}

	private static void insertIntoVisitingDetails() {
		
		EntryPassUtility.getAllEntryPass();
		System.out.println("_____________________________________________________________________________________");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("________________ Inserting into VisitingDetails _______________");
		System.out.println("Enter the RegisterID:");
		int registerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PassID:");
		int passId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitorID:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Date:");
		String date = scanner.nextLine();
		System.out.println("Enter the Visiting-Purpose:");
		String visitingPurpose = scanner.nextLine();
		

		EntryPass entryPass = new EntryPass();
		entryPass.setPassid(passId);
		VisitorInfo visitorinfo = new VisitorInfo();
		visitorinfo.setVisitorId(visitorId);

	
		VisitingDetails visitingdetails = new VisitingDetails(registerId,entryPass,visitorinfo,date,visitingPurpose);

		VisitingDetailsServiceImpl visitingdetailsServiceImpl = new VisitingDetailsServiceImpl();
		visitingdetailsServiceImpl.save(visitingdetails);
		
	}

	private static void updateIntoVisitingDetails() {
		
		EntryPassUtility.getAllEntryPass();
		System.out.println("_____________________________________________________________________________________");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("_________________ Update into VisitingDetails ________________");
		System.out.println("Enter the RegisterID:");
		int registerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PassID:");
		int passId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitorID:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Date:");
		String date = scanner.nextLine();
		System.out.println("Enter the Visiting-Purpose:");
		String visitingPurpose = scanner.nextLine();
		
		EntryPass entryPass = new EntryPass();
		entryPass.setPassid(passId);
		VisitorInfo visitorinfo = new VisitorInfo();
		visitorinfo.setVisitorId(visitorId);

	
		VisitingDetails visitingdetails = new VisitingDetails(registerId,entryPass,visitorinfo,date,visitingPurpose);

		VisitingDetailsServiceImpl visitingdetailsServiceImpl = new VisitingDetailsServiceImpl();
		visitingdetailsServiceImpl.update(visitingdetails);
		
		
	}

	private static void deleteFromVisitingDetails() {
		
		EntryPassUtility.getAllEntryPass();
		System.out.println("_____________________________________________________________________________________");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("_________________ Update into VisitingDetails _______________");
		System.out.println("Enter the RegisterID:");
		int registerId = scanner.nextInt();
		scanner.nextLine();
		

		VisitingDetails visitingdetails = new VisitingDetails();
		visitingdetails.getRegisterId();

		VisitingDetailsServiceImpl visitingdetailsServiceImpl = new VisitingDetailsServiceImpl();
		visitingdetailsServiceImpl.delete(visitingdetails);
			
	}

	public static void display() {
		System.out.println("_____________________________________________________________________________________");
		System.out.println("register_id\tpass_id     visitor_id		date\tvisiting_purpose");
		System.out.println("_____________________________________________________________________________________");
	}

}
