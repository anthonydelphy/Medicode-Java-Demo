import java.util.List;

public class Nurse extends Person{

    private List<String> patients;
    private String doctor;

    public List<String> getPatients() {
        return patients;
    }

    public void setPatients(List<String> patients) {
        this.patients = patients;
    }

    public String getDoctor() {
        return doctor;
    }


}
