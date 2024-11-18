import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double simpleInterest;
            double compoundInterest;
            String factoryType = "";
            String customerType = "";
            double amount;
            int years;

            // Choose the type of operation (Account or Loan)
            while (true) {
                System.out.println("Enter the type of operation: ");
                System.out.println("1. Account");
                System.out.println("2. Loan");
                System.out.println("Enter your choice: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    factoryType = "Account";
                    break;
                } else if (option == 2) {
                    factoryType = "Loan";
                    break;
                } else {
                    System.out.println("Invalid operation type. Please select again(1/2).");
                }
            }

            while (true) {
                // Choose the type of customer (Regular, Premium, VIP)
                System.out.println("Enter the type of customer: ");
                System.out.println("1. Regular");
                System.out.println("2. Premium");
                System.out.println("3. VIP");
                System.out.println("Enter your choice: ");
                int customerOption = scanner.nextInt();

                if (customerOption == 1) {
                    customerType = "Regular";
                    break;
                } else if (customerOption == 2) {
                    customerType = "Premium";
                    break;
                } else if (customerOption == 3) {
                    customerType = "VIP";
                    break;
                } else {
                    System.out.println("Invalid customer type. Please select again(1/2/3).");
                }
            }

            // Get the appropriate factory (AccountFactory or LoanFactory)
            CustomerFactory factory = FactoryProducer.getFactory(factoryType);

            if (factoryType.equals("Account")) {
                // Create account and calculate interest
                Account account = factory.createAccount(customerType);
                if (account != null) {
                    System.out.println("Enter the principal amount: ");
                    amount = scanner.nextDouble();
                    System.out.println("Enter the number of years: ");
                    years = scanner.nextInt();
                    simpleInterest = account.calculateSimpleInterest(amount, years);
                    compoundInterest = account.calculateCompoundInterest(amount, years);
                    System.out.printf("The simple interest for this %s Account is: %.2f%n", customerType, simpleInterest);
                    System.out.printf("The compound interest for this %s Account is: %.2f%n", customerType, compoundInterest);
                } else {
                    System.out.println("Invalid account type.");
                }
            } else if (factoryType.equals("Loan")) {
                // Create loan and calculate interest
                Loan loan = factory.createLoan(customerType);
                if (loan != null) {
                    System.out.println("Enter the loan amount: ");
                    amount = scanner.nextDouble();
                    System.out.println("Enter the number of years: ");
                    years = scanner.nextInt();
                    simpleInterest = loan.calculateSimpleInterest(amount, years);
                    compoundInterest = loan.calculateCompoundInterest(amount, years);
                    System.out.printf("The simple interest for this %s Loan is: %.2f%n", customerType, simpleInterest);
                    System.out.printf("The compound interest for this %s Loan is: %.2f%n", customerType, compoundInterest);
                } else {
                    System.out.println("Invalid loan type.");
                }
            }
        }
    }
}
