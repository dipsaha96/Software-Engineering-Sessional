import java.util.ArrayList;

public class TicketingSystemBuilder implements Builder {
    private final ArrayList<String> system = new ArrayList<>();

    public TicketingSystemBuilder addComponents(
            MicroController microController,
            Display display,
            TicketingSystemIdentification identification,
            PaymentTerminal paymentTerminal,
            InternetConnection internet,
            Storage storage,
            Controller controller,
            WebServer framework) {

        if (microController != null) {
            system.add(microController.addMicroController());
        }
        if (display != null) {
            system.add(display.addDisplay());
        }
        if (identification != null) {
            system.add(identification.addTicketingSystemIdentification());
        }
        if (paymentTerminal != null) {
            system.add(paymentTerminal.addPaymentSystem());
        }
        if (internet != null) {
            system.add(internet.addInternetConnection());
        }
        if (storage != null) {
            system.add(storage.addStorage());
        }
        if (controller != null) {
            system.add(controller.addController());
        }
        if (framework != null) {
            system.add(framework.addWebFramework());
        }
        
        return this; 
    }

    public ArrayList<String> build() {
        return system;
    }
}
