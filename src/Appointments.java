//Appointments is used for storing UPCOMING appointments
public class Appointments implements Comparable<Appointments>{
    private String date;
    private String time;
    private String patientUsername;
    private String doctorUsername;
    private String concern;
    private Boolean upcoming;

    //PAST APPOINTMENT VARIABLES
    private String concerns;
    private String bloodPressure;
    private float temperature;
    private String height;
    private String allergies;


    public String upcomingAppointmentToString() {
        return "Appointments{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", patientUsername='" + patientUsername + '\'' +
                ", doctorUsername='" + doctorUsername + '\'' +
                ", concern='" + concern + '\'' +
                ", upcoming=" + upcoming +
                '}';
    }

    public String pastAppointmentToString() {
        return "Appointments{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", patientUsername='" + patientUsername + '\'' +
                ", doctorUsername='" + doctorUsername + '\'' +
                ", concerns='" + concerns + '\'' +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", temperature=" + temperature +
                ", height='" + height + '\'' +
                ", allergies='" + allergies + '\'' +
                ", upcoming=" + upcoming +
                '}';
    }
    
    @Override
    public int compareTo(Appointments c){
        return (date + time).compareTo(c.getDate() + c.getTime());
    }

    public String getConcerns() {
        return concerns;
    }

    public void setConcerns(String concerns) {
        this.concerns = concerns;
    }
    
    public String getConcern() {
        return concern;
    }

    public void setConcern(String concerns) {
        this.concern = concerns;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
