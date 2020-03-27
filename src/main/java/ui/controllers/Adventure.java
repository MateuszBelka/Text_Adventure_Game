package ui.controllers;


import engine.Engine;
import gameElements.battle.BattleSequence;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import initialisation.InitOfClassesThroughSaveFile;
import output.StoryTextPrinter;
import input.validation.InputValidation;

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


    /*
     * Called when user sends input
     * This input is send to main game loop
     */
    public void handleInput() {
        //Input Reading
        readAndClearInput();

        //
        Engine.progressGame(getInputString(), getTerminal());
    }

    public void readAndClearInput() {
        setInputString(getInput().getText());
        getInput().clear();
    }
}
