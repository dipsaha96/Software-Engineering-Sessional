public class LoanFactory implements CustomerFactory {
    @Override
    public Account createAccount(String accountType) {
        return null;
    }

    @Override
    public Loan createLoan(String loanType) {
        if (loanType.equalsIgnoreCase("Regular")) {
            return new RegularLoan();
        } else if (loanType.equalsIgnoreCase("Premium")) {
            return new PremiumLoan();
        } else if (loanType.equalsIgnoreCase("VIP")) {
            return new VIPLoan();
        } else {
            return null;
        }
    }
}
