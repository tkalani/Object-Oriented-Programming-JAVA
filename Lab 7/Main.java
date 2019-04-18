public class Main {

    public static void main(String[] args) {
        System.out.println("-- BANK --");

        CreditAccount obj_credit_account = new CreditAccount(100);
        System.out.println("Credit Account : " + obj_credit_account.getInterestRate());

        FDAccount obj_fd_account = new FDAccount(100);
        System.out.println("FD Account : " + obj_fd_account.getInterestRate());

        SavingsAccount obj_savings_account = new SavingsAccount(100);
        System.out.println("Savings Account : " + obj_savings_account.getInterestRate());
    }
}
