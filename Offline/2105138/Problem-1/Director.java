import java.util.ArrayList;

public class Director {
    private TicketingSystemBuilder TSbuilder;

    public Director(TicketingSystemBuilder builder) {
        this.TSbuilder = builder;
    }

    public ArrayList<String> buildTicketingSystem(String packageType, String internetOption, String frameWorkOption) {
        // Use a single method to add all components
        return TSbuilder
                .addComponents(
                        PackageFactory.createMicroController(packageType),
                        PackageFactory.createDisplay(packageType),
                        PackageFactory.createIdentification(packageType),
                        PackageFactory.createPaymentTerminal(packageType),
                        InternetConnectionFactory.createInternet(internetOption),
                        PackageFactory.createStorage(packageType),
                        PackageFactory.createController(packageType),
                        WebServerFactory.createFrameWork(frameWorkOption)
                )
                .build();
    }
}
