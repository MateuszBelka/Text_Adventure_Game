package gameElements.levelAndContents;

import gameElements.levelAndContents.npc.NPC;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class Item extends Entity {
    private Boolean canBeBrokenWithItem = false;
    private Boolean canBeBrokenWithoutItem = false;
    private Boolean canBePickedUp = false;
    private Boolean canBeDropped = false;
    private Boolean canBeUnlockedByItem = false;
    private Boolean canBeListenedWith = false;
    private Boolean canBeTurnedOn = false;
    private Boolean canBeTurnedOff = false;
    private Boolean canBeGiven = false;
    private Boolean canBeCutWith = false;
    private Boolean canBeRead = false;
    private Boolean canBreak = false;
    private transient NPC npcToListenWithItemTo;
    private int npcToListenWithItemToID;
    private transient Item itemToBreakWith;
    private int itemToBreakWithID;


    public static Item getItemByName(String name){
        Item searchedItem = null;
        Location currentLocation = InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation();
        ArrayList<Item> listOfItemsInCurrentLoc = currentLocation.getListOfItems();

        for (Item item : listOfItemsInCurrentLoc){
            if (item.getName().toUpperCase().equals(name)){
                searchedItem = item;
            }
        }
        ArrayList<Item> listOfItemsInInventory = InitOfClassesThroughSaveFile.getInventory().getListOfItems();
        for (Item item : listOfItemsInInventory){
            if (item.getName().toUpperCase().equals(name)){
                searchedItem = item;
            }
        }
        return searchedItem;
    }

    public Boolean getCanBeBrokenWithItem() {
        return canBeBrokenWithItem;
    }

    public Boolean getCanBeBrokenWithoutItem() {
        return canBeBrokenWithoutItem;
    }

    public Boolean getCanBePickedUp() {
        return canBePickedUp;
    }

    public Boolean getCanBeDropped() {
        return canBeDropped;
    }

    public Boolean getCanBeUnlockedByItem() {
        return canBeUnlockedByItem;
    }

    public Boolean getCanBeListenedWith() {
        return canBeListenedWith;
    }

    public Boolean getCanBeTurnedOn() {
        return canBeTurnedOn;
    }

    public Boolean getCanBeTurnedOff() {
        return canBeTurnedOff;
    }

    public Boolean getCanBeGiven() {
        return canBeGiven;
    }

    public Boolean getCanBeCutWith() {
        return canBeCutWith;
    }

    public Boolean getCanBeRead() {
        return canBeRead;
    }

    public NPC getNpcToListenWithItemTo() {
        return npcToListenWithItemTo;
    }

    public Boolean getCanBreak() {
        return canBreak;
    }

    public Item getItemToBreakWith() {
        return itemToBreakWith;
    }

    public void setItemToBreakWith(Item itemToBreakWith) {
        this.itemToBreakWith = itemToBreakWith;
    }

    public void setCanBreak(Boolean canBreak) {
        this.canBreak = canBreak;
    }

    public void setNpcToListenWithItemTo(NPC npcToListenWithItemTo) {
        this.npcToListenWithItemTo = npcToListenWithItemTo;
    }

    public void setCanBeRead(Boolean canBeRead) {
        this.canBeRead = canBeRead;
    }

    public void setCanBeCutWith(Boolean canBeCutWith) {
        this.canBeCutWith = canBeCutWith;
    }

    public void setCanBeGiven(Boolean canBeGiven) {
        this.canBeGiven = canBeGiven;
    }

    public void setCanBeTurnedOn(Boolean canBeTurnedOn) {
        this.canBeTurnedOn = canBeTurnedOn;
    }

    public void setCanBeTurnedOff(Boolean canBeTurnedOff) {
        this.canBeTurnedOff = canBeTurnedOff;
    }

    public void setCanBeListenedWith(Boolean canBeListenedWith) {
        this.canBeListenedWith = canBeListenedWith;
    }

    public void setCanBeUnlockedByItem(Boolean canBeUnlockedByItem) {
        this.canBeUnlockedByItem = canBeUnlockedByItem;
    }

    public void setCanBeBrokenWithItem(Boolean canBeBrokenWithItem) { this.canBeBrokenWithItem = canBeBrokenWithItem; }

    public void setCanBeBrokenWithoutItem(Boolean canBeBrokenWithoutItem) {
        this.canBeBrokenWithoutItem = canBeBrokenWithoutItem;
    }

    public void setCanBePickedUp(Boolean canBePickedUp) { this.canBePickedUp = canBePickedUp; }

    public void setCanBeDropped(Boolean canBeDropped) { this.canBeDropped = canBeDropped; }

    public int getNpcToListenWithItemToID() {
        return npcToListenWithItemToID;
    }

    public void setNpcToListenWithItemToID(int npcToListenWithItemToID) {
        this.npcToListenWithItemToID = npcToListenWithItemToID;
    }

    public int getItemToBreakWithID() {
        return itemToBreakWithID;
    }

    public void setItemToBreakWithID(int itemToBreakWithID) {
        this.itemToBreakWithID = itemToBreakWithID;
    }
}
