import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static ArrayList<Sales> sales = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();

    public static void main(String[] args) {

        int userSelection;
        addVehicles();
        addClients();
        System.out.println("Hello\nAre you a new client? \n\t 1 for yes \n\t 2 for no");
        Scanner scan = new Scanner(System.in);
        int userChoice = scan.nextInt();
        int id;
        switch (userChoice){
            case 1:
                System.out.println("Enter your id");
                id = scan.nextInt();
                System.out.println("what is your name");
                String customerName = scan.next();
                System.out.println("How much money do you have?");
                double howMuchMoney = scan.nextDouble();
                clients.add(new Client(id,customerName,howMuchMoney));
                break;
            case 2:
                System.out.println("Enter your id");
                id = scan.nextInt();
                for (int i = 0; i < clients.size(); i++){
                    if(clients.get(i).getID() == id){
                        System.out.println("Select (the number) of one of the following vehicles");
                        for (int j = 0; j < vehicles.size(); j++) {
                            System.out.println("\t" + (j+1) + ")\t" + "Type of vehicle: " + vehicles.get(j).getClass().getName()
                                    + "\n\t\tTrade name: " + vehicles.get(j).getTradeName());
                        }
                        break;
                    }
                    else{
                        if(i == clients.size()){
                            System.out.println("There is no user with such an ID!");
                            System.out.println("If you want to sign up. Run the program again!");
                            System.exit(0);
                        }
                    }
                }
                System.out.println("What is your choice?");
                userSelection = scan.nextInt();
                System.out.println("You have selected vehicle #" + userSelection + ".\n" +
                        "The vehicle details are:" + vehicles.get((userSelection-1)).toString());
        }

    }

    private static void addVehicles() {
        vehicles.add(new Track("HF7299", "scaina", 8, 52, 212.002, 1800, 120, 3));
        vehicles.add(new Track("YS7637", "scaina", 8, 52, 242.002, 1800, 110, 3));
        vehicles.add(new Track("JC6838", "scaina", 8, 52, 259.002, 1800, 120, 3));
        vehicles.add(new Track("LR6267", "BMW", 8, 52, 150.002, 3200, 140, 3));
        vehicles.add(new Track("RC2410", "BMW", 8, 52, 123.002, 3200, 1009, 3));
        vehicles.add(new Car("MM5049", "ford", 4, 52, 132.002, 1800, "4*4", 2, true));
        vehicles.add(new Car("IQ7238", "mazda", 4, 62, 122.002, 1200, "sadden", 2, false));
        vehicles.add(new Car("SA8565", "ford", 4, 52, 72.002, 1800, "4*4", 2, true));
        vehicles.add(new Car("PE1820", "mazda", 4, 62, 92.002, 1200, "sadden", 2, false));
        vehicles.add(new Car("WM1360", "Volvo", 4, 32, 82.002, 2200, "mini", 20, true));
    }
    private static void addClients(){
        clients.add(new Client(31552568, "Gorge", 300.05f));
        clients.add(new Client(21231355, "Jhon", 260.05f));
        clients.add(new Client(31155353, "Olaf", 400));
        clients.add(new Client(13153135, "elza", 400));
        clients.add(new Client(56831202, "ana", 400));
    }

}
