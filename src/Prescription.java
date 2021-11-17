public class Prescription {
    private String prescName;
    private String expDate;
    private int quantity;

    public Prescription(String prescName, String expDate, int quantity) {
        this.prescName = prescName;
        this.expDate = expDate;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Precription{" +
                "precriptionName='" + prescName + '\'' +
                ", experationDate='" + expDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }


}
