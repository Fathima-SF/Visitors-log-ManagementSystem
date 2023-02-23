package visitors_log.utility;

import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import visitors_log.entity.CompanyDetails;
import visitors_log.entity.EntryPass;
import visitors_log.entity.StaffInformation;
import visitors_log.entity.VisitorInfo;
import visitors_log.service.CompanyDetailsServiceImpl;
import visitors_log.service.EntryPassServiceImpl;

public class EntryPassUtility {

	public static void main(String[] args) {

		menuDisplay();
		//getAllEntryPass();
		//insertIntoEntryPass();
		//updateIntoEntryPass();
		//deleteFromEntryPass();
		//getFindByPassId();

	}
	
	private static void getFindByPassId() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________Entry_Pass_______________\n");
		System.out.println("Enter the PassId to find :");
		int pass_id = scanner.nextInt();
		
		EntryPassServiceImpl entrypassServiceImpl = new EntryPassServiceImpl();
		EntryPass entryPass = entrypassServiceImpl.findById(pass_id);
		display();
		if (entryPass != null) {
		System.out.println(entryPass.getPassid() + "	\t" + entryPass.getVisitorinfo().getVisitorId() + "		"
				+ entryPass.getCompanydetails().getCompanyId() + "		"
				+ entryPass.getStaffinformation().getStaffId() + "		" + entryPass.getTimeIn() + "\t\t"
				+ entryPass.getTimeOut());
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
			System.out.println("________________ ENTRYPASS ________________\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show EntryPass-Details");
			System.out.println("2. Add new Entry-Pass");
			System.out.println("3. Update EntryPass-Details");
			System.out.println("4. Delete Entry-Pass");
	//		System.out.println("5. Find details by ID");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllEntryPass();
				;
				System.out.println("\n");
				break;
			case 2: 	insertIntoEntryPass();
						getAllEntryPass();
				break;
			case 3:     updateIntoEntryPass();
						getAllEntryPass();
				break;

			case 4:	    deleteFromEntryPass();
						getAllEntryPass();
				break;
	//		case 5:     getFindByPassId();
	//		break;
			case 5:
				System.out.println("______________ All THE BEST THANK YOU ________________");
				condition = false;
				break;

			default:
				System.out.println(" Invalid option, try again...\n");
			}

		} while (condition);

	}
	
	public static void getAllEntryPass() {
		
		System.out.println("_______________________________________________________________");
		CompanyDetailsUtility.getAllCompanyDetails();
		System.out.println("_______________________________________________________________");
		StaffInformationUtility.getAllStaffDetails();
		System.out.println("_______________________________________________________________");
		VisitorInfoUtility.getAllVisitorInfo();
		System.out.println("_______________________________________________________________");


		EntryPassServiceImpl entrypassServiceImpl = new EntryPassServiceImpl();
		List<EntryPass> entrypassList = entrypassServiceImpl.findAll();
		display();
		for (EntryPass entrypass : entrypassList) {

			System.out.println(entrypass.getPassid() + "	" + entrypass.getVisitorinfo().getVisitorId() + "		"
					+ entrypass.getCompanydetails().getCompanyId() + "		"
					+ entrypass.getStaffinformation().getStaffId() + "		" + entrypass.getTimeIn() + "		"
					+ entrypass.getTimeOut());
		}
		
	}

	public static void insertIntoEntryPass() {

		System.out.println("_______________________________________________________________");
		CompanyDetailsUtility.getAllCompanyDetails();
		System.out.println("_______________________________________________________________");
		StaffInformationUtility.getAllStaffDetails();
		System.out.println("_______________________________________________________________");
		VisitorInfoUtility.getAllVisitorInfo();
		System.out.println("_______________________________________________________________");

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into EntryPass ");
		System.out.println("Enter the PassID:");
		int passId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitorsID:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the visitor Time-IN:");
		String timeIn = scanner.nextLine();
		System.out.println("Enter the Visitor Time-OUT:");
		String timeOut = scanner.nextLine();

		VisitorInfo visitorinfo = new VisitorInfo();
		visitorinfo.setVisitorId(visitorId);

		CompanyDetails companydetails = new CompanyDetails();
		companydetails.setCompanyId(companyId);

		StaffInformation staffinformation = new StaffInformation();
		staffinformation.setStaffId(staffId);

		EntryPass entrypass = new EntryPass(passId, visitorinfo, companydetails, staffinformation, timeIn, timeOut);

		EntryPassServiceImpl entrypassServiceImpl = new EntryPassServiceImpl();
		entrypassServiceImpl.save(entrypass);

	}

	public static void updateIntoEntryPass() {

		System.out.println("_______________________________________________________________");
		CompanyDetailsUtility.getAllCompanyDetails();
		System.out.println("_______________________________________________________________");
		StaffInformationUtility.getAllStaffDetails();
		System.out.println("_______________________________________________________________");
		VisitorInfoUtility.getAllVisitorInfo();
		System.out.println("_______________________________________________________________");

		Scanner scanner = new Scanner(System.in);
		System.out.println("_________________ Updating into EntryPass __________________");
		System.out.println("Enter the PassID:");
		int passId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitorsID:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffID:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the visitor Time-IN:");
		String timeIn = scanner.nextLine();
		System.out.println("Enter the Visitor Time-OUT:");
		String timeOut = scanner.nextLine();

		// Setting foreignkey id to entrypass
		VisitorInfo visitorinfo = new VisitorInfo();
		visitorinfo.setVisitorId(visitorId);

		CompanyDetails companydetails = new CompanyDetails();
		companydetails.setCompanyId(companyId);

		StaffInformation staffinformation = new StaffInformation();
		staffinformation.setStaffId(staffId);

		EntryPass entrypass = new EntryPass(passId, visitorinfo, companydetails, staffinformation, timeIn, timeOut);

		EntryPassServiceImpl entrypassServiceImpl = new EntryPassServiceImpl();
		entrypassServiceImpl.update(entrypass);
	}

	public static void deleteFromEntryPass() {

		System.out.println("_______________________________________________________________");
		CompanyDetailsUtility.getAllCompanyDetails();
		System.out.println("_______________________________________________________________");
		StaffInformationUtility.getAllStaffDetails();
		System.out.println("_______________________________________________________________");
		VisitorInfoUtility.getAllVisitorInfo();
		System.out.println("_______________________________________________________________");

		Scanner scanner = new Scanner(System.in);
		System.out.println("________________ Deleting into EntryPass ___________________");
		System.out.println("Enter the VisitorsID:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();

		EntryPass entrypass = new EntryPass();
		entrypass.getPassid();

		EntryPassServiceImpl entrypassServiceImpl = new EntryPassServiceImpl();
		entrypassServiceImpl.save(entrypass);
	}

	public static void display() {
		System.out.println("___________________________________________________________________________________________");
		System.out.println("pass_id\t\tvisitor_id\tcompany_id\tstaff_id\ttime_IN\t\ttime_OUT");
		System.out.println("___________________________________________________________________________________________");
	}
}
