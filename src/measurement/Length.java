package measurement;

import java.util.ArrayList;
import java.util.Arrays;

public class Length implements Measurement
{
    final String MILLIMETERS = "Millimeters";
    final String CENTIMETERS = "Centimeters";
    final String METERS = "Meters";
    final String KILOMETERS = "Kilometers";
    final String INCHES = "Inches";
    final String FEET = "Feet";
    final String YARDS = "Yards";
    final String MILES = "Miles";

    ArrayList<String> units;
    String[] lengthUnits = {
            MILLIMETERS, CENTIMETERS, METERS, KILOMETERS, INCHES, FEET, YARDS, MILES
    };

    public Length()
    {
        units = new ArrayList<>();
        units.addAll(Arrays.asList(lengthUnits));
    }

    @Override
    public ArrayList<String> getUnits()
    {
        return units;
    }

    @Override
    public double convertValue(String currentUnit, double currentValue, String newUnit)
    {
        double newValue = Double.NaN;

        newValue = currentValue / getConversionFactor(currentUnit);
        newValue = newValue * getConversionFactor(newUnit);

        return newValue;
    }

    @Override
    public String toString()
    {
        return "Length";
    }

    public double getConversionFactor(String unit)
    {
        double conversionFactor = Double.NaN;

        if (unit.equals(METERS))
            conversionFactor = 1.0;
        else if (unit.equals(MILLIMETERS))
            conversionFactor = 1000.0;
        else if (unit.equals(CENTIMETERS))
            conversionFactor = 100.0;
        else if (unit.equals(KILOMETERS))
            conversionFactor = 0.001;
        else if (unit.equals(INCHES))
            conversionFactor = 39.37;
        else if (unit.equals(FEET))
            conversionFactor = 3.281;
        else if (unit.equals(YARDS))
            conversionFactor = 1.09361329;
        else if (unit.equals(MILES))
            conversionFactor = 0.000621371;

        return conversionFactor;
    }
}
