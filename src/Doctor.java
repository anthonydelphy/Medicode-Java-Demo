import java.util.List;

public class Doctor extends Person{

    private String patients[];
    private String nurses[];


    public String[] getPatients() {
        return patients;
    }

    public void setPatients(String[] patients) {
        this.patients = patients;
    }

    public String getPatient(int index){
        return patients[index];
    }

    public String[] getNurses() {
        return nurses;
    }

    public void setNurses(String[] nurses) {
        this.nurses = nurses;
    }

}
