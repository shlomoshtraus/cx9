import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
/ The program is designed for the management and sale of vehicles.
/ Written by Sloimy shtraus.
/ If you want to add vehicles use the function vehicles.add().
*/
public class Main {

    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static final ArrayList<Sales> sales = new ArrayList<>();
    private static final ArrayList<Client> clients = new ArrayList<>();
    private static final Admin admin = new Admin();
    private static final Scanner scan = new Scanner(System.in);
    private static boolean stopRunning = false;


    public static void main(String[] args) {

        int id, userChoice;

        addVehicles(); // Adds the Vehicles list.
        addClients(); // Adds the Clients list.

        while (true){
            System.out.println("\nHello\nPress 0 to exit the program:\nAre you a new client? \n\t 1 for yes and sign up. \n\t 2 for no and continue shopping.");
            userChoice = scan.nextInt();

            switch (userChoice) {

                case 0:
                    System.out.println("We would love to see you again");
                    System.exit(0);
                case 1:
                    addNewClient();
                    break;
                case 2:
                    System.out.println("Enter your id");
                    id = scan.nextInt();

                    if (checksManager(id)){
                        while (!stopRunning){
                            managerOptions();
                        }
                        stopRunning = false;
                        break;
                    }
                    else {
                        clientOptions(id);
                    }

                    break;
                default:
                    break;

            }
        }

    }


    // The method shows the options to the client.
    private static void clientOptions(int id) {

        if (vehicles.isEmpty()){// Checks that there are vehicles for sale.
            System.out.println("We're so sorry but there are currently no vehicles for sale.\n" +
                    "We would love to see you on another occasion.");
            System.exit(0);
        }

        int userSelection, choice;
        double clientMoney;
        String buy;

        Random rand = new Random(); // Used to create a different sale number for each sale.
        int saleNumber = rand.nextInt(36143) + 5338235;

        for (int i = 0; i < clients.size(); i++) {

            // Checks that the client does exist.
            if (clients.get(i).getID() == id) {

                clientMoney = clients.get(i).getHowMuchMoney();

                System.out.println("Select (the number) of one of the following vehicles");

                // Prints the list of vehicles.
                for (int j = 0; j < vehicles.size(); j++) {
                    System.out.println((j + 1) + ")\t " + vehicles.get(i).getClass().getName() + ": " +
                            "\n\t\tTrade name: " + vehicles.get(j).getTradeName());
                }

                System.out.println("What is your choice?");
                userSelection = scan.nextInt() - 1;

                // Checks that the selection is valid.
                if (userSelection < 0 || userSelection > vehicles.size() - 1) {
                    System.out.println("there is no car with this number!  try again.");
                    clientOptions(id);
                }

                System.out.println("You have selected vehicle #" + (userSelection + 1) + ".\n" +
                        "The vehicle details are:" + vehicles.get(userSelection).toString());

                // Checks that the buyer has enough money.
                if (clientMoney < vehicles.get(userSelection).getPrise()) {
                    System.out.println("Oh no. Looks like you do not have enough money to buy this car!\nChoose another:\n");
                    clientOptions(id);
                }

                System.out.println("Do you want to buy it?\n\tY/N");
                System.out.println(i+"  " + clients.size());
                buy = scan.next();

                // The buyer is interested in buying.
                if (buy.equals("Y") || buy.equals("y")) {

                    // Adds the sale to the sales list.
                    sales.add(new Sales(id, saleNumber, vehicles.get(userSelection).getVehicleNumber()));

                    //Updates the balance of money left to the customer
                    clients.get(i).setHowMuchMoney((clients.get(i).getHowMuchMoney()) - (vehicles.get(userSelection).getPrise()));

                    //Updates How Many Vehicles Did He Buy.
                    clients.get(i).setHowManyVehiclesDidHeBuy(clients.get(i).getHowManyVehiclesDidHeBuy() + 1);

                    // Removes the vehicle purchased from the vehicle list.
                    vehicles.remove(userSelection);

                    System.out.println("the sale has been done!");
                    System.out.println("pleasure to do business with you!");

                    return; // Intended for getting out of the loop
                } else { // The buyer is not interested in buying.
                    System.out.println("OK. It's your loss!");
                }

            }
            else { // There is no client with such an ID.

                if (i == (clients.size() - 1)) { // Checking that indeed the end of the list.

                    System.out.println("There is no user with such an ID!");
                    System.out.println("Choose one of the options:" +
                            "\n\t1) Try again." + "\n\t2) Sign up.");

                    choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter your id");
                            id = scan.nextInt();

                            if (checksManager(id)){
                                managerOptions();
                            }
                            else {
                                clientOptions(id);
                            }
                            break;
                        case 2:
                            addNewClient();
                            break;
                        default:
                            break;
                    }


                }


            }


        }


    }

    // This method returns whether this user is an administrator.
    private static boolean checksManager(int id){
        boolean isAdmin;

        isAdmin = id == admin.getAdminPassword();

        return isAdmin;
    }

    // This method adds a new client to the client list
    private static void addNewClient() {
        int id;
        String clientName;
        double howMuchMoney;

        System.out.println("Hello\nYou will immediately join the customer list.");
        System.out.println("Enter your id?");
        id = scan.nextInt();

        // Checks if there is already a client with such an ID.
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getID() == id) {
                System.out.println("There is a user with such an ID re-insert");
                id = scan.nextInt();
                i = 0;
            }
        }

        System.out.println("What is your name?");
        clientName = scan.next();
        System.out.println("How much money do you have?");
        howMuchMoney = scan.nextDouble();
        clients.add(new Client(id, clientName, howMuchMoney));
        System.out.println("You have successfully joined the clients list.");

    }

    // The method for displaying the management options in case the user manages.
    // The administrator password is in the Admin class.
    private static void managerOptions(){
        System.out.println("\n************************\n" + "Hello manager\nWhat do you want to do?" +
                "\n\t1) View client list" + "\n\t2) View vehicle list" +
                "\n\t3) View sales list" + "\n\t4) View how many sales there were" +
                "\n\t5) Change admin password" + "\n\t6) Return to the main menu");
        int managerChoice = scan.nextInt();

        // Checks that the selection is valid.
        if (managerChoice < 1 || managerChoice> 6){
            System.out.println("Invalid selection! try again");
            managerOptions();
        }

        switch (managerChoice){
            case 1:
                System.out.println(clients);break;
            case 2:
                System.out.println(vehicles);break;
            case 3:
                System.out.println(sales);break;
            case 4:
                System.out.println(Sales.getNumberOfSales());break;
            case 5:
                admin.setNewAdminPassword();break;
            case 6:
                stopRunning = true;
            default:
                break;
        }

    }

    // The method automatically adds vehicles to the vehicles arrayList.
    private static void addVehicles() {
        vehicles.add(new Track("HF28H9", "Volvo", 8, 82000, 325.0, 1500, 120, 32000));
        vehicles.add(new Track("Y3T54B", "Ford", 8, 110000, 340.5, 1800, 110, 40000));
        vehicles.add(new Track("J9UY38", "Toyota", 8, 70000, 300.0, 1450, 120, 35000));
        vehicles.add(new Track("L7U567", "Toyota", 8, 115000, 340.02, 1850, 140, 45000));
        vehicles.add(new Track("RJ8410", "Ford", 8, 90000, 280.0, 1900, 110, 34000));
        vehicles.add(new Car("MM5049", "Ferrari", 4, 150000, 72.8, 1600, "4*4",93, true));
        vehicles.add(new Car("IQ7238", "Mazda", 4, 80000, 62.5, 1300, "commercial vehicle",95, false));
        vehicles.add(new Car("SA8565", "BMW", 4, 120000, 70.0, 1800, "4*4",89, true));
        vehicles.add(new Car("PE1820", "Ford", 4, 97000, 65.3, 1500, "family car", 90, false));
        vehicles.add(new Car("WM1360", "Volvo", 4, 70000, 61.9, 1750, "mini", 87, true));
    }

    // The method automatically adds vehicles to the Clients arrayList.
    private static void addClients(){
        clients.add(new Client(4573856, "Avi", 1850543));
        clients.add(new Client(6912574, "Shlomo", 1990000));
        clients.add(new Client(2192583, "ana", 3562010));
        clients.add(new Client(9254635, "Moshe", 2120000));
        clients.add(new Client(3215796, "David", 3000000));
    }

}