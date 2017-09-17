import org.junit.jupiter.api.Test;import javafx.fxml.Initializable;
import measurement.*;
import sample.Controller;

import static org.junit.jupiter.api.Assertions.*;

public class UnitConverterTests
{
    @Test
    public void controllerOverridesInitialize()
    {
        Controller testController = new Controller();
        assertTrue(testController instanceof Initializable);
    }

    @Test
    public void testListViewContainsLength()
    {
        boolean hasInstance = false;
        Controller testController = new Controller();
        Measurement[] items = testController.formListView();
        for (Measurement m : items)
        {
            hasInstance = m instanceof Length;
            if (hasInstance)
                break;
        }
        assertTrue(hasInstance);
    }

    @Test
    public void testListViewContainsMass()
    {
        boolean hasInstance = false;
        Controller testController = new Controller();
        Measurement[] items = testController.formListView();
        for (Measurement m : items)
        {
            hasInstance = m instanceof Mass;
            if (hasInstance)
                break;
        }
        assertTrue(hasInstance);
    }

    @Test
    public void testListViewContainsTime()
    {
        boolean hasInstance = false;
        Controller testController = new Controller();
        Measurement[] items = testController.formListView();
        for (Measurement m : items)
        {
            hasInstance = m instanceof Time;
            if (hasInstance)
                break;
        }
        assertTrue(hasInstance);
    }
}
