import java.util.List;

public class Patient extends Person{

    private String doctor;
    public List<Prescription> prescriptions;

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    //Returns full list of prescriptions.
    public List<Prescription> getPrescriptionList() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

}
