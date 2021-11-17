import java.util.List;

public class Patient extends person{

    private String doctor;
    public List<Precription> prescriptions;

    public List<Precription> getPrescriptions() {
        return prescriptions;
    }

    //Returns full list of prescriptions.
    public List<Precription> getPrescriptionList() {
        return prescriptions;
    }

    public void setPrescriptions(List<Precription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

}
