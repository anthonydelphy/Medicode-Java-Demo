//Appointments is used for storing UPCOMING appointments
public class Appointments {
    private String date;
    private String time;

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


    public String upcomingAppointmentToString() {
        return "Appointments{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
