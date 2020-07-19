package sanchez.julian.conversions.temperature;

public class TemperatureFactory {

    public static Temperature create(TemperatureUnit unit, double temperature) {
        if (unit == TemperatureUnit.CELCIUS)
            return new Celcius(temperature);
        if (unit == TemperatureUnit.FAHRENHEIT)
            return new Fahrenheit(temperature);
        if (unit == TemperatureUnit.KELVIN)
            return new Kelvin(temperature);
        else
            throw new RuntimeException("Temperature unit not found.");
    }
}
