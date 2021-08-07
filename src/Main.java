import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static final ArrayList<Sales> sales = new ArrayList<>();
    private static final ArrayList<Client> clients = new ArrayList<>();
    private static final Admin admin = new Admin();
    private static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        int id;

        addVehicles();
        addClients();


            System.out.println("Hello\nAre you a new client? \n\t 1 for yes \n\t 2 for no");
            int userChoice = scan.nextInt();

            switch (userChoice){
                case 1:
                    addNewClient();
                    break;
                case 2:
                    System.out.println("Enter your id");
                    id = scan.nextInt();
                    if (id == admin.getAdminPassword()){
                        managerOptions();
                    }
                    else {
                        if (vehicles.isEmpty()){
                            System.out.println("We're so sorry but there are currently no vehicles for sale.\n" +
                                    "We would love to see you on another occasion.");
                        }
                        else{
                        clientOptions(id);
                        }
                    }
                default:
                    break;
            }
        }



    private static void addNewClient(){
        System.out.println("Enter your id");
        int id = scan.nextInt();
        System.out.println("What is your name");
        String customerName = scan.next();
        System.out.println("How much money do you have?");
        double howMuchMoney = scan.nextDouble();
        clients.add(new Client(id,customerName,howMuchMoney));
        clientOptions(id);
    }

    private static void clientOptions(int id){
        double clientMoney;
            for (int i = 0; i < clients.size(); i++){
                if(clients.get(i).getID() == id){
                    System.out.println("Select (the number) of one of the following vehicles");
                    for (int j = 0; j < vehicles.size(); j++) {
                        System.out.println("\t" + (j+1) + ")\t" + "Type of vehicle: " + vehicles.get(j).getClass().getName()
                                + "\n\t\tTrade name: " + vehicles.get(j).getTradeName());
                    }

                    clientMoney = clients.get(i).getHowMuchMoney();
                    System.out.println("What is your choice?");
                    int userSelection = scan.nextInt();
                    System.out.println("You have selected vehicle #" + userSelection + ".\n" +
                            "The vehicle details are:" + vehicles.get((userSelection -1)).toString());
                    System.out.println("Do you want to buy it?\tY/N");
                    String buy = scan.next();
                    if ("Y".equals(buy)){
                        if (vehicles.get((userSelection -1)).getPrise() <= clientMoney){
                            sales.add(new Sales(id,12345,vehicles.get((userSelection -1)).getVehicleNumber()));
                            vehicles.remove((userSelection -1));
                            clients.get(i).setHowMuchMoney(clients.get(i).getHowMuchMoney() - vehicles.get(userSelection-1).getPrise());
                            System.out.println(clients.get(i).getHowMuchMoney());
                        }
                        else {
                            System.out.println("Oh no. Looks like you do not have enough money to buy this car!\nChoose another:\n");
                            clientOptions(id);
                        }
                    }
                }
                else{
                    if (i == clients.size()-1){
                        System.out.println("There is no user with such an ID!");
                        System.out.println("Choose one of the options:" +
                                "\n\t1) Try again." +"\n\t2) Sign up.");
                        int choice = scan.nextInt();
                        switch (choice){
                            case 1:
                                System.out.println("Enter your id");
                                id = scan.nextInt();
                                if (id == admin.getAdminPassword()){
                                    managerOptions();
                                }
                                else {
                                    clientOptions(id);
                                }
                                break;
                            case 2:
                                addNewClient();
                            default:
                                break;
                        }
                    }
                }
            }

    }

    private static void managerOptions(){
        System.out.println("Hello manager\nWhat do you want to do?");
        System.out.println("\n\t1) View client list" + "\n\t2) View vehicle list" +
                "\n\t3) View sales list" + "\n\t4) Change admin password");
        int managerChoice = scan.nextInt();

        switch (managerChoice){
            case 1:
                System.out.println(clients);break;
            case 2:
                System.out.println(vehicles);break;
            case 3:
                System.out.println(sales);break;
            case 4:
                admin.setNewAdminPassword();break;
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
        vehicles.add(new Car("WM1360", "Volvo", 4, 40, 82.002, 2200, "mini", 20, true));
    }
    private static void addClients(){
        clients.add(new Client(31552568, "Gorge", 300));
        clients.add(new Client(21231355, "Jhon", 260));
        clients.add(new Client(31155353, "Olaf", 400));
        clients.add(new Client(13153135, "elza", 400));
        clients.add(new Client(12345678, "ana", 400));
    }


}
