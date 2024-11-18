public class PackageFactory {
    // Creates a MicroController based on the package type
    public static MicroController createMicroController(String packageType) {
        switch (packageType) {
            case "Basic": return new ATMega32();
            case "Standard": return new ArduinoMega();
            case "Advanced":
            case "Premium": return new RaspberryPi();
            default: return null;
        }
    }

    // Creates a Display based on the package type
    public static Display createDisplay(String packageType) {
        switch (packageType) {
            case "Basic": return new LCD();
            case "Standard": return new LED();
            case "Advanced": return new OLED();
            case "Premium": return new TouchScreen();
            default: return null;
        }
    }

    // Creates an Identification based on the package type
    public static TicketingSystemIdentification createIdentification(String packageType) {
        switch (packageType) {
            case "Basic":
            case "Standard": return new RFIDCard();
            case "Advanced":
            case "Premium": return new NFCCard();
            default: return null;
        }
    }

    // Creates a PaymentTerminal (Same for all package types)
    public static PaymentTerminal createPaymentTerminal(String packageType) {
        return new OnCashPayment();
    }

    // Creates Storage based on the package type
    public static Storage createStorage(String packageType) {
        switch (packageType) {
            case "Basic":
            case "Standard": return new SDCard();
            case "Advanced":
            case "Premium": return new OnBoardStorage();
            default: return null;
        }
    }

    // Creates a Controller based on the package type
    public static Controller createController(String packageType) {
        switch (packageType) {
            case "Basic":
            case "Standard": return new SeparateController();
            case "Advanced":
            case "Premium": return new TouchScreenController();
            default: return null;
        }
    }
}
