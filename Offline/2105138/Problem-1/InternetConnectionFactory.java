public class InternetConnectionFactory {
    public static InternetConnection createInternet(String internet) {
        if (internet.equals("WiFi")) {
            return new Wifi();
        } else if (internet.equals("Ethernet")) {
            return new Ethernet();
        } else if (internet.equals("GSM")) {
            return new GSM();
        } else {
            return null;
        }
    }
}

