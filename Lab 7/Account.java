public abstract class Account {

    private double balance;

    public Account(double amount) {

        setBalance(amount);
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    abstract int getInterestRate();

    public void withdraw(double amount) {

        balance -= amount;
    }

    public void deposit(double amount) {

        balance += amount;
    }
}
