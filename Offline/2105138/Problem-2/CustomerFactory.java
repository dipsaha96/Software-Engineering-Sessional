interface CustomerFactory {
    Account createAccount(String accountType);
    Loan createLoan(String loanType);
}
