import java.util.Scanner;

class atm {
    String[] transaction_a;
    int i;
    int amount;

    atm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total amount");
        amount = sc.nextInt();
        transaction_a = new String[150];
        i = 0;
    }

    void transaction() {
        System.out.println("*****************TRANSACTIONS*****************");
        for (int j = 0; j < i; j++) {
            System.out.println(transaction_a[j]);
        }
    }

    void withdraw() {
        int w_amount = 0;
        Scanner sc = new Scanner(System.in);
        int r_amount = amount - w_amount;
        System.out.println("*****************WITHDRAW*****************");
        System.out.println("Enter amount to withdraw : ");
        w_amount = sc.nextInt();
        if (w_amount % 100 == 0 && amount > w_amount && amount - w_amount >= 500) {
            amount = amount - w_amount;
            System.out.println("AMOUNT WITHDRAWN SUCCESSFULLY");
            transaction_a[i] = new String(i + 1 + ")Withdraw amount:" + w_amount);
            i++;
        }

        else if (amount - w_amount < 500) {
            System.out.println("**INSUFFICIENT BALANCE **");
        } else if (w_amount % 100 != 0) {
            System.out.println("PLEASE ENTER AMOUNT MULTIPLE OF 100");
        }
    }

    void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************DEPOSIT*****************");
        System.out.println("Enter the amount to deposit : ");
        int d_amount = sc.nextInt();
        amount = amount + d_amount;
        System.out.println("**AMOUNT DEPOSITED SUCCESSFULLY**");
        transaction_a[i] = new String(i + 1 + ")Deposited amount :" + d_amount);
        i++;
    }

    void transefer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************TRANSFER*****************");
        System.out.print("Enter the Receiver name :");
        String r_name = sc.next();
        System.out.print("Enter the Amount to transfer to reciever: ");
        int t_amount = sc.nextInt();
        if (amount - 500 < t_amount) {
            System.out.println("INSUFFICIENT BALANCE");
        } else if (t_amount > 100000) {
            System.out.println("Sorry! limited upto  Rs.100000");
        } else {
            amount = amount - t_amount;
            System.out.println("Amount " + t_amount + " transfered to " + r_name + " successfully.");

            transaction_a[i] = new String(i + 1 + ")Transfer " + t_amount);
            i++;
        }
    }

    void r_balance() {
        System.out.println("remaining balance is " + amount);
    }
}

class ATM_Interfacestask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the id ");
        int id = sc.nextInt();
        System.out.println("enter the pin ");
        int pin = sc.nextInt();
        int EID, epin;
        int choice, i = 0;
        int count = 0;

        do {
            System.out.print("Enter the ID: ");
            EID = sc.nextInt();
            System.out.print("Enter the PIN : ");
            epin = sc.nextInt();
            if (id != EID || pin != epin) {
                System.out.println("PLEASE ENTER VALID EID AND PIN");
            }
        } while (id != EID || pin != epin);
        atm am = new atm();
        while (true) {
            System.out.println("\n\n****************ATM Transaction Service ****************");
            System.out.println("press 1 for Transactions");
            System.out.println("pres 2 for Withdraw");
            System.out.println("press 3 for Deposit");
            System.out.println("press 4 for Transfer");
            System.out.println("press 5 for remaining_balance");
            System.out.println("press 6 for Exit");
            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    am.transaction();
                    break;
                case 2:
                    am.withdraw();
                    break;
                case 3:
                    am.deposit();
                    break;
                case 4:
                    am.transefer();
                    break;
                case 5:
                    am.r_balance();
                    break;
                case 6:
                    System.out.println("THANK YOU!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("some error");
                    break;
            }
        }
    }
}