import java.util.*;

class BankAccount {
    int accountNumber;
    String accountHolder;
    double balance;
    BankAccount next;
    Stack<String> transactionHistory;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.next = null;
        this.transactionHistory = new Stack<>();
        transactionHistory.push("Account created with ₹" + balance);
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
        System.out.println("-----------------------------");
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = transactionHistory.size() - 1; i >= 0; i--) {
                System.out.println(transactionHistory.get(i));
            }
        }
        System.out.println("-----------------------------");
    }
}

class BankManagementSystem {
    private BankAccount head;
    private Map<Integer, BankAccount> accountMap;  

    public BankManagementSystem() {
        accountMap = new HashMap<>();
    }

    public void createAccount(int accountNumber, String accountHolder, double initialDeposit) {
        if (accountMap.containsKey(accountNumber)) {
            System.out.println("Account with this number already exists!");
            return;
        }

        BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialDeposit);
        accountMap.put(accountNumber, newAccount);

        if (head == null) {
            head = newAccount;
        } else {
            BankAccount temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newAccount;
        }
        System.out.println("Account created successfully!");
    }

    public void displayAllAccounts() {
        if (head == null) {
            System.out.println("No accounts found.");
            return;
        }
        BankAccount temp = head;
        while (temp != null) {
            temp.displayAccount();
            temp = temp.next;
        }
    }

    public void searchAccount(int accountNumber) {
        BankAccount account = accountMap.get(accountNumber);
        if (account != null) {
            account.displayAccount();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updateAccount(int accountNumber, String newHolderName) {
        BankAccount account = accountMap.get(accountNumber);
        if (account != null) {
            account.accountHolder = newHolderName;
            account.transactionHistory.push("Updated account holder name to: " + newHolderName);
            System.out.println("Account holder name updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deleteAccount(int accountNumber) {
        BankAccount account = accountMap.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (head == account) {
            head = head.next;
        } else {
            BankAccount prev = head;
            while (prev != null && prev.next != account) {
                prev = prev.next;
            }
            if (prev != null) {
                prev.next = account.next;
            }
        }

        accountMap.remove(accountNumber);
        System.out.println("Account deleted successfully.");
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = accountMap.get(accountNumber);
        if (account != null) {
            account.balance += amount;
            account.transactionHistory.push("Deposited ₹" + amount + " | New Balance: ₹" + account.balance);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = accountMap.get(accountNumber);
        if (account != null) {
            if (account.balance >= amount) {
                account.balance -= amount;
                account.transactionHistory.push("Withdrew ₹" + amount + " | New Balance: ₹" + account.balance);
                System.out.println("₹" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void viewTransactionHistory(int accountNumber) {
        BankAccount account = accountMap.get(accountNumber);
        if (account != null) {
            account.displayTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankManagementSystem bank = new BankManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Update Account Holder Name");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Delete Account");
            System.out.println("8. View Transaction History");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int accNum;
            double amount;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ₹");
                    amount = sc.nextDouble();
                    bank.createAccount(accNum, name, amount);
                    break;
                case 2:
                    bank.displayAllAccounts();
                    break;
                case 3:
                    System.out.print("Enter Account Number to Search: ");
                    accNum = sc.nextInt();
                    bank.searchAccount(accNum);
                    break;
                case 4:
                    System.out.print("Enter Account Number to Update: ");
                    accNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Account Holder Name: ");
                    name = sc.nextLine();
                    bank.updateAccount(accNum, name);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ₹");
                    amount = sc.nextDouble();
                    bank.deposit(accNum, amount);
                    break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ₹");
                    amount = sc.nextDouble();
                    bank.withdraw(accNum, amount);
                    break;
                case 7:
                    System.out.print("Enter Account Number to Delete: ");
                    accNum = sc.nextInt();
                    bank.deleteAccount(accNum);
                    break;
                case 8:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextInt();
                    bank.viewTransactionHistory(accNum);
                    break;
                case 9:
                    System.out.println("Thank you for using Bank Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}