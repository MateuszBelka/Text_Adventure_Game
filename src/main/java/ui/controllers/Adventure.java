package ui.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import initialisation.CollectionOfAllClasses;
import storyText.StoryTextPrinter;
import input.commands.CommandHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class Adventure implements Initializable {

    private String inputString;
    @FXML
    private TextField input;
    @FXML
    private TextArea terminal;

    //Get Methods
    public String getInputString() {
        return inputString;
    }
    public TextField getInput() {
        return input;
    }
    public TextArea getTerminal() {
        return terminal;
    }

    //Set Methods
    private void setInputString(String inputString) {
        this.inputString = inputString;
    }

    /* Present initial story output to user when the scene is loaded
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StoryTextPrinter.printStory(getTerminal());
    }

    /* Responsible for moving the game forward; main loop of the game
     * Called automatically when user sends new input.
     * As such game is updated only as a response to user input.
     */
    public void handleInputUpdateAndOutput() {
        //Input Reading
        readAndClearInput();

        //Update Game through Input Validation
        CommandHandler.temporaryInputReceiver(getInputString(), CollectionOfAllClasses.getPlayer());

        //Output Printing
        StoryTextPrinter.printStory(getTerminal());
    }

    public void readAndClearInput() {
        setInputString(getInput().getText());
        getInput().clear();
    }
}