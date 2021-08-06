import java.util.Scanner;

public class Admin {

    Scanner scan = new Scanner(System.in);
    private int adminPassword = 123456;

    public Admin() {
    }

    public int getAdminPassword() {
        return adminPassword;
    }

    public void setNewAdminPassword() {
        int currentPassword;
        int newPassword;

        System.out.println("Enter the current password");
        currentPassword = scan.nextInt();

        if (currentPassword == this.adminPassword){
            System.out.println("Enter a new password");
            newPassword = scan.nextInt();
            this.adminPassword = newPassword;
        }


    }
}
