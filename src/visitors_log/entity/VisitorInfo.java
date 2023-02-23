package visitors_log.entity;

public class VisitorInfo {
	
	private int visitorId;
	private String visitorName;
	private String visitorAddress;
	private String visitorPhoneNo;
	private String gender;
	private String vehicleNo;
	
	
	public VisitorInfo(int visitorId, String visitorName, String visitorAddress, String visitorPhoneNo, String gender,
			String vehicleNo) {
		super();
		this.visitorId = visitorId;
		this.visitorName = visitorName;
		this.visitorAddress = visitorAddress;
		this.visitorPhoneNo = visitorPhoneNo;
		this.gender = gender;
		this.vehicleNo = vehicleNo;
	}

	public VisitorInfo() {
		super();
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorAddress() {
		return visitorAddress;
	}

	public void setVisitorAddress(String visitorAddress) {
		this.visitorAddress = visitorAddress;
	}

	public String getVisitorPhoneNo() {
		return visitorPhoneNo;
	}

	public void setVisitorPhoneNo(String visitorPhoneNo) {
		this.visitorPhoneNo = visitorPhoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	

}
