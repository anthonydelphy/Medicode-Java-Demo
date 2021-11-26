
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient extends Person{



    private String doctor;
    public List<Prescription> prescriptionList;

    public List<Prescription> getPrescriptions() {
        if(prescriptionList == null || prescriptionList.isEmpty()) {
            List<Prescription> temp = new ArrayList<>();
            return temp;
        }

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
