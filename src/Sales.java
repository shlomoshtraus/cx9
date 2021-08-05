public class Sales {

    private int clientId;
    private int saleNumber;
    private String vehicleId;
    private static int numberOfSales;

    public Sales(int clientId, int saleNumber, String vehicleId) {
        this.clientId = clientId;
        this.saleNumber = saleNumber;
        this.vehicleId = vehicleId;
        numberOfSales++;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public static int getNumberOfSales() {
        return numberOfSales;
    }

    public static void setNumberOfSales(int numberOfSales) {
        Sales.numberOfSales = numberOfSales;
    }

    @Override
    public String toString() {
        return "\n------------------" + "\nSales:" +
                "\n\tclientId = " + clientId +
                "\n\tsaleNumber = " + saleNumber +
                "\n\tvehicleId= " + vehicleId ;
    }
}
