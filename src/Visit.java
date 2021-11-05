
public class Visit {
	private String date;
	private Patient treatedPatient;
	private int weight;
	private int height;
	private double temp;
	private int bloodPressure;
	private String notes;
	
	public Visit(String _date, Patient _treatedPatient, int _weight, int _height, double _temp) {
		this.date = _date;
		this.treatedPatient = _treatedPatient;
		this.weight = _weight;
		this.height = _height;
		this.temp = _temp;
	}
	
	public void finishVisit() {
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTreatedPatient(Patient patient) {
		this.treatedPatient = patient;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getTemp() {
		return temp;
	}
	
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	public int getBP() {
		return bloodPressure;
	}
	
	public void setBP(int BP) {
		this.bloodPressure = BP;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
