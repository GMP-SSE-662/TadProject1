import measurement.*;
import org.junit.jupiter.api.Test;

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
}
