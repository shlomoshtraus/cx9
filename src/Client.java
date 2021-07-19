public class Client {

    private long ID;
    private String customerName;
    private int howManyVehiclesDidHeBuy;
    private double howMuchMoneyDoesHeHave;

    public Client(long ID, String customerName, int howManyVehiclesDidHeBuy, double howMuchMoneyDoesHeHave) {
        this.ID = ID;
        this.customerName = customerName;
        this.howManyVehiclesDidHeBuy = howManyVehiclesDidHeBuy;
        this.howMuchMoneyDoesHeHave = howMuchMoneyDoesHeHave;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getHowManyVehiclesDidHeBuy() {
        return howManyVehiclesDidHeBuy;
    }

    public void setHowManyVehiclesDidHeBuy(int howManyVehiclesDidHeBuy) {
        this.howManyVehiclesDidHeBuy = howManyVehiclesDidHeBuy;
    }

    public double getHowMuchMoneyDoesHeHave() {
        return howMuchMoneyDoesHeHave;
    }

    public void setHowMuchMoneyDoesHeHave(double howMuchMoneyDoesHeHave) {
        this.howMuchMoneyDoesHeHave = howMuchMoneyDoesHeHave;
    }

    @Override
    public String toString() {
        return "---------------\n" + "Client -> {" +
                "\n\tID = " + ID +
                "\n\tcustomerName = " + customerName + '\'' +
                "\n\thow Many Vehicles DidHe Buy = " + howManyVehiclesDidHeBuy +
                "\n\thow Much Money Does He Have = " + howMuchMoneyDoesHeHave +
                '}';
    }
}
