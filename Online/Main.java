
public class Main {
    public static void main(String[] args) {
        // Legacy service instance
        LegacyWeatherService legacyWeatherService = new LegacyWeatherService();
     

        WeatherApp app = new WeatherApp(new WeatherProviderAdapter(legacyWeatherService));
        app.displayWeather();  // Output: Legacy weather data
    }
}
