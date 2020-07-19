package sanchez.julian.conversions.temperature;

public class Celcius extends Temperature {

    public Celcius(double temperature) {
        super(temperature);
    }
    private TemperatureUnit type = TemperatureUnit.CELCIUS;

    @Override
    public Temperature convertTo(TemperatureUnit unit) {
        double newTemp = 0.0;
        if (unit == TemperatureUnit.CELCIUS)
            newTemp = temperature;
        else if (unit == TemperatureUnit.FAHRENHEIT)
            newTemp = TemperatureConversions.cToF(temperature);
        else if (unit == TemperatureUnit.KELVIN)
            newTemp = TemperatureConversions.cToK(temperature);
        else
            throw new RuntimeException("Temperature unit not found.");
        return TemperatureFactory.create(unit, newTemp);
    }
}
