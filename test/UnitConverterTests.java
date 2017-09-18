import org.junit.jupiter.api.Test;
import measurement.*;
import javafx.fxml.Initializable;
import view.Controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testTextFieldNoSciNot()
    {
        Controller testController = new Controller();
        String testText = "123456789";
        String expectedText = "1234567";
        assertEquals(expectedText, testController.handleTextFieldNoSciNot(testText));
    }

    @Test
    public void testTextFieldSciNot()
    {
        Controller testController = new Controller();
        String testText = "123456789E-5";
        String expectedText = "1234E-5";
        assertEquals(expectedText, testController.handleTextFieldSciNot(testText));
    }
}
