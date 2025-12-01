//package InternshipCodsoftTask;  //Task 2 (ATM Machine)

import java.util.Scanner;

class ATMMachine {
    private double available_Balance;

    ATMMachine() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your pin: ");
        int pin = scan.nextInt();
        UserAccount userAccount = new UserAccount(pin);
        available_Balance = userAccount.getAccountBalance();
        double amount;
        boolean runningState = true;
        while (runningState) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Withdraw Amount");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Exit");
            int choiceSelect = scan.nextInt();
            switch (choiceSelect) {
                case 1:
                    System.out.println("Enter amount: ");
                    amount = scan.nextDouble();
                    withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter amount: ");
                    amount = scan.nextDouble();
                    deposit(amount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    runningState = false;
                    break;
                default:
                    System.out.println("Invalid choiceSelect. Please try again.");
            }
        }
    }

    public void withdraw(double amount) {
        if (amount > available_Balance) {
            System.out.println("You have not enough available_Balance.");
            return;
        }
        available_Balance -= amount;
        System.out.println("Successfully withdrawn");
    }

    public void deposit(double amount) {
        available_Balance += amount;
        System.out.println("Successfully deposited");
    }

    public void checkBalance() {
        System.out.println(available_Balance);
    }
}

class UserAccount {
    private final int correctpin = 1234;
    private double accountBalance;

    UserAccount(int pin) {
        if (this.correctpin != pin) {
            System.out.print("Your entered pin is wrong");
            System.exit(0);
        }
        accountBalance = 5000;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

}

public class ATMMachineInterface {
    public static void main(String[] args) {
        new ATMMachine();

    }
}


