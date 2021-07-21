public class Vehicle {

    private int vehicleNumber;
    private String tradeName;
    private int numberOfWheels;
    private double prise ;
    private double fuelTankSize;
    private double engineVolume;//   מחיר, גדול מיכל הדלק, נפח מנוע

    public Vehicle(int vehicleNumber, String tradeName, int numberOfWheels, double prise, int fuelTankSize, double engineVolume) {
        this.vehicleNumber = vehicleNumber;
        this.tradeName = tradeName;
        this.numberOfWheels = numberOfWheels;
        this.prise = prise;
        this.fuelTankSize = fuelTankSize;
        this.engineVolume = engineVolume;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public double getFuelTankSize() {
        return fuelTankSize;
    }

    public void setFuelTankSize(int fuelTankSize) {
        this.fuelTankSize = fuelTankSize;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "---------------\n" +"Vehicle" +
                "\n\tvehicleNumber = " + vehicleNumber +
                "\n\ttradeName = " + tradeName +
                "\n\tnumberOfWheels = " + numberOfWheels +
                "\n\tfuelTankSize = " + fuelTankSize +
                "\n\tengineVolume = " + engineVolume;
    }
}
