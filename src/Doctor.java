import java.util.List;

public class Doctor extends person{

    private String patients[];
    private String nurses[];


    public String[] getPatients() {
        return patients;
    }

    public void setPatients(String[] patients) {
        this.patients = patients;
    }

    public String[] getNurses() {
        return nurses;
    }

    public void setNurses(String[] nurses) {
        this.nurses = nurses;
    }

}
