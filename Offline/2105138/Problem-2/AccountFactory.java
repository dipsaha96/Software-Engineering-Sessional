public class AccountFactory implements CustomerFactory {
    @Override
    public Account createAccount(String accountType) {
        if(accountType.equalsIgnoreCase("Regular")) {
            return new RegularAccount();
        }
        else if(accountType.equalsIgnoreCase("Premium")) {
            return new PremiumAccount();
        }
        else if(accountType.equalsIgnoreCase("VIP")) {
            return new VIPAccount();
        }
        else
        {
            return null;
        }
    }

    @Override
    public Loan createLoan(String loanType) {
        return null;
    }
    
}
