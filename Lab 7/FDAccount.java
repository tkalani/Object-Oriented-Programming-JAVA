public class FDAccount extends Account {

    public FDAccount(double amount) {
        super(amount);
    }

    @Override
    int getInterestRate() {

        return 10;
    }
}
