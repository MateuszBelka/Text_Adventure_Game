package input.commands;

import gameElements.levelAndContents.Location;
import initialisation.InitOfClassesThroughSaveFile;

public class DoMove {
    public static void doMove (Location location){
        InitOfClassesThroughSaveFile.getPlayerStats().addLocationToMovedLocationsList(location);
        InitOfClassesThroughSaveFile.getPlayerStats().setCurrentLocation(location);
    }
}
