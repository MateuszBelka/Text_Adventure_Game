package initialisation;

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
    private static DoAttack doAttack;
    private static DoBack doBack;
    private static DoBreak doBreak;
    private static DoClose doClose;
    private static DoConsume doConsume;
    private static DoCut doCut;
    private static DoDrop doDrop;
    private static DoExamine doExamine;
    private static DoExit doExit;
    private static DoGetInventory doGetInventory;
    private static DoGiveItemToNPC doGiveItemToNPC;
    private static DoListen doListen;
    private static DoLoad doLoad;
    private static DoLook doLook;
    private static DoMove doMove;
    private static DoOpen doOpen;
    private static DoPickUp doPickUp;
    private static DoPull doPull;
    private static DoPush doPush;
    private static DoRead doRead;
    private static DoSave doSave;
    private static DoSmell doSmell;
    private static DoTalkWith doTalkWith;
    private static DoUnlock doUnlock;
    private static DoUse doUse;
    private static Commands commands;
    private static CommandsWith1ValidWord commandsWith1ValidWord;
    private static CommandsWith2ValidWords commandsWith2ValidWords;
    private static CommandsWith3ValidWords commandsWith3ValidWords;
    private static Directions directions;
    private static HandlerOf1Word handlerOf1Word;
    private static HandlerOf2Words handlerOf2Words;
    private static HandlerOf3Words handlerOf3Words;
    private static InputValidation inputValidation;
    private static Validation validation = new Validation();
    private static WordValidation wordValidation = new WordValidation();
    private static StoryTextGetter storyTextGetter = new StoryTextGetter();
    private static StoryTextPrinter storyTextPrinter = new StoryTextPrinter();
    private static Load loadFromFile;
    private static Save saveToFile;
    private static GameProgression gameProgression;
    private static PlayerLevellingProgression playerLevellingProgression = new PlayerLevellingProgression();
    private static Adventure adventure;
    private static LoadGame loadGame;
    private static NewGame newGame;
    private static Welcome welcome;
    private static UI ui;

    public static Adventure getAdventure() {
        return adventure;
    }

    public static LoadGame getLoadGame() {
        return loadGame;
    }

    public static NewGame getNewGame() {
        return newGame;
    }

    public static Welcome getWelcome() {
        return welcome;
    }

    public static UI getUi() {
        return ui;
    }

    public static DoAttack getDoAttack() {
        return doAttack;
    }

    public static DoBack getDoBack() {
        return doBack;
    }

    public static DoBreak getDoBreak() {
        return doBreak;
    }

    public static DoClose getDoClose() {
        return doClose;
    }

    public static DoConsume getDoConsume() {
        return doConsume;
    }

    public static DoCut getDoCut() {
        return doCut;
    }

    public static DoDrop getDoDrop() {
        return doDrop;
    }

    public static DoExamine getDoExamine() {
        return doExamine;
    }

    public static DoExit getDoExit() {
        return doExit;
    }

    public static DoGetInventory getDoGetInventory() {
        return doGetInventory;
    }

    public static DoGiveItemToNPC getDoGiveItemToNPC() {
        return doGiveItemToNPC;
    }

    public static DoListen getDoListen() {
        return doListen;
    }

    public static DoLoad getDoLoad() {
        return doLoad;
    }

    public static DoLook getDoLook() {
        return doLook;
    }

    public static DoMove getDoMove() {
        return doMove;
    }

    public static DoOpen getDoOpen() {
        return doOpen;
    }

    public static DoPickUp getDoPickUp() {
        return doPickUp;
    }

    public static DoPull getDoPull() {
        return doPull;
    }

    public static DoPush getDoPush() {
        return doPush;
    }

    public static DoRead getDoRead() {
        return doRead;
    }

    public static DoSave getDoSave() {
        return doSave;
    }

    public static DoSmell getDoSmell() {
        return doSmell;
    }

    public static DoTalkWith getDoTalkWith() {
        return doTalkWith;
    }

    public static DoUnlock getDoUnlock() {
        return doUnlock;
    }

    public static DoUse getDoUse() {
        return doUse;
    }

    public static Commands getCommands() {
        return commands;
    }

    public static CommandsWith1ValidWord getCommandsWith1ValidWord() {
        return commandsWith1ValidWord;
    }

    public static CommandsWith2ValidWords getCommandsWith2ValidWords() {
        return commandsWith2ValidWords;
    }

    public static CommandsWith3ValidWords getCommandsWith3ValidWords() {
        return commandsWith3ValidWords;
    }

    public static Directions getDirections() {
        return directions;
    }

    public static HandlerOf1Word getHandlerOf1Word() {
        return handlerOf1Word;
    }

    public static HandlerOf2Words getHandlerOf2Words() {
        return handlerOf2Words;
    }

    public static HandlerOf3Words getHandlerOf3Words() {
        return handlerOf3Words;
    }

    public static InputValidation getInputValidation() {
        return inputValidation;
    }

    public static Load getLoadFromFile() {
        return loadFromFile;
    }

    public static Save getSaveToFile() {
        return saveToFile;
    }

    public static PlayerLevellingProgression getPlayerProgression() {
        return playerLevellingProgression;
    }

    public static GameProgression getGameProgression() {
        return gameProgression;
    }

    public static Validation getValidation() {
        return validation;
    }

    public static WordValidation getWordValidation() {
        return wordValidation;
    }

    public static StoryTextGetter getStoryTextGetter() {
        return storyTextGetter;
    }

    public static StoryTextPrinter getStoryTextPrinter() {
        return storyTextPrinter;
    }
}
