import java.util.List;

//This class file store the total amount of doctors. The JSON file will be mapped to this class and fill in
//as many doctors as needed.
public class Database{
        private List<Doctor> doctors;
        private List<Nurse> nurses;
        private List<Patient> patients;
        private List<Appointments> appointments;

        public List<Appointments> getAppointments() {
                return appointments;
        }

        public void setAppointments(List<Appointments> appointments) {
                this.appointments = appointments;
        }

        //Add a new patient account
        public void addPatient(Patient patient){
                patients.add(patient);
        }

        //Getters and setters for full list of doctors, nurses, and patients
        public List<Doctor> getDoctorsList() {
                return doctors;
        }

        public void setDoctorsList(List<Doctor> doctors) {
                this.doctors = doctors;
        }

        public List<Nurse> getNursesList() {
                return nurses;
        }

        public void setNurseList(List<Nurse> nurses) {
                this.nurses = nurses;
        }

        public List<Patient> getPatientList() {
                return patients;
        }

        public void setPatientList(List<Patient> patient) {
                this.patients = patient;
        }
}
