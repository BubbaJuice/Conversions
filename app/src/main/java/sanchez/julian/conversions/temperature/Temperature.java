package sanchez.julian.conversions.temperature;

public class Temperature {

    public static double cToF(final double temp) {
        return temp * 9 / 5 + 32;
    }

    public static double fToC(double temp) {
        return ( temp - 32 ) * 5 / 9;
    }
}
