public class Nurse{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String birthday;
    private String patients[];
    private String doctor;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String[] getPatients() {
        return patients;
    }

    public void setPatients(String[] patients) {
        this.patients = patients;
    }

    public String getDoctor() {
        return doctor;
    }
}
