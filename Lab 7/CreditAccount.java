public class CreditAccount extends  Account {

    public CreditAccount(double amount) {
        super(amount);
    }

    @Override
    int getInterestRate() {

        return 8;
    }
}
