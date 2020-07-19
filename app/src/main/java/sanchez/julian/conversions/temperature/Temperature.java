package sanchez.julian.conversions.temperature;

public abstract class Temperature {
    protected double temperature;

    public Temperature(double temp) {
        temperature = temp;
    }
    public abstract Temperature convertTo(TemperatureUnit unit);

    public double getTemp() {
        return temperature;
    }
}

