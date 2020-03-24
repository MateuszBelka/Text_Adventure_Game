package input.commands;

import gameElements.levelAndContents.Location;
import initialisation.CollectionOfAllClasses;

public class DoMove {
    public static void doMove (Location location){
        CollectionOfAllClasses.getPlayer().addLocationToMovedLocationsList(location);
        CollectionOfAllClasses.getPlayer().setCurrentLocation(location);
    }
}
