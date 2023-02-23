package visitors_log.utility;

import java.util.List;
import java.util.Scanner;
import visitors_log.entity.CompanyDetails;
import visitors_log.service.CompanyDetailsServiceImpl;

public class CompanyDetailsUtility {

	public static void main(String[] args) {

		//getAllCompanyDetails();
		// insertIntoCompanyDetails();
		// updateIntoCompanyDetails();
		//deleteIntoCompanyDetails();
		//getFindByCompanyId();
			menuDisplay();

	}

	private static void getFindByCompanyId() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________ Company_Details _______________\n");
		System.out.println("Enter the companyId to find :");
		int companyid = scanner.nextInt();
		
		CompanyDetailsServiceImpl companydetailsServiceImpl = new CompanyDetailsServiceImpl();
		CompanyDetails companydetails = companydetailsServiceImpl.findById(companyid);
		
		System.out.println("__________________________________________________\n");
		System.out.println("_________ company_details by id __________");
		System.out.println("CompanyId : " + companydetails.getCompanyId());
		System.out.println("CompanyName : " + companydetails.getCompanyName());
		System.out.println("CompanyAddress : " + companydetails.getAddress());
		System.out.println("Email id : " + companydetails.getEmailId());
		System.out.println("__________________________________________________\n");

		
	}

	public static void menuDisplay() {
		
			Scanner input = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("_____________ Company_Details _______________");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Company-Details");
				System.out.println("2. Add new Companies");
				System.out.println("3. Edit Company Details");
				System.out.println("4. Delete Company-Details");
		//		System.out.println("5. Find Details By Id");
				System.out.println("5. Exit");

				System.out.print("Enter your choice: ");
				choice = input.nextInt();

				switch (choice) {

				case 1:
					getAllCompanyDetails();
;
					System.out.println("\n");
					break;
				case 2: 	insertIntoCompanyDetails();
							getAllCompanyDetails();
					break;
				case 3: 	updateIntoCompanyDetails();
							getAllCompanyDetails();
					break;

				case 4: 	deleteIntoCompanyDetails();
							getAllCompanyDetails();	
					break;
//				case 5:    getFindByCompanyId();
//					break;
				case 5:
					System.out.println("______________ All THE BEST THANK YOU _____________");
					condition = false;
					break;

				default:
					System.out.println("Invalid option, try again...\n");
				}

			} while (condition);
		
		
	}

	public static void getAllCompanyDetails() {

		CompanyDetailsServiceImpl companydetailsServiceImpl = new CompanyDetailsServiceImpl();
		List<CompanyDetails> companydetailsList = companydetailsServiceImpl.findAll();
		display();
		for (CompanyDetails companydetails : companydetailsList) {	
			System.out.println(companydetails.getCompanyId() + "		" + companydetails.getCompanyName() + "		"
					+ companydetails.getAddress() + "		" + companydetails.getEmailId());
		}
	}

	public static void insertIntoCompanyDetails() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________ Inserting into CompanyDetails ___________");
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CompanyName:");
		String companyName = scanner.nextLine();
		System.out.println("Enter the Address:");
		String address = scanner.nextLine();
		System.out.println("Enter the Email_Id:");
		String emailId = scanner.nextLine();

		CompanyDetails companydetails = new CompanyDetails(companyId, companyName, address, emailId);
		CompanyDetailsServiceImpl companydetailsServiceImpl = new CompanyDetailsServiceImpl();
		companydetailsServiceImpl.save(companydetails);

	}

	private static void updateIntoCompanyDetails() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("______________ Update into CompanyDetails _____________");
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the CompanyName:");
		String companyName = scanner.nextLine();
		System.out.println("Enter the Address:");
		String address = scanner.nextLine();
		System.out.println("Enter the Email_Id:");
		String emailId = scanner.nextLine();

		CompanyDetails companydetails = new CompanyDetails(companyId, companyName, address, emailId);
		CompanyDetailsServiceImpl companydetailsServiceImpl = new CompanyDetailsServiceImpl();
		companydetailsServiceImpl.update(companydetails);

	}

	private static void deleteIntoCompanyDetails() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("_____________ Delete into CompanyDetails _______________");
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();

		CompanyDetails companydetails = new CompanyDetails();
		companydetails.setCompanyId(companyId);
		CompanyDetailsServiceImpl companydetailsServiceImpl = new CompanyDetailsServiceImpl();
		companydetailsServiceImpl.delete(companydetails);

	}
	private static void display() {
		System.out.println("____________________________________________________________________________________________");
		System.out.println("company_id\tcompany_name\taddress\t\t\temail_id");
		System.out.println("____________________________________________________________________________________________");

		
	}

}
