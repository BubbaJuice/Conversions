package sanchez.julian.conversions.temperature;

public class TemperatureConversions {

    private static double kevlinToC = 273.15;

    public static double cToF(final double temp) {
        return temp * 9 / 5 + 32;
    }

    public static double fToC(double temp) {
        return ( temp - 32 ) * 5 / 9;
    }

    public static double fToK(double temp) {
        return fToC(temp) + kevlinToC;
    }

    public static double cToK(double temp) {
        return temp + kevlinToC;
    }

    public static double kToC(double temp) {return temp - kevlinToC; }

    public static double kToF(double temp) {return  cToF(kToC(temp)); }
}
