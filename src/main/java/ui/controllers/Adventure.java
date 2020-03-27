package ui.controllers;


import engine.Engine;
import initialisation.InitOfStoryIndependentClasses;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/*
 * Responsible for Adventure Scene in UI
 * which carries out all of the frontend
 * for the main gameplay part of VU Quest
 */
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
        InitOfStoryIndependentClasses.setAdventure(Adventure.this);
        Engine.initializeGameScene(getTerminal());
    }

    /*
     * Called when user sends input
     * This input is send to main game loop
     */
    public void handleInput() {
        //Input Reading
        readAndClearInput();

        //main game loop call
        Engine.progressGame(getInputString(), getTerminal());
    }

    public void readAndClearInput() {
        setInputString(getInput().getText());
        getInput().clear();
    }

    public void updateUIElements() {
        //Update health, hunger, exp, level
    }
}
