// Create a class Account. It has three data member account id, name and balance. Define function to assign value and display value. Define function that search account number given by the user. If account number exists, print detail of that account. Write a program using array of object. Declare at least 5 account and print details.

import java.util.Scanner;

class Account {
    int id;
    String name;
    int balance;

    Account(int accountId, String name,int balance) {
        this.id = accountId;
        this.name = name;
        this.balance = balance;
    }

    void insertData(int id, String name, int b){
        this.balance = b;
        this.name = name;
        this.id =id;
    }

    void printData(){
        System.out.println("----------*****----------");
        System.out.println("ID : " + this.id);
        System.out.println("Name : " + this.name);
        System.out.println("Balance : " + this.balance);
        System.out.println("----------*****----------");
    }

    boolean searchAccount(int searchId) {
        return id == searchId;
    }
}
public class AccDetails {
    public static void main(String[] args) {
        Account[] accounts = new Account[5];
        
        
        accounts[0] = new Account(101, "Dhiraj", 1500);
        accounts[1] = new Account(102, "Jay", 2000);
        accounts[2] = new Account(103, "Alaya", 3000);
        accounts[3] = new Account(104, "Om", 2500);
        accounts[4] = new Account(105, "Fulesh", 4000);
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id to Serch : ");
        int i = sc.nextInt();
        sc.close();
        boolean t = false;
        for (Account acc : accounts) {
            // acc.printData();
            if(i == acc.id){
                System.out.println("Match Found");
                acc.printData();
                t = true;
                break;
            }
        }
        if(t == false){
            System.out.println("Match not Found , Data is not Avalible.");
        }


    }
}