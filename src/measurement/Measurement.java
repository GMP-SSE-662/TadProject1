package measurement;

import java.util.ArrayList;

public interface Measurement
{
    public ArrayList<String> getUnits();
    public double convertValue(String currentUnit, double currentValue, String newUnit);
}
