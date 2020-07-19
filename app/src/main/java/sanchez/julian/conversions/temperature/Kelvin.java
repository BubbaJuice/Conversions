package sanchez.julian.conversions.temperature;

public class Kelvin extends Temperature {

    public Kelvin(double temperature) {
        super(temperature);
    }
    private TemperatureUnit type = TemperatureUnit.KELVIN;

    @Override
    public Temperature convertTo(TemperatureUnit unit) {
        double newTemp = 0.0;
        if (unit == TemperatureUnit.CELCIUS)
            newTemp = TemperatureConversions.kToC(temperature);
        else if (unit == TemperatureUnit.FAHRENHEIT)
            newTemp = TemperatureConversions.kToF(temperature);
        else if (unit == TemperatureUnit.KELVIN)
            newTemp = temperature;
        else
            throw new RuntimeException("Temperature unit not found.");
        return TemperatureFactory.create(unit, newTemp);
    }
}
