package visitors_log.entity;

public class EntryPass {
	
	private int passid;
	private VisitorInfo visitorinfo;
	private CompanyDetails companydetails;
	private StaffInformation staffinformation;
	private String timeIn;
	private String timeOut;
	
	public EntryPass() {
		super();
	}

	public EntryPass(int passid, VisitorInfo visitorinfo, CompanyDetails companydetails,
			StaffInformation staffinformation, String timeIn, String timeOut) {
		super();
		this.passid = passid;
		this.visitorinfo = visitorinfo;
		this.companydetails = companydetails;
		this.staffinformation = staffinformation;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	public EntryPass(int passid, VisitorInfo visitorinfo, String timeIn, String timeOut) {
		super();
		this.passid = passid;
		this.visitorinfo = visitorinfo;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	public int getPassid() {
		return passid;
	}

	public void setPassid(int passid) {
		this.passid = passid;
	}

	public VisitorInfo getVisitorinfo() {
		return visitorinfo;
	}

	public void setVisitorinfo(VisitorInfo visitorinfo) {
		this.visitorinfo = visitorinfo;
	}

	public CompanyDetails getCompanydetails() {
		return companydetails;
	}

	public void setCompanydetails(CompanyDetails companydetails) {
		this.companydetails = companydetails;
	}

	public StaffInformation getStaffinformation() {
		return staffinformation;
	}

	public void setStaffinformation(StaffInformation staffinformation) {
		this.staffinformation = staffinformation;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	
}
