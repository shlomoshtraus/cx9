import java.util.Scanner;

public class Admin {

    Scanner scan = new Scanner(System.in);
    private String adminPassword;

    public Admin() {

    }

    public void setNewAdminPassword() {
        String currentPassword;
        String newPassword;

        System.out.println("Enter the current password");
        currentPassword = scan.next();

        if (currentPassword.equals(this.adminPassword)){
            System.out.println("Enter a new password");
            newPassword = scan.next();
            this.adminPassword = newPassword;
        }


    }
}
