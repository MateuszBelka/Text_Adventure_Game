package ui.controllers;


import engine.Engine;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStoryIndependentClasses;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
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
    @FXML
    private ProgressBar healthBar;
    @FXML
    private ProgressBar hungerBar;
    @FXML
    private ProgressBar expBar;
    @FXML
    private Text healthText;
    @FXML
    private Text hungerText;
    @FXML
    private Text expText;
    @FXML
    private Label levelText;

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
     *
     * ActionEvent is necessary to quit UI or switch scenes
     */
    public void handleInput(ActionEvent actionEvent) throws IOException {
        //Input Reading
        readAndClearInput();

        //main game loop call
        Engine.progressGame(getInputString(), getTerminal(), actionEvent);
    }

    public void readAndClearInput() {
        setInputString(getInput().getText());
        getInput().clear();
    }

    public void updateUIElements() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        // Update health
        int healthPercent = playerStats.getCurrentHealth()/playerStats.getMaximumXP();
        String currentHealth = Integer.toString(playerStats.getCurrentHealth());
        String maxHealth = Integer.toString(playerStats.getMaximumXP());

        healthBar.setProgress(healthPercent);
        healthText.setText(currentHealth + "/" + maxHealth);

        // Update hunger
        int hungerPercent = playerStats.getCurrentHunger()/playerStats.getMaxHunger();
        String currentHunger = Integer.toString(playerStats.getCurrentHunger());
        String maxHunger = Integer.toString(playerStats.getMaxHunger());

        hungerBar.setProgress(hungerPercent);
        hungerText.setText(currentHunger + "/" + maxHunger);

        // Update experience
        int xpPercent = playerStats.getCurrentXP()/playerStats.getMaximumXP();
        String currentXP = Integer.toString(playerStats.getCurrentXP());
        String maxXP = Integer.toString(playerStats.getMaximumXP());

        expBar.setProgress(xpPercent);
        expText.setText(currentXP + "/" + maxXP);

        // Update level
        String playerLevel = Integer.toString(playerStats.getPlayerLevel());

        levelText.setText(playerLevel);
    }
}
