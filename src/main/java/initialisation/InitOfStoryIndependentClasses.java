package initialisation;

import gameElements.battle.BattleSequence;
import gameElements.player.PlayerLevellingProgression;
import gameProgress.GameProgression;
import input.commands.*;
import input.validation.*;
import output.StoryTextGetter;
import output.StoryTextPrinter;
import saveAndLoad.Load;
import saveAndLoad.Save;
import ui.UI;
import ui.controllers.Adventure;
import ui.controllers.LoadGame;
import ui.controllers.NewGame;
import ui.controllers.Welcome;

public class InitOfStoryIndependentClasses {
    private static Adventure adventure;

    public static Adventure getAdventure() {
        return adventure;
    }
    public static void setAdventure(Adventure adventure) { InitOfStoryIndependentClasses.adventure = adventure; }
}
