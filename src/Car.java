public class Car extends Vehicle{

    private String typeOfVehicle;
    private double horsepower;
    private boolean IsThereRadio;

    public Car(int vehicleNumber, String tradeName, int numberOfWheels, double prise, int fuelTankSize, double engineVolume, String typeOfVehicle, double horsepower, boolean isThereRadio) {
        super(vehicleNumber, tradeName, numberOfWheels, prise, fuelTankSize, engineVolume);
        this.typeOfVehicle = typeOfVehicle;
        this.horsepower = horsepower;
        this.IsThereRadio = isThereRadio;
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
        return IsThereRadio;
    }

    public void setThereRadio(boolean thereRadio) {
        IsThereRadio = thereRadio;
    }

    @Override
    public String toString() {
        return "---------------\n" + super.toString() + "\nCar" +
                "\n\ttype Of Vehicle = " + typeOfVehicle +
                "\n\thorsepower = " + horsepower +
                "\n\tIs There Radio = " + IsThereRadio;
    }
}
