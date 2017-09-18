import org.junit.jupiter.api.Test;
import measurement.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
                "Milligrams", "Grams", "Kilograms", "Tonnes", "Ounces", "Pounds-Mass", "Stones"
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
        String unit = "Kilograms";
        double convFactor = 1.0;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor2()
    {
        String unit = "Milligrams";
        double convFactor = 1000000.0;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor3()
    {
        String unit = "Grams";
        double convFactor = 1000.0;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor4()
    {
        String unit = "Tonnes";
        double convFactor = 0.001;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor5()
    {
        String unit = "Ounces";
        double convFactor = 35.274;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor6()
    {
        String unit = "Pounds-Mass";
        double convFactor = 2.20462;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor7()
    {
        String unit = "Stones";
        double convFactor = 0.1575;
        Mass testMass = new Mass();
        assertEquals(convFactor, testMass.getConversionFactor(unit));
    }

    @Test
    public void testMassConvertValue1()
    {
        String currentUnit = "Milligrams";
        String newUnit = "Grams";
        double currentValue = 4.0;
        double expectedResult = 0.004;
        Mass testMass = new Mass();

        double newValue = testMass.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testMassConvertValue2()
    {
        String currentUnit = "Stones";
        String newUnit = "Pounds-Mass";
        double currentValue = 5.0;
        double expectedResult = 69.9879;
        Mass testMass = new Mass();

        double newValue = testMass.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testMassConvertValue3()
    {
        String currentUnit = "Ounces";
        String newUnit = "Tonnes";
        double currentValue = 15000.0;
        double expectedResult = 0.42524;
        Mass testMass = new Mass();

        double newValue = testMass.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }
}
