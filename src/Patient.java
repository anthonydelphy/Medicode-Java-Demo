
public class Patient extends User {

	private Visit visits[];
	private Records records;
	private Doctor doctor;
	
	public Patient(String _username, String _password, String _firstName, String _lastName, int _birthDay,
			int _birthMonth, int _birthYear, String _email, long _phoneNum) {
		super(_username, _password, _firstName, _lastName, _birthDay, _birthMonth, _birthYear, _email, _phoneNum);
		
	}
	
	public void addVisit(Visit visit) {
		
	}	
	
	public Records getRecords() {
		return records;
	}
	
	public void changeDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Doctor searchDoctor(String doctorName) {
		
	}
}
