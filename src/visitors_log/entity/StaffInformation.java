package visitors_log.entity;

public class StaffInformation {
	
	private int staffId;
	private String staffName;
	private String staffPosition;
	private String staffPhoneNo;
	

	public StaffInformation(int staffId, String staffName, String staffPosition, String staffPhoneNo) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPosition = staffPosition;
		this.staffPhoneNo = staffPhoneNo;
	}

	public StaffInformation() {
		super();
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPosition() {
		return staffPosition;
	}

	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}

	public String getstaffPhoneNo() {
		return staffPhoneNo;
	}

	public void setstaffPhoneNo(String staffPhoneNo) {
		this.staffPhoneNo = staffPhoneNo;
	}
	

}
