package input.commands;

import initialisation.CollectionOfAllClasses;

public class DoBack {
    public static void doBack(){
        CollectionOfAllClasses.getPlayer().setCurrentLocationToPreviousLocation();
    }
}