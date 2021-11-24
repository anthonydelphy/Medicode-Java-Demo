
import java.util.List;

public class Patient extends Person{

    private String doctor;
    public List<Prescription> prescriptionList;

    public List<Prescription> getPrescriptions() {
        return prescriptionList;
    }

    //Returns full list of prescriptions.
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptionList = prescriptions;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

}
