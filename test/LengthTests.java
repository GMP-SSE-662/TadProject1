import org.junit.jupiter.api.Test;
import measurement.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LengthTests
{
    final double EPSILON = 0.0001;

    @Test
    public void testLengthExists()
    {
        Length testLength = new Length();
        assertNotNull(testLength);
    }

    @Test
    public void testLengthIsMeasurement()
    {
        Length testLength = new Length();
        assertTrue(testLength instanceof Measurement);
    }

    @Test
    public void testLengthTypes()
    {
        String[] testLengthUnits = {
                "Millimeters", "Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards", "Miles"
        };
        Length testLength = new Length();

        assertEquals(Arrays.asList(testLengthUnits), testLength.getUnits());
    }

    @Test
    public void testLengthToString()
    {
        Length testLength = new Length();
        assertEquals("Length", testLength.toString());
    }

    @Test
    public void testLengthConversionFactor1()
    {
        String unit = "Meters";
        double convFactor = 1.0;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor2()
    {
        String unit = "Millimeters";
        double convFactor = 1000.0;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor3()
    {
        String unit = "Centimeters";
        double convFactor = 100.0;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor4()
    {
        String unit = "Kilometers";
        double convFactor = 0.001;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor5()
    {
        String unit = "Inches";
        double convFactor = 39.37;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor6()
    {
        String unit = "Feet";
        double convFactor = 3.281;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor7()
    {
        String unit = "Yards";
        double convFactor = 1.09361329;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor8()
    {
        String unit = "Miles";
        double convFactor = 0.000621371;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConvertValue1()
    {
        String currentUnit = "Centimeters";
        String newUnit = "Millimeters";
        double currentValue = 40.0;
        double expectedResult = 400.0;
        Length testLength = new Length();

        double newValue = testLength.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testLengthConvertValue2()
    {
        String currentUnit = "Yards";
        String newUnit = "Miles";
        double currentValue = 6000.0;
        double expectedResult = 3.409091;
        Length testLength = new Length();

        double newValue = testLength.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testLengthConvertValue3()
    {
        String currentUnit = "Meters";
        String newUnit = "Inches";
        double currentValue = 3.0;
        double expectedResult = 118.11;
        Length testLength = new Length();

        double newValue = testLength.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }
}
