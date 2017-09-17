package sample;

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
    public ListView<Measurement> listView;
    public ComboBox<String> comboBoxLeft;
    public ComboBox<String> comboBoxRight;
    public TextField textFieldLeft;
    public TextField textFieldRight;
    public Measurement currentMeasurement;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        listView.getItems().addAll(formListView());
        listView.getSelectionModel().selectFirst();
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setOnMouseClicked(e -> {
            Measurement selectedItem = listView.getSelectionModel().getSelectedItem();
            if (!currentMeasurement.equals(selectedItem))
                handleMeasurementSelect(selectedItem);
        });
        handleMeasurementSelect(listView.getSelectionModel().getSelectedItem());

        comboBoxLeft.getSelectionModel().selectFirst();
        comboBoxRight.getSelectionModel().selectFirst();
    }

    public void handleMeasurementSelect(Measurement value)
    {
        currentMeasurement = value;
        textFieldLeft.clear();
        textFieldRight.clear();
        comboBoxLeft.getItems().remove(0, comboBoxLeft.getItems().size());
        comboBoxRight.getItems().remove(0, comboBoxRight.getItems().size());
        comboBoxLeft.getItems().addAll(currentMeasurement.getUnits());
        comboBoxRight.getItems().addAll(currentMeasurement.getUnits());
    }

    public void handleLeftUnitAction()
    {
        if (!textFieldLeft.getText().isEmpty())
        {
            double currentValue = Double.parseDouble(textFieldLeft.getText());
            String currentUnit = comboBoxLeft.getSelectionModel().getSelectedItem();
            String newUnit = comboBoxRight.getSelectionModel().getSelectedItem();
            textFieldRight.setText(String.valueOf(currentMeasurement.convertValue(currentUnit, currentValue, newUnit)));
        }
    }

    public void handleRightUnitAction()
    {
        if (!textFieldRight.getText().isEmpty())
        {
            double currentValue = Double.parseDouble(textFieldRight.getText());
            String currentUnit = comboBoxRight.getSelectionModel().getSelectedItem();
            String newUnit = comboBoxLeft.getSelectionModel().getSelectedItem();
            textFieldLeft.setText(String.valueOf(currentMeasurement.convertValue(currentUnit, currentValue, newUnit)));
        }
    }

    public Measurement[] formListView()
    {
        Measurement[] items = { new Length(), new Mass(), new Time() };
        return items;
    }
}
