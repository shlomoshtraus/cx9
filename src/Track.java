public class Track extends Vehicle{

    private boolean speedLimit;
    private double MaxWeight;

    public Track(int vehicleNumber, String tradeName, int numberOfWheels, int fuelTankSize, double engineVolume, boolean speedLimit, double maxWeight) {
        super(vehicleNumber, tradeName, numberOfWheels, fuelTankSize, engineVolume);
        this.speedLimit = speedLimit;
        MaxWeight = maxWeight;
    }

    public boolean isSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(boolean speedLimit) {
        this.speedLimit = speedLimit;
    }

    public double getMaxWeight() {
        return MaxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        MaxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "---------------\n" + super.toString() + "Track -> {" +
                "speed Limit = " + speedLimit +
                ", Max Weight = " + MaxWeight +
                '}';
    }
}
