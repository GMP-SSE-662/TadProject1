package measurement;

import java.util.ArrayList;
import java.util.Arrays;

public class Mass implements Measurement
{
    ArrayList<String> units;
    String[] lengthUnits = {
            "Milligrams", "Grams", "Kilograms", "Tonne", "Pound-Mass", "Slug"
    };

    public Mass()
    {
        units = new ArrayList<String>();
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

        if (unit.equals(""))
            conversionFactor = 1.0;
        else if (unit.equals(""))
            conversionFactor = 1000.0;
        else if (unit.equals(""))
            conversionFactor = 100.0;
        else if (unit.equals(""))
            conversionFactor = 0.001;
        else if (unit.equals(""))
            conversionFactor = 39.37;
        else if (unit.equals(""))
            conversionFactor = 3.281;
        else if (unit.equals(""))
            conversionFactor = 1.09361329;
        else if (unit.equals(""))
            conversionFactor = 0.000621371;

        return conversionFactor;
    }
}
