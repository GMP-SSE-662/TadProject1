package measurement;

import java.util.ArrayList;
import java.util.Arrays;

public class Time implements Measurement
{
    ArrayList<String> units;
    String[] timeUnits = {
            "Milliseconds", "Seconds", "Minutes", "Hours", "Days", "Weeks", "Fortnights", "Years"
    };

    public Time()
    {
        units = new ArrayList<String>();
        units.addAll(Arrays.asList(timeUnits));
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
        return "Time";
    }

    public double getConversionFactor(String unit)
    {
        double conversionFactor = Double.NaN;

        if (unit.equals("Seconds"))
            conversionFactor = 1.0;
        else if (unit.equals("Milliseconds"))
            conversionFactor = 1000.0;
        else if (unit.equals("Minutes"))
            conversionFactor = 1.0 / 60.0;
        else if (unit.equals("Hours"))
            conversionFactor = 1.0 / 3600.0;
        else if (unit.equals("Days"))
            conversionFactor = 1.0 / 86400.0;
        else if (unit.equals("Weeks"))
            conversionFactor = 1.0 / 604800.0;
        else if (unit.equals("Fortnights"))
            conversionFactor = 1.0 / 1209600.0;
        else if (unit.equals("Years"))
            conversionFactor = 1.0 / 31536000.0;

        return conversionFactor;
    }
}
