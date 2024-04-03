// Define the class BankAccount to represent an account we open with bank. Define the subclasses SavingAccount and FixedDepositAccount. Implement the operations like openAccount(), deposit(), checkBalance(), withdraw() and calInterest() for these classes.



class BankAccount {
    public static int accnum = 1001;
    String name;
    String sex;
    int balance; 
    int pnum;
    int accNum;

    BankAccount(String name , String sex, int pnum){
        this.name = name;
        this.sex = sex;
        this.balance = 0;
        this.accNum = accnum++;
        openAccount();
    }

    void openAccount(){
        System.out.println("----------*****----------");
        System.out.println("Accnum = " + this.accNum);
        System.out.println("Name : "+ this.name );
        System.out.println("Sex : " + this.sex);
        System.out.println("Your current balance : "+ this.balance);
        System.out.println("----------*****----------");    
    }

    void deposit(int amt){
        this.balance += amt;
        System.out.println("Credited " + amt + " in Your bank Account, Your updated Balance is " + this.balance);
    }

    void withdraw(int amt){
        if(amt <= balance) {
            balance -= amt;
            System.out.println("Debited " + amt + " from Your bank Account, Your updated Balance is " + this.balance);
        } else {
            System.out.println("Insufficient funds. Transaction cancelled.");
        }
    }

    int checkBalance(){
        System.out.println("The current balance is : "+ this.balance);
        return this.balance;
    }
}

class SavingAccount extends BankAccount {
    double interestRate = 4.85; // Annual interest rate

    SavingAccount(String name, String sex, int pnum) {
        super(name, sex, pnum);
    }

    void calInterest() {
        int interest = (int) (balance * interestRate / 100);
        System.out.println("Interest of " + interest + " has been credited to your account. Your updated balance is: " + this.balance);
        deposit(interest);
    }
}

class FixedDepositAccount extends BankAccount {
    double interestRate = 7.75; // Annual interest rate
    int term; // in years

    FixedDepositAccount(String name, String sex, int pnum, int term) {
        super(name, sex, pnum);
        this.term = term;
    }

    void calInterest() {
        // Simple interest for demonstration
        int interest = (int) ((balance * interestRate * term) / 100);
        int b = balance + interest;
        System.out.println("After " + term + " years, interest of " + interest + " will be added to your account. Total balance will be: " + b);
    }
}



public class BankAcc_SubClass {
    public static void main(String[] args) {
        SavingAccount s = new SavingAccount("Jaybhai", "Male", 58585);
        s.deposit(1000);
        s.calInterest();
        s.checkBalance();
        s.withdraw(500);

        FixedDepositAccount f = new FixedDepositAccount("Jayaben", "Female", 456, 5);
        f.deposit(5000);
        f.calInterest(); // This will calculate the interest after 5 years but won't add it immediately
        f.checkBalance();
    }
}