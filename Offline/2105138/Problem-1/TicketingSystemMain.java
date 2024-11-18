import java.util.ArrayList;
import java.util.Scanner;

public class TicketingSystemMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String packageType = "";
            String internetType = "";
            String frameWorkType = "";

            // Select Package
            while (true) {
                System.out.println("The company has four packages: ");
                System.out.println("1. Basic");
                System.out.println("2. Standard");
                System.out.println("3. Advanced");
                System.out.println("4. Premium");
                System.out.print("Enter the package option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    packageType = "Basic";
                    break;
                } else if (option == 2) {
                    packageType = "Standard";
                    break;
                } else if (option == 3) {
                    packageType = "Advanced";
                    break;
                } else if (option == 4) {
                    packageType = "Premium";
                    break;
                } else {
                    System.out.println("Invalid package type. Please enter a valid package type.");
                }
            }

            // Select Internet Option
            while (true) {
                System.out.println("The company offers three internet options: ");
                System.out.println("1. WiFi");
                System.out.println("2. GSM");
                System.out.println("3. Ethernet");
                System.out.print("Enter the internet option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    internetType = "WiFi";
                    break;
                } else if (option == 2) {
                    internetType = "GSM";
                    break;
                } else if (option == 3) {
                    internetType = "Ethernet";
                    break;
                } else {
                    System.out.println("Invalid internet option. Please enter a valid internet option.");
                }
            }

            // Validate internet option based on package type
            while ((packageType.equals("Basic") || packageType.equals("Standard")) && internetType.equals("Ethernet")) {
                System.out.println(
                        "Error: Ethernet is not supported for " + packageType + " package. Your package only supports WiFi or GSM Internet connection.");
                System.out.print("Please choose a valid internet connection (1.WiFi/2.GSM): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    internetType = "WiFi";
                } else if (option == 2) {
                    internetType = "GSM";
                } else {
                    System.out.println("Invalid option. Keeping previous choice.");
                }
            }

            // Select Framework Option
            while (true) {
                System.out.println("The company offers three frameworks: ");
                System.out.println("1. Django");
                System.out.println("2. NodeJS");
                System.out.println("3. Ruby");
                System.out.print("Enter the framework option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    frameWorkType = "Django";
                    break;
                } else if (option == 2) {
                    frameWorkType = "NodeJS";
                    break;
                } else if (option == 3) {
                    frameWorkType = "Ruby";
                    break;
                } else {
                    System.out.println("Invalid framework option. Please enter a valid framework option.");
                }
            }

            // Build the ticketing system
            TicketingSystemBuilder builder = new TicketingSystemBuilder();
            Director director = new Director(builder);

            ArrayList<String> system = director.buildTicketingSystem(packageType, internetType, frameWorkType);
            System.out.println("Your selected ticketing system details are: ");
            for (String x : system) {
                System.out.println(x);
            }
        }
    }
}
