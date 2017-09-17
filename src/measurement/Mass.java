package measurement;

import java.util.ArrayList;
import java.util.Arrays;

public class Mass implements Measurement
{
    ArrayList<String> units;
    String[] massUnits = {
            "Milligrams", "Grams", "Kilograms", "Tonnes", "Ounces", "Pounds-Mass", "Stones"
    };

    public Mass()
    {
        units = new ArrayList<String>();
        units.addAll(Arrays.asList(massUnits));
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
        return "Mass";
    }

    public double getConversionFactor(String unit)
    {
        double conversionFactor = Double.NaN;

        if (unit.equals("Kilograms"))
            conversionFactor = 1.0;
        else if (unit.equals("Milligrams"))
            conversionFactor = 1000000.0;
        else if (unit.equals("Grams"))
            conversionFactor = 1000.0;
        else if (unit.equals("Tonnes"))
            conversionFactor = 0.001;
        else if (unit.equals("Ounces"))
            conversionFactor = 35.274;
        else if (unit.equals("Pounds-Mass"))
            conversionFactor = 2.20462;
        else if (unit.equals("Stones"))
            conversionFactor = 0.1575;

        return conversionFactor;
    }
}
