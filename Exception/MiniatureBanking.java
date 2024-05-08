class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not Sufficient Fund");
        }
        balance -= amount;
        System.out.println("Withdrawn: Rs " + amount);
    }

    public double getBalance() {
        return balance;
    }
}

public class MiniatureBanking {
    public static void main(String[] args) {
        Account account = new Account(1000.00);

        try {
            account.deposit(1000.00);
            account.withdraw(400.00);
            account.withdraw(550.00);
            account.withdraw(1200.00); // This will throw an exception
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Current Balance: Rs " + account.getBalance());
    }
}
