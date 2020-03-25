package input.commands;

import initialisation.InitOfClassesThroughSaveFile;

public class DoBack {
    public static void doBack(){
        InitOfClassesThroughSaveFile.getPlayerStats().setCurrentLocationToPreviousLocation();
    }
}