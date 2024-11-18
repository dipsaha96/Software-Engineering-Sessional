class RegularLoan implements Loan {
    double interestRate = 14;

    @Override
    public double calculateSimpleInterest(double amount, int years) {
        return amount * (interestRate / 100) * years;
    }
    @Override
    public double calculateCompoundInterest(double amount, int years) {
        return amount * Math.pow(1 + (interestRate / 100), years) - amount;
    }
}