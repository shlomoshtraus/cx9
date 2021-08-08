import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

 /*
 / The program is designed for the management and sale of vehicles.
 / Written by Sloimy shtraus.
 */
public class Main {

    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static final ArrayList<Sales> sales = new ArrayList<>();
    private static final ArrayList<Client> clients = new ArrayList<>();
    private static final Admin admin = new Admin();
    private static final Scanner scan = new Scanner(System.in);
    private static boolean stopRunning = true;

    public static void main(String[] args) {

        int id;

        addVehicles(); // Adds the Vehicles list
        addClients(); // Adds the Clients list

        do {
            System.out.println("\nPress 0 to exit the program:\nHello\n Are you a new client? \n\t 1 for yes. \n\t 2 for no.");
            int userChoice = scan.nextInt();

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
                    if (id == admin.getAdminPassword()) { //Checks if it's the manager.
                        do{
                            stopRunning = true;
                            managerOptions();
                        }while (stopRunning); // Displays the management options until the manager presses 5.
                    } else
                    {
                        if (vehicles.isEmpty()) { // Checks that there are vehicles for sale.
                            System.out.println("We're so sorry but there are currently no vehicles for sale.\n" +
                                    "We would love to see you on another occasion.");
                        } else {
                            clientOptions(id);
                        }
                    }
                default:
                    break;
            }
        }while (true); // The loop ran until the user pressed 0.
    }



    private static void addNewClient(){
        System.out.println("Hello\nYou will immediately join the customer list.");
        System.out.println("Enter your id?");
        int id = scan.nextInt();

        // Checks if there is already a client with such an ID.
        for (int i = 0; i < clients.size(); i++) {
            if (id == clients.get(i).getID()){
                System.out.println("There is a user with such an ID re-insert");
                id = scan.nextInt();
                i = 0;
            }
        }

        System.out.println("What is your name?");
        String customerName = scan.next();
        System.out.println("How much money do you have?");
        double howMuchMoney = scan.nextDouble();
        clients.add(new Client(id,customerName,howMuchMoney));
        System.out.println("You have successfully joined the customer list.");
        clientOptions(id); // Shows the purchase options to the new client.
    }

    // The method shows the options to the client.
    private static void clientOptions(int id){
        double clientMoney;

        Random rand = new Random(); // Used to create a different sale number for each sale.
        int saleNumber = rand.nextInt(36143)+5338235;

        for (int i = 0; i < clients.size(); i++){ // Checks that the customer does exist.
            if(clients.get(i).getID() == id){
                System.out.println("Select (the number) of one of the following vehicles");

                // Prints the list of vehicles.
                for (int j = 0; j < vehicles.size(); j++) {
                    System.out.println("\t" + (j+1) + ")\t" + "Type of vehicle: " + vehicles.get(j).getClass().getName()
                            + "\n\t\tTrade name: " + vehicles.get(j).getTradeName());
                }

                clientMoney = clients.get(i).getHowMuchMoney();
                System.out.println("What is your choice?");
                int userSelection = scan.nextInt();
                if (userSelection < vehicles.size() || userSelection > vehicles.size()){
                    System.out.println("there is no car with this number\t try again");
                    clientOptions(id);
                }
                System.out.println("You have selected vehicle #" + userSelection + ".\n" +
                        "The vehicle details are:" + vehicles.get((userSelection -1)).toString());
                System.out.println("Do you want to buy it?\tY/N");
                String buy = scan.next();

                if ("Y".equals(buy) || "y".equals(buy)){
                    if (vehicles.get((userSelection -1)).getPrise() <= clientMoney){
                        sales.add(new Sales(id,saleNumber,vehicles.get((userSelection -1)).getVehicleNumber()));

                        //Updates the balance of money left to the customer
                        clients.get(i).setHowMuchMoney(clients.get(i).getHowMuchMoney() - vehicles.get(userSelection-1).getPrise());
                        clients.get(i).setHowManyVehiclesDidHeBuy(clients.get(i).getHowManyVehiclesDidHeBuy()+1);
                        vehicles.remove((userSelection -1));
                        System.out.println("the sale has been done!");
                        System.out.println("pleasure to do business with you!");
                    }
                    else {
                        System.out.println("Oh no. Looks like you do not have enough money to buy this car!\nChoose another:\n");
                        clientOptions(id);
                    }
                }
                else{
                    System.out.println("Ok. Returns you to the list of vehicles.");
                    clientOptions(id);
                }
            } else{
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

    // The method for displaying the management options in case the user manages.
    // The administrator password is in the Admin class.
    private static void managerOptions(){
        System.out.println("\n************************\n" + "Hello manager\nWhat do you want to do?" +
                "\n\t1) View client list" + "\n\t2) View vehicle list" +
                "\n\t3) View sales list" + "\n\t4) View how many sales there were" +
                "\n\t5) Change admin password" + "\n\t6) Return to the main menu");
        int managerChoice = scan.nextInt();

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
                stopRunning = false;break;
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
