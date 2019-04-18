import java.util.Random;

public class BankAccount {

    private Customer customer;

    private int accountNumber;
    private int accountBalance;
    private int interestRate;

    public BankAccount(Customer customer) {

        this.customer = customer;

        accountNumber = new Random().nextInt(1000000);
        accountBalance = 0;
        interestRate = 6;

        System.out.print("Account created, ");
        showDetails();
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void showDetails() {

        System.out.println("Account Details - ");
        customer.showDetails();
        System.out.printf("Account Number %d \n", getAccountNumber());
        System.out.printf("Account Balance %d \n", getAccountBalance());
        System.out.printf("Interest Rate %d \n", getInterestRate());
        System.out.println();
    }

    public void reduceMoney(int amount) {

        accountBalance -= amount;
    }

    public void addMoney(int amount) {

        accountBalance += amount;
    }
}