
public class Nurse extends Staff {

	private String assignedDoctor;
	
	public Nurse(String _username, String _password, String _firstName, String _lastName, int _birthDay,
			int _birthMonth, int _birthYear, String _email, long _phoneNum) {
		super(_username, _password, _firstName, _lastName, _birthDay, _birthMonth, _birthYear, _email, _phoneNum);
		
	}
	
	public void createVisit(Visit visit) {
		
	}
	
	public void cancelVisit(Visit visit) {
		
	}
	
	public void logVitals(String vitals) {
		
	}
	
	public void logInfo(String info) {
		
	}
	
	public void displayPatientInfo(Patient patient) {
		
	}
	
	public void editRecords(Records records) {
		
	}
	
	public void editVisit(Visit visit) {
		
	}
	
	public void editPatient(Patient patient) {
		
	}

	public String getAssignedDoctor() {
		return assignedDoctor;
	}

	public void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}
}
