package Site.Spring.Controller;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class RegisterForm {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
    private String password;
    private String confirmedPassword;
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
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
		@Override
		public String toString() {
			return "RegisterForm [username=" + username + ", password=" + password + ", confirmedPassword="
					+ confirmedPassword + "]";
		}
		public RegisterForm(String username, String password, String confirmedPassword) {
			super();
			this.username = username;
			this.password = password;
			this.confirmedPassword = confirmedPassword;
		}
	    

}
