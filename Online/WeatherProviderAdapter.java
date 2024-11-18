public class WeatherProviderAdapter implements WeatherProvider {
    private LegacyWeatherService legacyWeatherService;

    public WeatherProviderAdapter(LegacyWeatherService legacyWeatherService) {
        this.legacyWeatherService = legacyWeatherService;
    }

    @Override
    public String fetchWeather() {
        return legacyWeatherService.getWeatherData();
    }
}
