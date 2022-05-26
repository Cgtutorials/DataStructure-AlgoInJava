package ObserverPattern;

public class ForecastDisplay implements Observer,DisplayElement{
    private float currentPressure=29.9f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData= weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("boom boom");
    }

    @Override
    public void update() {
        lastPressure=currentPressure;
        currentPressure=weatherData.getPressure();
        display();
    }
}
