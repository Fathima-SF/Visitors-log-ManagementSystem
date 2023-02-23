package visitors_log.entity;

public class BlockDetails {
	
	private int blockid;
	private String blockname;
	private CompanyDetails companydetails;
	
	public BlockDetails(int blockid, String blockname, CompanyDetails companydetails) {
		super();
		this.blockid = blockid;
		this.blockname = blockname;
		this.companydetails = companydetails;
	}

	public BlockDetails() {
		super();
	}

	public int getBlockid() {
		return blockid;
	}

	public void setBlockid(int blockid) {
		this.blockid = blockid;
	}

	public String getBlockname() {
		return blockname;
	}

	public void setBlockname(String blockname) {
		this.blockname = blockname;
	}


	public CompanyDetails getCompanydetails() {
		return companydetails;
	}

	public void setCompanydetails(CompanyDetails companydetails) {
		this.companydetails = companydetails;
	}

}
