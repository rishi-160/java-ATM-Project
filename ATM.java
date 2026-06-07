
import java.util.Scanner;

public class ATM {

    static int PIN = 1234;

    public boolean authenticate() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            return true;
        } else {
            System.out.println("Invalid PIN");
            return false;
        }
    }
}
