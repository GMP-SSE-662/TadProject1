import measurement.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitConverterTests
{
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
        double convFactor = 39.3700787;
        Length testLength = new Length();
        assertEquals(convFactor, testLength.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor6()
    {
        String unit = "Feet";
        double convFactor = 3.280839895;
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
}
