package gameElements.levelAndContents;

import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class Item extends Entity {
    Boolean canBeBrokenWithItem = false;
    Boolean canBeBrokenWithoutItem = false;
    Boolean canBePickedUp = false;
    Boolean canBeDropped = false;
    Boolean canBeUnlockedByItem = false;
    Boolean canBeListenedWith = false;
    Boolean canBeTurnedOn = false;
    Boolean canBeTurnedOff = false;
    Boolean canBeGiven = false;
    Boolean canBeCutWith = false;
    Boolean canBeRead = false;
    Boolean canBreak = false;
    NPC npcToListenWithItemTo;
    Item itemToBreakWith;


    public static Item getItemByName(String name){
        Item searchedItem = null;
        ArrayList<Item> listOfItemsInCurrentLoc = InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems();
        for (Item item : listOfItemsInCurrentLoc){
            if (item.getName().equals(name)){
                searchedItem = item;
            }
        }
        ArrayList<Item> listOfItemsInInventory = InitOfClassesThroughSaveFile.getInventory().getItemsInInventory();
        for (Item item : listOfItemsInInventory){
            if (item.getName().equals(name)){
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

    public void setCanBeBrokenWithItem(Boolean canBeBrokenWithItem) {
        this.canBeBrokenWithItem = canBeBrokenWithItem;
    }

    public void setCanBeBrokenWithoutItem(Boolean canBeBrokenWithoutItem) {
        this.canBeBrokenWithoutItem = canBeBrokenWithoutItem;
    }

    public void setCanBePickedUp(Boolean canBePickedUp) {
        this.canBePickedUp = canBePickedUp;
    }

    public void setCanBeDropped(Boolean canBeDropped) {
        this.canBeDropped = canBeDropped;
    }
}
