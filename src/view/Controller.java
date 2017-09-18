package view;

import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import measurement.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    public ListView<Measurement> measurementSelect;
    public ComboBox<String> unitSelectLeft;
    public ComboBox<String> unitSelectRight;
    public TextField unitValueInputLeft;
    public TextField unitValueInputRight;
    public Measurement currentMeasurement;

    final int MAX_NO_SCI_LENGTH = 7;
    final int MAX_SCI_LENGTH = 4;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        measurementSelect.getItems().addAll(formListView());
        measurementSelect.getSelectionModel().selectFirst();
        measurementSelect.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        measurementSelect.setOnMouseClicked(e -> {
            Measurement selectedItem = measurementSelect.getSelectionModel().getSelectedItem();
            if (!currentMeasurement.equals(selectedItem))
                handleMeasurementSelect(selectedItem);
        });
        handleMeasurementSelect(measurementSelect.getSelectionModel().getSelectedItem());

        unitSelectLeft.getSelectionModel().selectFirst();
        unitSelectRight.getSelectionModel().selectFirst();
    }

    public void handleMeasurementSelect(Measurement value)
    {
        currentMeasurement = value;
        unitValueInputLeft.clear();
        unitValueInputRight.clear();
        unitSelectLeft.getItems().remove(0, unitSelectLeft.getItems().size());
        unitSelectRight.getItems().remove(0, unitSelectRight.getItems().size());
        unitSelectLeft.getItems().addAll(currentMeasurement.getUnits());
        unitSelectRight.getItems().addAll(currentMeasurement.getUnits());
        unitSelectLeft.getSelectionModel().selectFirst();
        unitSelectRight.getSelectionModel().selectFirst();
    }

    public void handleLeftUnitAction()
    {
        changeOtherUnit(unitValueInputLeft, unitValueInputRight, unitSelectLeft, unitSelectRight);
    }

    public void handleRightUnitAction()
    {
        changeOtherUnit(unitValueInputRight, unitValueInputLeft, unitSelectRight, unitSelectLeft);
    }

    public void changeOtherUnit(TextField input, TextField output, ComboBox<String> inputSelect, ComboBox<String> outputSelect)
    {
        if (!input.getText().isEmpty())
        {
            double currentValue = Double.parseDouble(input.getText());
            String currentUnit = inputSelect.getSelectionModel().getSelectedItem();
            String newUnit = outputSelect.getSelectionModel().getSelectedItem();
            String leftText = String.valueOf(currentMeasurement.convertValue(currentUnit, currentValue, newUnit));
            if (leftText.length() > MAX_NO_SCI_LENGTH && !leftText.contains("E"))
                output.setText(handleTextFieldNoSciNot(leftText));
            else if (leftText.length() > MAX_SCI_LENGTH && leftText.contains("E"))
                output.setText(handleTextFieldSciNot(leftText));
            else
                output.setText(leftText);
        }
    }

    public String handleTextFieldNoSciNot(String text)
    {
        text = text.substring(0, MAX_NO_SCI_LENGTH);
        return text;
    }

    public String handleTextFieldSciNot(String text)
    {
        String numText = text.substring(0, MAX_SCI_LENGTH);
        String sciText = text.substring(text.indexOf("E"), text.length());
        text = numText + sciText;

        return text;
    }

    public Measurement[] formListView()
    {
        Measurement[] items = { new Length(), new Mass(), new Time() };
        return items;
    }
}
