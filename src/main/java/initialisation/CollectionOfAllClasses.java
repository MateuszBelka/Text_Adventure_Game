package initialisation;

import gameElements.player.*;
import gameElements.levelAndContents.*;
//import input.*;
//import output.*;

import java.util.ArrayList;


public class CollectionOfAllClasses {
    String name; //tester
    private static Player player;
    Inventory inventory;
    ArrayList<Level> levels;
    ArrayList<Location> locations;
    ArrayList<Item> items;
    ArrayList<NPC> npcs;

    public static Player getPlayer() {
        return player;
    }

    public CollectionOfAllClasses(String name){this.name = name;}
}