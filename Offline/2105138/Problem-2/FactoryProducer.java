public class FactoryProducer {
    public static CustomerFactory getFactory(String factoryType)
    {
       if(factoryType.equalsIgnoreCase("Account"))
        {
            return new AccountFactory();
        }
        else if(factoryType.equalsIgnoreCase("Loan"))
        {
            return new LoanFactory();
        }
        else
        {
            return null;
        }
    
    }
}
