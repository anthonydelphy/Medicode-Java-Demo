import java.util.Arrays;

public class Doctor extends Staff {
	
	private Nurse nurseList[]; 
	
	public Doctor(String _username, String _password, String _firstName, String _lastName, int _birthDay,
			int _birthMonth, int _birthYear, String _email, long _phoneNum) {
		super(_username, _password, _firstName, _lastName, _birthDay, _birthMonth, _birthYear, _email, _phoneNum);
		
	}
	
	public Nurse[] getNurseList() {
		return nurseList;
	}
	
	public void addNurse(Nurse nurse) {
		nurseList = Arrays.copyOf(nurseList, nurseList.length + 1);
		nurseList[nurseList.length - 1] = nurse;
	}
	
	public void editPerscriptions(Patient patient) {
		
	}
	
}
