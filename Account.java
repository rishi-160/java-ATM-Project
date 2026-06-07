
public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws Exception {

        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0");
        }

        if (amount > balance) {
            throw new Exception("Insufficient Balance");
        }

        balance = balance - amount;

        System.out.println("Transaction Successful");
    }

    public double getBalance() {
        return balance;
    }
}
