import java.util.Scanner;

public class Admin {

    Scanner scan = new Scanner(System.in);
    private static int adminPassword = 123456;

    public Admin() {
    }

    public int getAdminPassword() {
        return adminPassword;
    }

    public void setNewAdminPassword() {
        int newPassword;
        int confirmPassword;

        System.out.println("Enter a new password");
        newPassword = scan.nextInt();
        System.out.println("Confirm the new password");
        confirmPassword = scan.nextInt();
        if (newPassword == confirmPassword){
            adminPassword = newPassword;
            System.out.println("Password changed successfully");
        }
        else{
            System.out.println("The passwords are not the same.\nTry again ");
            setNewAdminPassword();
        }

        }

}
