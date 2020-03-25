package initialisation;

import gameElements.player.*;
import gameElements.levelAndContents.*;
import input.commands.DoAttack;
import input.validation.*;
import output.*;
import gameProgress.*;
import input.commands.*;
import saveAndLoad.Load;
import saveAndLoad.Save;
import ui.UI;
import ui.controllers.Adventure;
import ui.controllers.LoadGame;
import ui.controllers.NewGame;
import ui.controllers.Welcome;

import java.util.ArrayList;

/*
 * Benefit of maintaining all variables as static in a class
 * that will always have only one instance at a time is that
 * no one has to ever keep track of instances of the class
 * and in case they have to be created,
 * then they can be immediately set to null (deleted)
 */
public class CollectionOfAllClasses {
    private static ArrayList<Item> items;
    private static ArrayList<Level> levels;
    private static ArrayList<Location> locations;
    private static ArrayList<NPC> npcs;
    private static Inventory inventory;
    private static Player player;
    private static PlayerProgression playerProgression;
    private static GameProgression gameProgression;
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
    private static Validation validation;
    private static WordValidation wordValidation;
    private static StoryTextGetter storyTextGetter;
    private static StoryTextPrinter storyTextPrinter;
    private static Load loadFromFile;
    private static Save saveToFile;
    private static Adventure adventure;
    private static LoadGame loadGame;
    private static NewGame newGame;
    private static Welcome welcome;
    private static UI ui;

    //Getter + Setter
    public static ArrayList<Item> getItems() {
        return items;
    }
    public static void setItems(ArrayList<Item> items) {
        CollectionOfAllClasses.items = items;
    }
    public static ArrayList<Level> getLevels() {
        return levels;
    }
    public static void setLevels(ArrayList<Level> levels) {
        CollectionOfAllClasses.levels = levels;
    }
    public static ArrayList<Location> getLocations() {
        return locations;
    }
    public static void setLocations(ArrayList<Location> locations) {
        CollectionOfAllClasses.locations = locations;
    }
    public static ArrayList<NPC> getNpcs() {
        return npcs;
    }
    public static void setNpcs(ArrayList<NPC> npcs) {
        CollectionOfAllClasses.npcs = npcs;
    }
    public static Inventory getInventory() {
        return inventory;
    }
    public static void setInventory(Inventory inventory) {
        CollectionOfAllClasses.inventory = inventory;
    }
    public static Player getPlayer() {
        return player;
    }
    public static void setPlayer(Player player) {
        CollectionOfAllClasses.player = player;
    }
    public static PlayerProgression getPlayerProgression() {
        return playerProgression;
    }
    public static void setPlayerProgression(PlayerProgression playerProgression) {
        CollectionOfAllClasses.playerProgression = playerProgression;
    }
    public static GameProgression getGameProgression() {
        return gameProgression;
    }
    public static void setGameProgression(GameProgression gameProgression) {
        CollectionOfAllClasses.gameProgression = gameProgression;
    }
    public static DoAttack getDoAttack() {
        return doAttack;
    }
    public static void setDoAttack(DoAttack doAttack) {
        CollectionOfAllClasses.doAttack = doAttack;
    }
    public static DoBack getDoBack() {
        return doBack;
    }
    public static void setDoBack(DoBack doBack) {
        CollectionOfAllClasses.doBack = doBack;
    }
    public static DoBreak getDoBreak() {
        return doBreak;
    }
    public static void setDoBreak(DoBreak doBreak) {
        CollectionOfAllClasses.doBreak = doBreak;
    }
    public static DoClose getDoClose() {
        return doClose;
    }
    public static void setDoClose(DoClose doClose) {
        CollectionOfAllClasses.doClose = doClose;
    }
    public static DoConsume getDoConsume() {
        return doConsume;
    }
    public static void setDoConsume(DoConsume doConsume) {
        CollectionOfAllClasses.doConsume = doConsume;
    }
    public static DoCut getDoCut() {
        return doCut;
    }
    public static void setDoCut(DoCut doCut) {
        CollectionOfAllClasses.doCut = doCut;
    }
    public static DoDrop getDoDrop() {
        return doDrop;
    }
    public static void setDoDrop(DoDrop doDrop) {
        CollectionOfAllClasses.doDrop = doDrop;
    }
    public static DoExamine getDoExamine() {
        return doExamine;
    }
    public static void setDoExamine(DoExamine doExamine) {
        CollectionOfAllClasses.doExamine = doExamine;
    }
    public static DoExit getDoExit() {
        return doExit;
    }
    public static void setDoExit(DoExit doExit) {
        CollectionOfAllClasses.doExit = doExit;
    }
    public static DoGetInventory getDoGetInventory() {
        return doGetInventory;
    }
    public static void setDoGetInventory(DoGetInventory doGetInventory) {
        CollectionOfAllClasses.doGetInventory = doGetInventory;
    }
    public static DoGiveItemToNPC getDoGiveItemToNPC() {
        return doGiveItemToNPC;
    }
    public static void setDoGiveItemToNPC(DoGiveItemToNPC doGiveItemToNPC) {
        CollectionOfAllClasses.doGiveItemToNPC = doGiveItemToNPC;
    }
    public static DoListen getDoListen() {
        return doListen;
    }
    public static void setDoListen(DoListen doListen) {
        CollectionOfAllClasses.doListen = doListen;
    }
    public static DoLoad getDoLoad() {
        return doLoad;
    }
    public static void setDoLoad(DoLoad doLoad) {
        CollectionOfAllClasses.doLoad = doLoad;
    }
    public static DoLook getDoLook() {
        return doLook;
    }
    public static void setDoLook(DoLook doLook) {
        CollectionOfAllClasses.doLook = doLook;
    }
    public static DoMove getDoMove() {
        return doMove;
    }
    public static void setDoMove(DoMove doMove) {
        CollectionOfAllClasses.doMove = doMove;
    }
    public static DoOpen getDoOpen() {
        return doOpen;
    }
    public static void setDoOpen(DoOpen doOpen) {
        CollectionOfAllClasses.doOpen = doOpen;
    }
    public static DoPickUp getDoPickUp() {
        return doPickUp;
    }
    public static void setDoPickUp(DoPickUp doPickUp) {
        CollectionOfAllClasses.doPickUp = doPickUp;
    }
    public static DoPull getDoPull() {
        return doPull;
    }
    public static void setDoPull(DoPull doPull) {
        CollectionOfAllClasses.doPull = doPull;
    }
    public static DoPush getDoPush() {
        return doPush;
    }
    public static void setDoPush(DoPush doPush) {
        CollectionOfAllClasses.doPush = doPush;
    }
    public static DoRead getDoRead() {
        return doRead;
    }
    public static void setDoRead(DoRead doRead) {
        CollectionOfAllClasses.doRead = doRead;
    }
    public static DoSave getDoSave() {
        return doSave;
    }
    public static void setDoSave(DoSave doSave) {
        CollectionOfAllClasses.doSave = doSave;
    }
    public static DoSmell getDoSmell() {
        return doSmell;
    }
    public static void setDoSmell(DoSmell doSmell) {
        CollectionOfAllClasses.doSmell = doSmell;
    }
    public static DoTalkWith getDoTalkWith() {
        return doTalkWith;
    }
    public static void setDoTalkWith(DoTalkWith doTalkWith) {
        CollectionOfAllClasses.doTalkWith = doTalkWith;
    }
    public static DoUnlock getDoUnlock() {
        return doUnlock;
    }
    public static void setDoUnlock(DoUnlock doUnlock) {
        CollectionOfAllClasses.doUnlock = doUnlock;
    }
    public static DoUse getDoUse() {
        return doUse;
    }
    public static void setDoUse(DoUse doUse) {
        CollectionOfAllClasses.doUse = doUse;
    }
    public static Commands getCommands() {
        return commands;
    }
    public static void setCommands(Commands commands) {
        CollectionOfAllClasses.commands = commands;
    }
    public static CommandsWith1ValidWord getCommandsWith1ValidWord() {
        return commandsWith1ValidWord;
    }
    public static void setCommandsWith1ValidWord(CommandsWith1ValidWord commandsWith1ValidWord) {
        CollectionOfAllClasses.commandsWith1ValidWord = commandsWith1ValidWord;
    }
    public static CommandsWith2ValidWords getCommandsWith2ValidWords() {
        return commandsWith2ValidWords;
    }
    public static void setCommandsWith2ValidWords(CommandsWith2ValidWords commandsWith2ValidWords) {
        CollectionOfAllClasses.commandsWith2ValidWords = commandsWith2ValidWords;
    }
    public static CommandsWith3ValidWords getCommandsWith3ValidWords() {
        return commandsWith3ValidWords;
    }
    public static void setCommandsWith3ValidWords(CommandsWith3ValidWords commandsWith3ValidWords) {
        CollectionOfAllClasses.commandsWith3ValidWords = commandsWith3ValidWords;
    }
    public static Directions getDirections() {
        return directions;
    }
    public static void setDirections(Directions directions) {
        CollectionOfAllClasses.directions = directions;
    }
    public static HandlerOf1Word getHandlerOf1Word() {
        return handlerOf1Word;
    }
    public static void setHandlerOf1Word(HandlerOf1Word handlerOf1Word) {
        CollectionOfAllClasses.handlerOf1Word = handlerOf1Word;
    }
    public static HandlerOf2Words getHandlerOf2Words() {
        return handlerOf2Words;
    }
    public static void setHandlerOf2Words(HandlerOf2Words handlerOf2Words) {
        CollectionOfAllClasses.handlerOf2Words = handlerOf2Words;
    }
    public static HandlerOf3Words getHandlerOf3Words() {
        return handlerOf3Words;
    }
    public static void setHandlerOf3Words(HandlerOf3Words handlerOf3Words) {
        CollectionOfAllClasses.handlerOf3Words = handlerOf3Words;
    }
    public static InputValidation getInputValidation() {
        return inputValidation;
    }
    public static void setInputValidation(InputValidation inputValidation) {
        CollectionOfAllClasses.inputValidation = inputValidation;
    }
    public static Validation getValidation() {
        return validation;
    }
    public static void setValidation(Validation validation) {
        CollectionOfAllClasses.validation = validation;
    }
    public static WordValidation getWordValidation() {
        return wordValidation;
    }
    public static void setWordValidation(WordValidation wordValidation) {
        CollectionOfAllClasses.wordValidation = wordValidation;
    }
    public static StoryTextGetter getStoryTextGetter() {
        return storyTextGetter;
    }
    public static void setStoryTextGetter(StoryTextGetter storyTextGetter) {
        CollectionOfAllClasses.storyTextGetter = storyTextGetter;
    }
    public static StoryTextPrinter getStoryTextPrinter() {
        return storyTextPrinter;
    }
    public static void setStoryTextPrinter(StoryTextPrinter storyTextPrinter) {
        CollectionOfAllClasses.storyTextPrinter = storyTextPrinter;
    }
    public static Load getLoadFromFile() {
        return loadFromFile;
    }
    public static void setLoadFromFile(Load loadFromFile) {
        CollectionOfAllClasses.loadFromFile = loadFromFile;
    }
    public static Save getSaveToFile() {
        return saveToFile;
    }
    public static void setSaveToFile(Save saveToFile) {
        CollectionOfAllClasses.saveToFile = saveToFile;
    }
    public static Adventure getAdventure() {
        return adventure;
    }
    public static void setAdventure(Adventure adventure) {
        CollectionOfAllClasses.adventure = adventure;
    }
    public static LoadGame getLoadGame() {
        return loadGame;
    }
    public static void setLoadGame(LoadGame loadGame) {
        CollectionOfAllClasses.loadGame = loadGame;
    }
    public static NewGame getNewGame() {
        return newGame;
    }
    public static void setNewGame(NewGame newGame) {
        CollectionOfAllClasses.newGame = newGame;
    }
    public static Welcome getWelcome() {
        return welcome;
    }
    public static void setWelcome(Welcome welcome) {
        CollectionOfAllClasses.welcome = welcome;
    }
    public static UI getUi() {
        return ui;
    }
    public static void setUi(UI ui) {
        CollectionOfAllClasses.ui = ui;
    }
}