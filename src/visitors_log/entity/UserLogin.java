package visitors_log.entity;

public class UserLogin {
	
	private int loginId;
	private String username;
	private String password;
	
	public UserLogin(int loginId, String username, String password) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
	}
	
	public UserLogin() {
		super();
	}

	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
