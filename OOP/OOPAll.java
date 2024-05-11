// Encapsulation: hiding internal state and requiring all interaction to be performed through an object's methods
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(amount + " deposited. New balance is : " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println(amount + " withdrawn. New balance is : " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Abstraction: hiding the implementation details and showing only the necessary features of an object
    public double getBalance() {
        return balance;
    }
}

// Inheritance: creating a new class from an existing class
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // Polymorphism: the ability of different objects to respond to the same message (method call) in different ways
    @Override
    public void deposit(double amount) {
        super.deposit(amount * (1 + interestRate));
    }
}

public class OOPAll {
    public static void main(String[] args) {
        // Object creation
        BankAccount account1 = new BankAccount("123456");
        SavingsAccount account2 = new SavingsAccount("789012", 0.05);

        // Method calls
        account1.deposit(1000);
        account1.withdraw(500);

        account2.deposit(1000);
        account2.withdraw(200);
    }
}
