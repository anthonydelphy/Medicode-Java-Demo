
public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private String email;
	private long phoneNum;
	private Message messages[];
		
	public User(String _username, String _password, String _firstName, String _lastName, int _birthDay,
			int _birthMonth, int _birthYear, String _email, long _phoneNum) {
		this.username = _username;
		this.password = _password;
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.birthDay = _birthDay;
		this.birthMonth = _birthMonth;
		this.birthYear = _birthYear;
		this.email = _email;
		this.phoneNum = _phoneNum;
	}
	
	public void Login() {
		
	}
	
	public void Logout() {
		
	}
	
	public void setEmail(String _email) {
		this.email = _email;
	}
	
	public void setPhoneNum(long _phoneNum) {
		this.phoneNum = _phoneNum;
	}
	
	public Message[] getMessages() {
		return messages;
	}
}
