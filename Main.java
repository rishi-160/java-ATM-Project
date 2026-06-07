
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM();

        Account account = new Account(2000);

        if (!atm.authenticate()) {
            return;
        }

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");

            try {

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble();

                        account.withdraw(amount);
                        break;

                    case 2:

                        System.out.println("Current Balance: ₹"
                                + account.getBalance());
                        break;

                    case 3:

                        System.out.println("Thank You For Using ATM");
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}
