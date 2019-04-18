public class Bank {

    public static void main(String[] args) {
        
        BankAccount bankAccount = new BankAccount(new Customer("Tanmay Kalani"));

        // System.out.println(account.getAccountBalance());
        bankAccount.showDetails();

        ATM.deposit_to_account(bankAccount, 3000);

        bankAccount.showDetails();

        ATM.withdrawl_from_account(bankAccount, 200);

        bankAccount.showDetails();

        bankAccount.addMoney(3000);

        bankAccount.showDetails();

        bankAccount.reduceMoney(3500);

        bankAccount.showDetails();
    }
}