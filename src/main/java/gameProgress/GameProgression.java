package gameProgress;

import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

public class GameProgression {
    private transient PlayerStats playerStats;
    private transient Integer amountOfLevels;

    public PlayerStats getPlayerStats() {
        return playerStats;
    }
    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }
    public Integer getAmountOfLevels() {
        return amountOfLevels;
    }
    public void setAmountOfLevels(Integer amountOfLevels) {
        this.amountOfLevels = amountOfLevels;
    }

    public void updateGameProgress(){
        if (playerStats.getCurrentLevel().getPuzzles().equals(0)){
            checkGameCompletion();
        }
    }

    private void checkGameCompletion(){
        if (playerStats.getCurrentLevel().equals(amountOfLevels - 1)){
            //todo: Game Completed message, press enter to continue message, and return to welcome screen.
        }
        else updateLevel();
    }

    private void updateLevel(){
        for (int i = 0; i < amountOfLevels; i++){
            if (playerStats.getCurrentLevel().equals(InitOfClassesThroughSaveFile.getLevels().get(i))){
                // error: setCurrentLevel(Level) has protected access in Player
//                player.setCurrentLevel(CollectionOfAllClasses.getLevels().get(i + 1));
                //error: setCurrentLocation(Location) has protected access in Player
//                player.setCurrentLocation(player.getCurrentLevel().getStartLocation());
            }
        }
    }
}
