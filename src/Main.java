import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Sales> sales = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Hello\nAre you a new client? \n\t 1 for yes \n\t 2 for no");
        Scanner scan = new Scanner(System.in);
        int userChoice = scan.nextInt();
        switch (userChoice){
            case 1:
                System.out.println("Enter your id");
                int id = scan.nextInt();
                System.out.println("Enter your name");
                String customerName = scan.next();
                double howMuchMoney = scan.nextDouble();
                new Client(id,customerName,howMuchMoney);
        }

    }

    void addCars(){
        vehicles.add(new Car( "B354FD68", "BMW", 6, 110845.0, 6.5, 5, "4*4", 20, true));

    }
}
