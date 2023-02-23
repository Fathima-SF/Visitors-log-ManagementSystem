package visitors_log.utility;

import java.util.List;
import java.util.Scanner;

import visitors_log.entity.CompanyDetails;
import visitors_log.entity.StaffInformation;
import visitors_log.service.CompanyDetailsServiceImpl;
import visitors_log.service.StaffInformationServiceImpl;

public class StaffInformationUtility {

	public static void main(String[] args) {

		menuDisplay();
		//getAllStaffDetails();
		//insertIntoStaffDetails();
		//updateIntoStaffInformation();
		//deleteFromStaffInformation();
		//getFindByStaffId();

	}

	private static void getFindByStaffId() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________Staff_Information_______________\n");
		System.out.println("Enter the StaffId to find :");
		int companyid = scanner.nextInt();
		
		StaffInformationServiceImpl staffdetailsServiceImpl = new StaffInformationServiceImpl();
		StaffInformation StaffInfo = staffdetailsServiceImpl.findById(companyid);
		
		System.out.println("__________________________________________________\n");
		System.out.println("_________company_details by id__________");
		System.out.println("StaffId : " + StaffInfo.getStaffId());
		System.out.println("StaffName : " + StaffInfo.getStaffName());
		System.out.println("StaffPosition : " + StaffInfo.getStaffPosition());
		System.out.println("Staff PhoneNo : " + StaffInfo.getstaffPhoneNo());
		System.out.println("__________________________________________________\n");

	}

	public static void menuDisplay() {

		Scanner input = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("___________________ STAFF_INFORMATION _________________\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Staff-Details");
			System.out.println("2. Add new Staff-Details");
			System.out.println("3. Edit Staff-Details");
			System.out.println("4. Delete Staff-Details");
	//		System.out.println("5. Find Details By Id");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllStaffDetails();
				System.out.println("\n");
				break;
			case 2: 	insertIntoStaffDetails();
						getAllStaffDetails();
				break;
			case 3: 	updateIntoStaffInformation();
						getAllStaffDetails();	
				break;

			case 4: 	deleteFromStaffInformation();
						getAllStaffDetails();
				break;
//			case 5:		getFindByStaffId();
//				break;
			case 5:
				System.out.println("_______________ All THE BEST THANK YOU ________________");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}

		} while (condition);

	}

	public static void getAllStaffDetails() {

		StaffInformationServiceImpl staffdetailsServiceImpl = new StaffInformationServiceImpl();
		List<StaffInformation> staffdetailsList = staffdetailsServiceImpl.findAll();
		display();
		for (StaffInformation staffdetails : staffdetailsList) {
			System.out.println(staffdetails.getStaffId() + "	" + staffdetails.getStaffName() + "		"
					+ staffdetails.getStaffPosition() + "			" + staffdetails.getstaffPhoneNo());
		}
	}

	public static void insertIntoStaffDetails() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("________________ Inserting into StaffInformation __________________");
		System.out.println("Enter the StaffId:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffName:");
		String staffName = scanner.nextLine();
		System.out.println("Enter the StaffPosition:");
		String staffPosition = scanner.nextLine();
		System.out.println("Enter the StaffPhoneNo:");
		String staffPhoneNo = scanner.nextLine();

		StaffInformation staffdetails = new StaffInformation(staffId, staffName, staffPosition, staffPhoneNo);
		StaffInformationServiceImpl staffdetailsServiceImpl = new StaffInformationServiceImpl();
		staffdetailsServiceImpl.save(staffdetails);

	}

	private static void updateIntoStaffInformation() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("__________________ Update into StaffInformation ___________________");
		System.out.println("Enter the StaffId:");
		int staffId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StaffName:");
		String staffName = scanner.nextLine();
		System.out.println("Enter the StaffPosition:");
		String staffPosition = scanner.nextLine();
		System.out.println("Enter the StaffPhoneNo:");
		String staffPhoneNo = scanner.nextLine();

		StaffInformation staffdetails = new StaffInformation(staffId, staffName, staffPosition, staffPhoneNo);
		StaffInformationServiceImpl staffdetailsServiceImpl = new StaffInformationServiceImpl();
		staffdetailsServiceImpl.update(staffdetails);

	}

	private static void deleteFromStaffInformation() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("_________________ Delete from StaffInformation __________________");
		System.out.println("Enter the StaffId:");
		int staffId = scanner.nextInt();
		scanner.nextLine();

		StaffInformation staffdetails = new StaffInformation();
		staffdetails.getStaffId();
		StaffInformationServiceImpl staffdetailsServiceImpl = new StaffInformationServiceImpl();
		staffdetailsServiceImpl.delete(staffdetails);

	}

	private static void display() {
		System.out.println("______________________________________________________________________________________");
		System.out.println("staff_id\tstaff_name\tstaff_position\t\tstaff_phoneNo");
		System.out.println("______________________________________________________________________________________");

	}

}
