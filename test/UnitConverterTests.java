import javafx.fxml.Initializable;
import measurement.Length;
import measurement.Measurement;
import org.junit.jupiter.api.Test;
import sample.Controller;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UnitConverterTests
{
    @Test
    public void controllerOverridesInitialize()
    {
        Controller testController = new Controller();
        assertTrue(testController instanceof Initializable);
    }
}
