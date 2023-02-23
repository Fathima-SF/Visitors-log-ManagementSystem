package visitors_log.entity;

public class CompanyDetails {
	
	private int companyId;
	private String companyName;
	private String address;
	private String emailId;
	
	public CompanyDetails() {
		super();
	}

	public CompanyDetails(int companyId, String companyName, String address, String emailId) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.address = address;
		this.emailId = emailId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
