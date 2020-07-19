package sanchez.julian.conversions.temperature;

public class Fahrenheit extends Temperature {

    public Fahrenheit(double temperature) {
        super(temperature);
    }
    private TemperatureUnit type = TemperatureUnit.FAHRENHEIT;

    @Override
    public Temperature convertTo(TemperatureUnit unit) {
        double newTemp = 0.0;
        if (unit == TemperatureUnit.CELCIUS)
            newTemp = TemperatureConversions.fToC(temperature);
        else if (unit == TemperatureUnit.FAHRENHEIT)
            newTemp = temperature;
        else if (unit == TemperatureUnit.KELVIN)
            newTemp = TemperatureConversions.fToK(temperature);
        else
            throw new RuntimeException("Temperature unit not found.");
        return TemperatureFactory.create(unit, newTemp);
    }
}
