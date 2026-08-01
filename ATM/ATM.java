package ATM;

import java.util.*;

class InnerATM {

    float balance = 0.0f;
    int PIN = 1234; // Example PIN

    // Check valid PIN
    public void checkPin() {
        System.out.println("Enter Your PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid PIN.");
            checkPin();
        }
    }

    // Menu
    public void menu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Cash Deposit");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 1) {
            checkBalance();
        } else if (input == 2) {
            withdraw();
        } else if (input == 3) {
            deposit();
        } else if (input == 4) {
            return;
        }
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
        menu();
    }

    // Withdraw Money
    public void withdraw() {
        System.out.println("Enter Your Amount:");
        Scanner sc = new Scanner(System.in);
        int enteredAmount = sc.nextInt();

        if (balance < enteredAmount) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= enteredAmount;
            System.out.println("Money Withdrawn Successfully.");
        }

        menu();
    }

    // Deposit Money
    public void deposit() {
        System.out.println("Enter Your Deposit Amount:");
        Scanner sc = new Scanner(System.in);
        int enteredDepositAmount = sc.nextInt();

        balance += enteredDepositAmount;
        System.out.println("Amount Deposited Successfully.");

        menu();
    }
}

public class ATM {
    public static void main(String[] args) {
        InnerATM inAtm = new InnerATM();
        inAtm.checkPin();
    }
}