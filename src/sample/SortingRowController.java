package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Collections;

public class SortingRowController {

    @FXML
    TextArea textArea;

    /**
     * Sorts the list of numbers in the TextArea ascending.
     * List must be separated by a comma.
     * Each given ID must be a number.
     */
    public void sortTextField() {
        // Removing all white-spaces
        String inputString = textArea.getText().replaceAll("\\s", "");
        // Checking for invalid Input
        if (!inputString.contains(",")) {
            alertError("Keine mit Komma getrennte Liste");
            return;
        }
        String[] inputArray = inputString.split(String.valueOf(','));

        // Iterating through each ID, converting them to long
        ArrayList<Long> numbers = new ArrayList<>();
        try {
            for (String number : inputArray) {
                numbers.add(Long.parseLong(number));
            }
        } catch (NumberFormatException nfe) {
            alertError("Bitte nur Zahlen eingeben");
            return;
        }

        Collections.sort(numbers);

        // Converting the Numbers back to a String
        textArea.setText(numbers.get(0).toString());
        numbers.remove(0);
        for (long number : numbers) {
            textArea.appendText(", "+number);
        }

        textArea.selectAll();
        textArea.copy();
        textArea.deselect();
    }

    /**
     * Alerts the user of an error
     * @param message The message to be shown
     */
    private void alertError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ein Fehler ist aufgetreten");
        alert.setContentText(message);
        alert.show();

    }

}
