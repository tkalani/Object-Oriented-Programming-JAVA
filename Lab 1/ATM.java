public class ATM {
    
    public static void withdrawl_from_account(BankAccount bankAccount, int amount) {

        bankAccount.reduceMoney(amount);

        System.out.print("Money withdrawn, ");
        bankAccount.showDetails();
    }

    public static void deposit_to_account(BankAccount bankAccount, int amount) {

        bankAccount.addMoney(amount);

        System.out.print("Money Added, ");
        bankAccount.showDetails();
    }
}