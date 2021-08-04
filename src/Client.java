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

    public int getID() {
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
        return "\n---------------\n" + "Client:"  +
                "\n\tId = " + ID +
                "\n\tCustomer name = " + customerName + '\'' +
                "\n\tHow Many vehicles did he buy = " + howManyVehiclesDidHeBuy +
                "\n\tHow much money does he have = " + howMuchMoney;
    }
}
