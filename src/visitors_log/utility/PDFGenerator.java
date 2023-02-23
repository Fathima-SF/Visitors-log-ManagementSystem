package visitors_log.utility;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import visitors_log.entity.VisitingDetails;
import visitors_log.entity.VisitorInfo;
import visitors_log.service.VisitingDetailsServiceImpl;
import visitors_log.service.VisitorInfoServiceImpl;

public class PDFGenerator {

	public static void main(String[] args) {
		
		//menuDisplay();
		generateDetailsByDate();
	
	}
    
		public static void generateDetailsByDate() {

		String file_name = "D:\\visitorlog.pdf";
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();
			
			document.add (Image.getInstance("C:\\Users\\fathima pc\\Pictures\\images.jpeg"));
  
			Paragraph para = new Paragraph("___________Visitor-Details___________");
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

		   
			
			Scanner scanner = new Scanner(System.in);
		
			System.out.println("Enter the date to print:");
			String date = scanner.nextLine();			
	
			VisitingDetailsServiceImpl visitingdetailsServiceImpl = new VisitingDetailsServiceImpl();
		    List<VisitingDetails> visitingdetailsList =  visitingdetailsServiceImpl.generatePDF(date);
		    
		    Paragraph para1 = new Paragraph("______________________________________________________________");
			document.add(new Paragraph(" "));
			Paragraph para2 = new Paragraph("______________________________________________________________");
			document.add(new Paragraph(" "));   
			
			for (VisitingDetails visitingdetails : visitingdetailsList) {

			Paragraph Date = new Paragraph("Date :" + visitingdetails.getDate());	
			Paragraph visitor_id = new Paragraph("VisitorID :" + visitingdetails.getVisitorinfo().getVisitorId());
			Paragraph visitor_name = new Paragraph("VisitorName :" + visitingdetails.getVisitorinfo().getVisitorName());
    		Paragraph visitor_address = new Paragraph("VisitorAddress :" + visitingdetails.getVisitorinfo().getVisitorAddress());
			Paragraph visitor_phoneNo = new Paragraph("VisitorPhoneNo :" + visitingdetails.getVisitorinfo().getVisitorPhoneNo());
			Paragraph gender = new Paragraph("Gender :" + visitingdetails.getVisitorinfo().getGender());
			Paragraph vehicleNo = new Paragraph("Vehicle No :" + visitingdetails.getVisitorinfo().getVehicleNo());

			document.add(para);
			document.add(para1);
			document.add(Date);
			document.add(visitor_id);
			document.add(visitor_name);
			document.add(visitor_address);
			document.add(visitor_phoneNo);
			document.add(gender);
			document.add(vehicleNo);
			document.add(para2);
			}	
			
			
			
			System.out.println("PDF Generated...");

			document.close();
		} catch (Exception e) {
			//System.out.println("Date does't exist ");
			e.printStackTrace();
		}
		
	}
		
		public static void menuDisplay() {

			Scanner input = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("______________ VISITING-DETAILS _______________\n");
				System.out.println("1.Choose a Particular Date and Show VisitorDetails :");
				System.out.println("2. Exit");
				System.out.println("enter the choice :");
				choice = input.nextInt();

				switch (choice) {

				case 1:
					generateDetailsByDate();	
					break;
				
				case 2:
					System.out.println("_______________ All THE BEST THANK YOU _______________\n");
					condition = false;
					break;

				default:
					System.out.println("Invalid option, try again...\n");
				}

			} while (condition);
				
			}
}
	
