import java.util.Scanner;

// Account class - handles balance and transactions
class Account {
    private double balance;   // Encapsulation

    // Constructor
    public Account(double balance) {
        this.balance = balance;
    }

    // Withdraw method
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0");
        }

        if (amount > balance) {
            throw new Exception("Insufficient balance");
        }

        balance = balance - amount;
        System.out.println("Transaction successful");
    }

    // Getter method
    public double getBalance() {
        return balance;
    }
}

// ATM class - handles authentication and menu
class ATM {
    static int PIN = 1234;    // Static variable
    private Account account;

    // Constructor
    public ATM(Account account) {
        this.account = account;
    }

    // Authenticate user
    public boolean authenticate(int enteredPin) {
        return enteredPin == PIN;
    }

    // Menu-driven system
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();

                        try {
                            account.withdraw(amount);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Balance: " + account.getBalance());
                        break;

                    case 3:
                        System.out.println("Thank you for using ATM");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Enter numbers only.");
                sc.nextLine(); // clear invalid input
            }
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account acc = new Account(2000);   // Initial balance
        ATM atm = new ATM(acc);

        System.out.print("Enter PIN: ");
        
        try {
            int enteredPin = sc.nextInt();

            if (atm.authenticate(enteredPin)) {
                atm.showMenu();
            } else {
                System.out.println("Incorrect PIN. Access denied.");
            }

        } catch (Exception e) {
            System.out.println("Invalid PIN input");
        }
    }
}