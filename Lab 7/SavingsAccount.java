public class SavingsAccount extends Account {

    public SavingsAccount(double amount) {
        super(amount);
    }

    @Override
    int getInterestRate() {

        return 6;
    }
}
