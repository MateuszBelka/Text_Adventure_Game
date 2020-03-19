package ui.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Adventure {

    private String inputString;
    public String getInputString() {
        return inputString;
    }
    private void setInputString(String inputString) {
        this.inputString = inputString;
    }

    @FXML
    TextField input;

    @FXML
    TextArea terminal;

    public void readInput() {
        setInputString(input.getText());
        input.clear();

        appendToOutput(getInputString());
    }

    public void appendToOutput(String newOutput) {
        terminal.appendText(newOutput + "\n");
    }
}
