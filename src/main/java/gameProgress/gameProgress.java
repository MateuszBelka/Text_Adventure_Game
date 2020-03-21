package gameProgress;

import gameElements.player.Player;
import initialisation.CollectionOfAllClasses;

public class gameProgress {
    Player player = CollectionOfAllClasses.getPlayer();
    Integer amountOfLevels = CollectionOfAllClasses.getLevels().size();

    public void updateGameProgress(){
        if (player.getCurrentLevel().getPuzzles().equals(0)){
            checkGameCompletion();
        }
    }

    private void checkGameCompletion(){
        if (player.getCurrentLevel().equals(amountOfLevels - 1)){
            //todo: Game Completed message, press enter to continue message, and return to welcome screen.
        }
        else updateLevel();
    }

    private void updateLevel(){
        for (int i = 0; i < amountOfLevels; i++){
            if (player.getCurrentLevel().equals(CollectionOfAllClasses.getLevels().get(i))){
                player.setCurrentLevel(CollectionOfAllClasses.getLevels().get(i + 1));
                player.setCurrentLocation(player.getCurrentLevel().getStartLocation());
            }
        }
    }
}