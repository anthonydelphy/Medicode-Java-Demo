import java.util.List;

public class Patient {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private String birthday;
    private String doctor;
    public List<Precription> prescriptions;
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Precription> getPrescriptions() {
        return prescriptions;
    }

    //Returns individual prescription from prescription list
    public Precription getPrescription(int index) {
        return prescriptions.get(index);
    }

    //Returns full list of prescriptions.
    public List<Precription> getPrescriptionList() {
        return prescriptions;
    }

    public void setPrescriptions(List<Precription> prescriptions) {
        this.prescriptions = prescriptions;
    }

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

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
