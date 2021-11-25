import java.util.Arrays;
import java.util.List;

public class Doctor extends Person{

    private List<String> patients;
    private List<String> nurses;

    public List<String> getPatients() {
        return patients;
    }

    public void setPatients(List<String> patients) {
        this.patients = patients;
    }

    public List<String> getNurses() {
        return nurses;
    }

    public void setNurses(List<String> nurses) {
        this.nurses = nurses;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "patients=" + patients +
                ", nurses=" + nurses +
                '}';
    }
}
