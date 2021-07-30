public class Track extends Vehicle{

    private double speedLimit;
    private double maxWeight;

    public Track() {
    }

    public Track(String vehicleNumber, String tradeName, int numberOfWheels, double prise, double fuelTankSize, double engineVolume, double speedLimit, double maxWeight) {
        super(vehicleNumber, tradeName, numberOfWheels, prise , fuelTankSize, engineVolume);
        this.speedLimit = speedLimit;
        this.maxWeight = maxWeight;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "\n---------------" + "\nTrack: " + super.toString() +
                "\n\tspeed Limit = " + speedLimit +
                "\n\tMax Weight = " + maxWeight;
    }
}
