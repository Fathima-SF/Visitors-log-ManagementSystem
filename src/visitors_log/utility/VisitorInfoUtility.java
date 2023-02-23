package visitors_log.utility;

import java.util.List;
import java.util.Scanner;

import visitors_log.entity.CompanyDetails;
import visitors_log.entity.VisitorInfo;
import visitors_log.service.CompanyDetailsServiceImpl;
import visitors_log.service.VisitorInfoServiceImpl;

public class VisitorInfoUtility {

	public static void main(String[] args) {

		menuDisplay();
		//getAllVisitorInfo();
		//insertIntoVisitorInfo();
		//updateIntoVisitorInfo();
		//deleteFromVisitorInfo();
		//getFindByVisitorId();
		
	}
	
	private static void getFindByVisitorId() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________Visitor_Info_______________\n");
		System.out.println("Enter the VisitorId to find :");
		int companyid = scanner.nextInt();
		
		VisitorInfoServiceImpl visitorinfoServiceImpl = new VisitorInfoServiceImpl();
		VisitorInfo VisitorInfo = visitorinfoServiceImpl.findById(companyid);
		System.out.println("__________________________________________________\n");
		System.out.println("_________Visitor_Info by id__________");
		System.out.println("VisitorId : " + VisitorInfo.getVisitorId());
		System.out.println("VisitorName : " + VisitorInfo.getVisitorName());
		System.out.println("VisitorAddress : " + VisitorInfo.getVisitorAddress());
		System.out.println("VisitorPhoneNo : " + VisitorInfo.getVisitorPhoneNo());
		System.out.println("Gender : " + VisitorInfo.getGender());
		System.out.println("VehicleNo : " + VisitorInfo.getVehicleNo());
		System.out.println("__________________________________________________\n");

		
	}

	public static void menuDisplay() {

		Scanner input = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("______________ VISITOR_INFO ________________\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Visitor-Details");
			System.out.println("2. Add new Visitor-Details");
			System.out.println("3. Edit Visitor-Details");
			System.out.println("4. Delete Visitor-Details");
//			System.out.println("5. Find Details By ID");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllVisitorInfo();
				;
				System.out.println("\n");
				break;
			case 2: 	insertIntoVisitorInfo();
						getAllVisitorInfo();
				break;
			case 3: 	updateIntoVisitorInfo();
						getAllVisitorInfo();
				break;

			case 4:		deleteFromVisitorInfo();
						getAllVisitorInfo();
				break;
	//		case 5:     getFindByVisitorId();
	//			break;
			case 6:
				System.out.println("_______________ All THE BEST THANK YOU _______________");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again...\n");
			}

		} while (condition);

	}
	
	public static void getAllVisitorInfo() {

		VisitorInfoServiceImpl visitorinfoServiceImpl = new VisitorInfoServiceImpl();
		List <VisitorInfo> visitorinfoList = visitorinfoServiceImpl.findAll();
		display();
		for (VisitorInfo visitorinfo : visitorinfoList) {
			System.out.println( visitorinfo.getVisitorId() + "       	"+visitorinfo.getVisitorName() + "			" + visitorinfo.getVisitorAddress()
			+ "         	 " + visitorinfo.getVisitorPhoneNo() + "          " + visitorinfo.getGender() + "     " + visitorinfo.getVehicleNo() + "     ");
		}
	}

	public static void insertIntoVisitorInfo() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________ Inserting into VisitorInfo _______________");
		System.out.println("Enter the VisitorId:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitorName:");
		String visitorName = scanner.nextLine();
		System.out.println("Enter the VisitorAddress:");
		String visitorAddress = scanner.nextLine();
		System.out.println("Enter the VisitorPhoneNo:");
		String visitorPhoneNo = scanner.nextLine();
		System.out.println("Enter the Gender:");
		String gender = scanner.nextLine();
		System.out.println("Enter the VehicleNo :");
		String vehicleNo = scanner.nextLine();
		
		VisitorInfo visitorinfo = new VisitorInfo(visitorId,visitorName,visitorAddress,visitorPhoneNo,gender,vehicleNo);
		VisitorInfoServiceImpl visitorinfoServiceImpl = new VisitorInfoServiceImpl();
		visitorinfoServiceImpl.save(visitorinfo);
	}
	
	private static void updateIntoVisitorInfo() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("_______________ Updating into VisitorInfo ________________");
		System.out.println("Enter the VisitorId:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the VisitorName:");
		String visitorName = scanner.nextLine();
		System.out.println("Enter the VisitorAddress:");
		String visitorAddress = scanner.nextLine();
		System.out.println("Enter the VisitorPhoneNo:");
		String visitorPhoneNo = scanner.nextLine();
		System.out.println("Enter the Gender:");
		String gender = scanner.nextLine();
		System.out.println("Enter the VehicleNo :");
		String vehicleNo = scanner.nextLine();
		
		VisitorInfo visitorinfo = new VisitorInfo(visitorId,visitorName,visitorAddress,visitorPhoneNo,gender,vehicleNo);
		VisitorInfoServiceImpl visitorinfoServiceImpl = new VisitorInfoServiceImpl();
		visitorinfoServiceImpl.update(visitorinfo);
		
	}
	
	private static void deleteFromVisitorInfo() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("_______________ Deleting into VisitorInfo _______________");
		System.out.println("Enter the VisitorId:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();
		
		VisitorInfo visitorinfo = new VisitorInfo();
		 visitorinfo.getVisitorId();
		VisitorInfoServiceImpl visitorinfoServiceImpl = new VisitorInfoServiceImpl();
		visitorinfoServiceImpl.delete(visitorinfo);
		
	}
	
	private static void display() {
		System.out.println("_________________________________________________________________________________________________________");
		System.out.println("visitor_id\tvisitor_name\tvisitor_address\t\tvisitor_phoneNo\t\tgender\tVehicle_No");
		System.out.println("_________________________________________________________________________________________________________");

	}

}
