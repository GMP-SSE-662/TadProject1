import measurement.Mass;
import measurement.Measurement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MassTests
{
    final double EPSILON = 0.0001;

    @Test
    public void testMassExists()
    {
        Mass testMass = new Mass();
        assertNotNull(testMass);
    }

    @Test
    public void testMassIsMeasurement()
    {
        Mass testMass = new Mass();
        assertTrue(testMass instanceof Measurement);
    }

    @Test
    public void testMassTypes()
    {
        String[] testMassUnits = {
                "Millimeters", "Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards", "Miles"
        };
        Mass testMass = new Mass();

        assertEquals(Arrays.asList(testMassUnits), testMass.getUnits());
    }

    @Test
    public void testMassToString()
    {
        Mass testMass = new Mass();
        assertEquals("Mass", testMass.toString());
    }

    @Test
    public void testMassConversionFactor1()
    {
        String unit = "Meters";
        double convFactor = 1.0;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor2()
    {
        String unit = "Millimeters";
        double convFactor = 1000.0;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor3()
    {
        String unit = "Centimeters";
        double convFactor = 100.0;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor4()
    {
        String unit = "Kilometers";
        double convFactor = 0.001;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor5()
    {
        String unit = "Inches";
        double convFactor = 39.37;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor6()
    {
        String unit = "Feet";
        double convFactor = 3.281;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor7()
    {
        String unit = "Yards";
        double convFactor = 1.09361329;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor8()
    {
        String unit = "Miles";
        double convFactor = 0.000621371;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConvertValue1()
    {
        String currentUnit = "Centimeters";
        String newUnit = "Millimeters";
        double currentValue = 40.0;
        double expectedResult = 400.0;
        Mass testMass = new Mass();

        double newValue = testMass.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testMassConvertValue2()
    {
        String currentUnit = "Yards";
        String newUnit = "Miles";
        double currentValue = 6000.0;
        double expectedResult = 3.409091;
        Mass testMass = new Mass();

        double newValue = testMass.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testMassConvertValue3()
    {
        String currentUnit = "Meters";
        String newUnit = "Inches";
        double currentValue = 3.0;
        double expectedResult = 118.11;
        Mass testMass = new Mass();

        double newValue = testMass.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }
}
