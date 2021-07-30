public class Track extends Vehicle{

    private boolean speedLimit;
    private double maxWeight;

    public Track() {
    }

    public Track(String vehicleNumber, String tradeName, int numberOfWheels, double prise, double fuelTankSize, double engineVolume, boolean speedLimit, double maxWeight) {
        super(vehicleNumber, tradeName, numberOfWheels, prise , fuelTankSize, engineVolume);
        this.speedLimit = speedLimit;
        this.maxWeight = maxWeight;
    }

    public boolean isSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(boolean speedLimit) {
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
        return "---------------\n" + super.toString() + "Track" +
                "\n\tspeed Limit = " + speedLimit +
                "\n\tMax Weight = " + maxWeight;
    }
}
