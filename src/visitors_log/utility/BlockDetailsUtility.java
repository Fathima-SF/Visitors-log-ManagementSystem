package visitors_log.utility;

import java.util.List;
import java.util.Scanner;

import visitors_log.entity.BlockDetails;
import visitors_log.entity.CompanyDetails;
import visitors_log.entity.StaffInformation;
import visitors_log.entity.VisitorInfo;
import visitors_log.service.BlockDetailsServiceImpl;

public class BlockDetailsUtility {

	public static void main(String[] args) {

		menuDisplay();
		//getAllBlockDetails();
		//insertIntoBlockDetails();
		//updateIntoBlockDetails();
		//deleteFromBlockDetails();
		//getFindByBlockId();
		
	}

	private static void getFindByBlockId() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("____________ Block-Details ___________");
		System.out.println("Enter the block Id to Find:");
		int blockid = in.nextInt();
		
		BlockDetailsServiceImpl blockdetailsServiceImpl = new BlockDetailsServiceImpl();
		BlockDetails blockdetails = blockdetailsServiceImpl.findById(blockid);
		display();
		if (blockdetails != null) {		
			System.out.println(blockdetails.getBlockid() + "		" + blockdetails.getBlockname() + "		"
					 + "" + blockdetails.getCompanydetails().getCompanyId());
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
			System.out.println("________________ BLOCKDETAILS __________________\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Block-Details");
			System.out.println("2. Add new Block-Details");
			System.out.println("3. Update Block-Details");
			System.out.println("4. Delete Block-Details");
	//		System.out.println("5. Find Details By Id");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllBlockDetails();
				
				System.out.println("\n");
				break;
			case 2: 	insertIntoBlockDetails();
						getAllBlockDetails();
				break;
			case 3: 	updateIntoBlockDetails();
						getAllBlockDetails();
				break;

			case 4:     deleteFromBlockDetails();
						getAllBlockDetails();
				break;
	//		case 5:    getFindByBlockId();
	//		break;
			case 5:
				System.out.println("_______________ All THE BEST THANK YOU ________________\n");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again...\n");
			}

		} while (condition);

	}
	
	private static void getAllBlockDetails() {

		
		BlockDetailsServiceImpl blockdetailsServiceImpl = new BlockDetailsServiceImpl();
		List<BlockDetails> blockdetailsList = blockdetailsServiceImpl.findAll();
		display();
		for (BlockDetails blockdetails : blockdetailsList) {

			System.out.println(blockdetails.getBlockid() + "		" + blockdetails.getBlockname() + "		"
					 + "" + blockdetails.getCompanydetails().getCompanyId());
		}

	}

	private static void insertIntoBlockDetails() {

		System.out.println("_______________________________________________________________________________________");
		CompanyDetailsUtility.getAllCompanyDetails();
		System.out.println("_______________________________________________________________________________________");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into BlockDetails***********************");
		System.out.println("Enter the blockID:");
		int passId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the blockName:");
		String blockName = scanner.nextLine();
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		
		CompanyDetails companydetails = new CompanyDetails();
		companydetails.setCompanyId(companyId);

		BlockDetails blockdetails = new BlockDetails(passId, blockName, companydetails);

		BlockDetailsServiceImpl blockdetailsServiceImpl = new BlockDetailsServiceImpl();
		blockdetailsServiceImpl.save(blockdetails);

	}

	private static void updateIntoBlockDetails() {

		System.out.println("_______________________________________________________________________________________");
		CompanyDetailsUtility.getAllCompanyDetails();
		System.out.println("_______________________________________________________________________________________");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Updating into BlockDetails***********************");
		System.out.println("Enter the blockID:");
		int passId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the blockName:");
		String blockName = scanner.nextLine();
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		
		// Setting foreignkey id to entrypass

		CompanyDetails companydetails = new CompanyDetails();
		companydetails.setCompanyId(companyId);

		BlockDetails blockdetails = new BlockDetails(passId, blockName, companydetails);

		BlockDetailsServiceImpl blockdetailsServiceImpl = new BlockDetailsServiceImpl();
		blockdetailsServiceImpl.update(blockdetails);

	}

	private static void deleteFromBlockDetails() {

		System.out.println("_______________________________________________________________________________________");
		CompanyDetailsUtility.getAllCompanyDetails();
		System.out.println("_______________________________________________________________________________________");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Delete from BlockDetails***********************");
		System.out.println("Enter the VisitorsID:");
		int visitorId = scanner.nextInt();
		scanner.nextLine();

		BlockDetails blockdetails = new BlockDetails();
		blockdetails.getBlockid();

		BlockDetailsServiceImpl blockdetailsServiceImpl = new BlockDetailsServiceImpl();
		blockdetailsServiceImpl.delete(blockdetails);

	}

	private static void display() {
		System.out.println("______________________________________________________");
		System.out.println("block_id\tblock_name\tcompany_id");
		System.out.println("______________________________________________________");
	}
}
