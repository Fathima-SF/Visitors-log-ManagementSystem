package visitors_log.entity;

public class VisitingDetails {
	
	private int registerId;
	private EntryPass entrypass;
	private VisitorInfo visitorinfo;
	private String date;
	private String visitingPurpose;
	
	public VisitingDetails(int registerId, EntryPass entrypass, VisitorInfo visitorinfo, String date,
			String visitingPurpose) {
		super();
		this.registerId = registerId;
		this.entrypass = entrypass;
		this.visitorinfo = visitorinfo;
		this.date = date;
		this.visitingPurpose = visitingPurpose;
	}


	public VisitingDetails() {
		super();
	}


	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public EntryPass getEntrypass() {
		return entrypass;
	}

	public void setEntrypass(EntryPass entrypass) {
		this.entrypass = entrypass;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVisitingPurpose() {
		return visitingPurpose;
	}

	public void setVisitingPurpose(String visitingPurpose) {
		this.visitingPurpose = visitingPurpose;
	}


	public VisitorInfo getVisitorinfo() {
		return visitorinfo;
	}


	public void setVisitorinfo(VisitorInfo visitorinfo) {
		this.visitorinfo = visitorinfo;
	}
	

}
