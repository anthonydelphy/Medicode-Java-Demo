
public class Prescription {
    private String prescName;
    private String expDate;
    private int quantity;

    public Prescription(String prescName, String expDate, int quantity) {
        this.prescName = prescName;
        this.expDate = expDate;
        this.quantity = quantity;
    }
    
    public String getPrescName(){
        return prescName;
    }
    
    public String getExpDate(){
        return expDate;
    }
    
    public int getQuantity(){
        return quantity;
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
