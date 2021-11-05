public class Precription {
    private String prescName;
    private String expDate;
    private int quantity;

    @Override
    public String toString() {
        return "Precription{" +
                "precriptionName='" + prescName + '\'' +
                ", experationDate='" + expDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getPrecriptionName() {
        return prescName;
    }

    public void setPrecriptionName(String name) {
        this.prescName = prescName;
    }

    public String getExperationDate() {
        return expDate;
    }

    public void setExperationDate(String date) {
        this.expDate = expDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
