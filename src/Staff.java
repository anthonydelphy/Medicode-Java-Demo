
public class Staff extends User {

	private String patientList[];
	
	public Staff(String _username, String _password, String _firstName, String _lastName, int _birthDay,
			int _birthMonth, int _birthYear, String _email, long _phoneNum) {
		super(_username, _password, _firstName, _lastName, _birthDay, _birthMonth, _birthYear, _email, _phoneNum);
		
	}
	
	public Patient patientSearch(Patient patient) {
		
	}
}
