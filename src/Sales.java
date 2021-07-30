import java.util.ArrayList;

public class Sales {

    private ArrayList<Vehicle> cars = new ArrayList<>();

    private String vehicleNumber;
    private String tradeName;
    private int numberOfWheels;
    private double prise ;
    private double fuelTankSize;
    private double engineVolume;

    private boolean speedLimit;
    private double maxWeight;

    private String typeOfVehicle;
    private double horsepower;
    private boolean isThereRadio;

    public Sales() {
    }

    public ArrayList<Vehicle> getCars() {
        System.out.println("Enter the admin password");
        return cars;
    }

    void addCar(String vehicleNumber, String tradeName, int numberOfWheels, double prise, double fuelTankSize, double engineVolume, String typeOfVehicle, double horsepower, boolean isThereRadio){
         cars.add(new Car(vehicleNumber, tradeName, numberOfWheels, prise,  fuelTankSize, engineVolume, typeOfVehicle, horsepower, isThereRadio));
    }

    void addTrack(String vehicleNumber, String tradeName, int numberOfWheels, double prise, double fuelTankSize, double engineVolume, double speedLimit, double maxWeight){
        cars.add(new Track(vehicleNumber, tradeName, numberOfWheels, prise, fuelTankSize, engineVolume, speedLimit, maxWeight));
    }
}
