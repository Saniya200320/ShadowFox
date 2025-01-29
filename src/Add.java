
import java.util.ArrayList;
import java.util.List;

public class Add {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public Add(String accountNumber, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: " + initialBalance);
        System.out.println("Account created with initial balance: " + initialBalance);
    }

    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
        System.out.println("Withdrew: " + amount + " | New Balance: " + balance);
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
}
