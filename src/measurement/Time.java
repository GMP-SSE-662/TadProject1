package measurement;

import java.util.ArrayList;
import java.util.Arrays;

public class Time implements Measurement
{
    final String MILLISECONDS = "Milliseconds";
    final String SECONDS = "Seconds";
    final String MINUTES = "Minutes";
    final String HOURS = "Hours";
    final String DAYS = "Days";
    final String WEEKS = "Weeks";
    final String FORTNIGHTS = "Fortnights";
    final String YEARS = "Years";

    ArrayList<String> units;
    String[] timeUnits = {
            MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS, WEEKS, FORTNIGHTS, YEARS
    };

    public Time()
    {
        units = new ArrayList<>();
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

        if (unit.equals(SECONDS))
            conversionFactor = 1.0;
        else if (unit.equals(MILLISECONDS))
            conversionFactor = 1000.0;
        else if (unit.equals(MINUTES))
            conversionFactor = 1.0 / 60.0;
        else if (unit.equals(HOURS))
            conversionFactor = 1.0 / 3600.0;
        else if (unit.equals(DAYS))
            conversionFactor = 1.0 / 86400.0;
        else if (unit.equals(WEEKS))
            conversionFactor = 1.0 / 604800.0;
        else if (unit.equals(FORTNIGHTS))
            conversionFactor = 1.0 / 1209600.0;
        else if (unit.equals(YEARS))
            conversionFactor = 1.0 / 31536000.0;

        return conversionFactor;
    }
}
