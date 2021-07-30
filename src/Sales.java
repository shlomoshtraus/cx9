import java.util.ArrayList;
import java.util.Scanner;

public class Sales {

    private ArrayList<Vehicle> cars = new ArrayList<>();

    public Sales() {
    }

    public ArrayList<Vehicle> getCars() {
        return cars;
    }

    public void setCars() {
        System.out.println("What type of vehicle do you want to add?" +
                "\n\t Press 1 for a Car" +
                "\n\t Press 2 for a Track");

        Scanner s = new Scanner(System.in);
        int userSelection = s.nextInt();
        switch (userSelection){
            case 1:

        }
    }

    void addCar(String vehicleNumber, String tradeName, int numberOfWheels, double prise, double fuelTankSize, double engineVolume, String typeOfVehicle, double horsepower, boolean isThereRadio){
         cars.add(new Car(vehicleNumber, tradeName, numberOfWheels, prise,  fuelTankSize, engineVolume, typeOfVehicle, horsepower, isThereRadio));
    }

    void addTrack(String vehicleNumber, String tradeName, int numberOfWheels, double prise, double fuelTankSize, double engineVolume, boolean speedLimit, double maxWeight){
        cars.add(new Track(vehicleNumber, tradeName, numberOfWheels, prise, fuelTankSize, engineVolume, speedLimit, maxWeight));
    }
}
