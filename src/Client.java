public class Client {

    private int ID;
    private String customerName;
    private int howManyVehiclesDidHeBuy;
    private double howMuchMoney;

    public Client(int ID, String customerName, double howMuchMoney) {
        this.ID = ID;
        this.customerName = customerName;
        this.howMuchMoney = howMuchMoney;
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public double getHowMuchMoney() {
        return howMuchMoney;
    }

    public void setHowMuchMoney(double howMuchMoney) {
        this.howMuchMoney = howMuchMoney;
    }

    @Override
    public String toString() {
        return "---------------\n" + "Client -> {" +
                "\n\tID = " + ID +
                "\n\tcustomerName = " + customerName + '\'' +
                "\n\thow Many Vehicles DidHe Buy = " + howManyVehiclesDidHeBuy +
                "\n\thow Much Money Does He Have = " + howMuchMoney +
                '}';
    }
}
