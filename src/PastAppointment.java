public class PastAppointment extends Appointments{
    private int weight; //Measured in Pounds
    private String height; //Stored in ft.in
    private float temp; //stored in farhenheit
    private String bloodPressure;
    private String allergies;
    private String healthConcerns;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getHealthConcerns() {
        return healthConcerns;
    }

    public void setHealthConcerns(String healthConcerns) {
        this.healthConcerns = healthConcerns;
    }

    @Override
    public String toString() {
        return "PastAppointment{" +
                "weight=" + weight +
                ", height='" + height + '\'' +
                ", temp=" + temp +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", allergies='" + allergies + '\'' +
                ", healthConcerns='" + healthConcerns + '\'' +
                '}';
    }
}
