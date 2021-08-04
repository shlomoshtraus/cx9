public class Car extends Vehicle{

    private String typeOfVehicle;
    private double horsepower;
    private boolean isThereRadio;

    public Car(String vehicleNumber, String tradeName, int numberOfWheels, double prise, double fuelTankSize, double engineVolume, String typeOfVehicle, double horsepower, boolean isThereRadio) {
        super(vehicleNumber, tradeName, numberOfWheels, prise, fuelTankSize, engineVolume);
        this.typeOfVehicle = typeOfVehicle;
        this.horsepower = horsepower;
        this.isThereRadio = isThereRadio;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }

    public boolean isThereRadio() {
        return isThereRadio;
    }

    public void setThereRadio(boolean thereRadio) {
        isThereRadio = thereRadio;
    }

    @Override
    public String toString() {
        return "\n---------------" + "\nCar: " +  super.toString() +
        "\n\ttype Of Vehicle = " + typeOfVehicle +
                "\n\thorsepower = " + horsepower +
                "\n\tIs There Radio = " + isThereRadio;
    }
}
