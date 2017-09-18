import org.junit.jupiter.api.Test;
import measurement.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeTests
{
    final double EPSILON = 0.0001;

    @Test
    public void testTimeExists()
    {
        Time testTime = new Time();
        assertNotNull(testTime);
    }

    @Test
    public void testTimeIsMeasurement()
    {
        Time testTime = new Time();
        assertTrue(testTime instanceof Measurement);
    }

    @Test
    public void testTimeTypes()
    {
        String[] testTimeUnits = {
                "Milliseconds", "Seconds", "Minutes", "Hours", "Days", "Weeks", "Fortnights", "Years"
        };
        Time testTime = new Time();

        assertEquals(Arrays.asList(testTimeUnits), testTime.getUnits());
    }

    @Test
    public void testTimeToString()
    {
        Time testTime = new Time();
        assertEquals("Time", testTime.toString());
    }

    @Test
    public void testTimeConversionFactor1()
    {
        String unit = "Seconds";
        double convFactor = 1.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor2()
    {
        String unit = "Milliseconds";
        double convFactor = 1000.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor3()
    {
        String unit = "Minutes";
        double convFactor = 1.0 / 60.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor4()
    {
        String unit = "Hours";
        double convFactor = 1.0 / 3600.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor5()
    {
        String unit = "Days";
        double convFactor = 1.0 / 86400.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor6()
    {
        String unit = "Weeks";
        double convFactor = 1.0 / 604800.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor7()
    {
        String unit = "Fortnights";
        double convFactor = 1.0 / 1209600.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor8()
    {
        String unit = "Years";
        double convFactor = 1.0 / 31536000.0;
        Time testTime = new Time();
        assertEquals(convFactor, testTime.getConversionFactor(unit));
    }

    @Test
    public void testTimeConvertValue1()
    {
        String currentUnit = "Years";
        String newUnit = "Days";
        double currentValue = 2.0;
        double expectedResult = 730.0;
        Time testTime = new Time();

        double newValue = testTime.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testTimeConvertValue2()
    {
        String currentUnit = "Weeks";
        String newUnit = "Fortnights";
        double currentValue = 5.0;
        double expectedResult = 2.5;
        Time testTime = new Time();

        double newValue = testTime.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testTimeConvertValue3()
    {
        String currentUnit = "Milliseconds";
        String newUnit = "Hours";
        double currentValue = 10000000.0;
        double expectedResult = 2.7778;
        Time testTime = new Time();

        double newValue = testTime.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }
}
