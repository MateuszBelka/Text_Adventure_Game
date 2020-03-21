package gameElements.player;

import initialisation.CollectionOfAllClasses;

public class PlayerProgress {
    Player player = CollectionOfAllClasses.getPlayer();
    public void increaseCurrentXP() {
        final int increaseCurrentXPby = player.getMaximumXP() / (player.getPlayerLevel() * 30); //this //todo: ?
        final int newCurrentXP = player.getCurrentXP() + increaseCurrentXPby;

        if (newCurrentXP < player.getMaximumXP()) { //when updated xp < max xp
            player.setCurrentXP(newCurrentXP);
        }
        else {
            player.setCurrentXP(newCurrentXP-player.getMaximumXP()); //when updated xp >= max xp
            player.incrementPlayerLevel();
            player.increaseMaximumXP();
        }
    }
}
