package initialisation;

import gameElements.player.*;
import gameElements.levelAndContents.*;
import input.commands.CommandHandler;
import input.validation.InputValidation;
import input.validation.WordValidation;
//import input.*;
//import output.*;

import java.util.ArrayList;


public class CollectionOfAllClasses {
    String name; //tester
    private static Player player;
    private static WordValidation wordValidation;
    private static Inventory inventory;
    private static InputValidation inputValidation;
    private static CommandHandler commandHandler;
    ArrayList<Level> levels;
    ArrayList<Location> locations;
    ArrayList<Item> items;
    ArrayList<NPC> npcs;

    public CollectionOfAllClasses(String name){this.name = name;}

    public static Player getPlayer() {
        return player;
    }

    public static CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public InputValidation getInputValidation() {
        return inputValidation;
    }

    public static WordValidation getWordValidation() {
        return wordValidation;
    }


}