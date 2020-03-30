package gameElements.levelAndContents;

import gameElements.levelAndContents.npc.NPC;

import java.util.HashMap;

abstract public class Entity {
    private int id;
    private String name;
    private String description;
    private String descriptionAfterPuzzleComplete;
    private HashMap<String, String> descriptionAfterCommand = new HashMap<>();
    private Boolean firstTimeEnteringLocation = true; //Used for printing descriptions, once. Just like in Zork.
    private Boolean canBeConsumed = false;
    private Boolean canBeUsedOnItem = false;
    private transient Item itemToBeUsedOn;
    private int itemToBeUsedOnID;
    private Boolean canBeUsedByItem = false;
    private transient Item itemToBeUsedBy;
    private int itemToBeUsedByID;
    private Boolean canBeAttacked = false;
    private Boolean canBeTalkedWith = false;
    private Boolean canBeListenedTo = false;
    private Boolean canBeSmelled = false;
    private Boolean canBeOpened = false;
    private Boolean canBeClosed = false;
    private Boolean canBeExamined = false;
    private Boolean needsItem = false;
    private Boolean canBeUsedOnNPC = false;
    private Boolean canBePushed = false;
    private Boolean canBePulled = false;
    private transient Item itemToCutWith;
    private int itemToCutWithID;
    private Boolean canBeCut = false;
    private Boolean canBeUsed = false;
    private transient NPC npcToGiveItemTo;
    private int npcToGiveItemToID;
    private transient Item itemToListenWith;
    private int itemToListenWithID;
    private transient Item itemToUnlockWith;
    private int itemToUnlockWithID;
    private transient Item itemToUnlock;
    private int itemToUnlockID;
    private transient Item itemToOpenWith;
    private int itemToOpenWithID;
    private transient Item itemToBeOpened;
    private int itemToBeOpenedID;
    private transient Item itemToCloseWith;
    private int itemToCloseWithID;

    //Getter + Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAfterPuzzleComplete() {
        return descriptionAfterPuzzleComplete;
    }

    public void setDescriptionAfterPuzzleComplete(String descriptionAfterPuzzleComplete) {
        this.descriptionAfterPuzzleComplete = descriptionAfterPuzzleComplete;
    }

    public String getDescriptionOfCommand(String command){
        return descriptionAfterCommand.get(command);
    }

    public HashMap<String, String> getDescriptionAfterCommand() {
        return descriptionAfterCommand;
    }

    public void setDescriptionAfterCommand(HashMap<String, String> descriptionAfterCommand) {
        this.descriptionAfterCommand = descriptionAfterCommand;
    }

    public Boolean getCanBeConsumed() {
        return canBeConsumed;
    }

    public void setCanBeConsumed(Boolean canBeConsumed) {
        this.canBeConsumed = canBeConsumed;
    }

    public Boolean getCanBeUsedOnItem() {
        return canBeUsedOnItem;
    }

    public void setCanBeUsedOnItem(Boolean canBeUsedOnItem) {
        this.canBeUsedOnItem = canBeUsedOnItem;
    }

    public Item getItemToBeUsedOn() {
        return itemToBeUsedOn;
    }

    public void setItemToBeUsedOn(Item itemToBeUsedOn) {
        this.itemToBeUsedOn = itemToBeUsedOn;
    }

    public Boolean getCanBeUsedByItem() {
        return canBeUsedByItem;
    }

    public void setCanBeUsedByItem(Boolean canBeUsedByItem) {
        this.canBeUsedByItem = canBeUsedByItem;
    }

    public Item getItemToBeUsedBy() {
        return itemToBeUsedBy;
    }

    public void setItemToBeUsedBy(Item itemToBeUsedBy) {
        this.itemToBeUsedBy = itemToBeUsedBy;
    }

    public Boolean getCanBeAttacked() {
        return canBeAttacked;
    }

    public void setCanBeAttacked(Boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

    public Boolean getCanBeTalkedWith() {
        return canBeTalkedWith;
    }

    public void setCanBeTalkedWith(Boolean canBeTalkedWith) {
        this.canBeTalkedWith = canBeTalkedWith;
    }

    public Boolean getCanBeListenedTo() {
        return canBeListenedTo;
    }

    public void setCanBeListenedTo(Boolean canBeListenedTo) {
        this.canBeListenedTo = canBeListenedTo;
    }

    public Boolean getCanBeSmelled() {
        return canBeSmelled;
    }

    public void setCanBeSmelled(Boolean canBeSmelled) {
        this.canBeSmelled = canBeSmelled;
    }

    public Boolean getCanBeOpened() {
        return canBeOpened;
    }

    public void setCanBeOpened(Boolean canBeOpened) {
        this.canBeOpened = canBeOpened;
    }

    public Boolean getCanBeClosed() {
        return canBeClosed;
    }

    public void setCanBeClosed(Boolean canBeClosed) {
        this.canBeClosed = canBeClosed;
    }

    public Boolean getCanBeExamined() {
        return canBeExamined;
    }

    public void setCanBeExamined(Boolean canBeExamined) {
        this.canBeExamined = canBeExamined;
    }

    public Boolean getNeedsItem() {
        return needsItem;
    }

    public void setNeedsItem(Boolean needsItem) {
        this.needsItem = needsItem;
    }

    public Boolean getCanBeUsedOnNPC() {
        return canBeUsedOnNPC;
    }

    public void setCanBeUsedOnNPC(Boolean canBeUsedOnNPC) {
        this.canBeUsedOnNPC = canBeUsedOnNPC;
    }

    public Boolean getCanBePushed() {
        return canBePushed;
    }

    public void setCanBePushed(Boolean canBePushed) {
        this.canBePushed = canBePushed;
    }

    public Boolean getCanBePulled() {
        return canBePulled;
    }

    public void setCanBePulled(Boolean canBePulled) {
        this.canBePulled = canBePulled;
    }

    public Item getItemToCutWith() {
        return itemToCutWith;
    }

    public void setItemToCutWith(Item itemToCutWith) {
        this.itemToCutWith = itemToCutWith;
    }

    public Boolean getCanBeCut() {
        return canBeCut;
    }

    public void setCanBeCut(Boolean canBeCut) {
        this.canBeCut = canBeCut;
    }

    public Boolean getCanBeUsed() {
        return canBeUsed;
    }

    public void setCanBeUsed(Boolean canBeUsed) {
        this.canBeUsed = canBeUsed;
    }

    public Boolean getFirstTimeEnteringLocation() {
        return firstTimeEnteringLocation;
    }

    public void setFirstTimeEnteringLocation(Boolean firstTimeEnteringLocation) {
        this.firstTimeEnteringLocation = firstTimeEnteringLocation;
    }

    public NPC getNpcToGiveItemTo() {
        return npcToGiveItemTo;
    }

    public void setNpcToGiveItemTo(NPC npcToGiveItemTo) {
        this.npcToGiveItemTo = npcToGiveItemTo;
    }

    public Item getItemToListenWith() {
        return itemToListenWith;
    }

    public void setItemToListenWith(Item itemToListenWith) {
        this.itemToListenWith = itemToListenWith;
    }

    public Item getItemToUnlockWith() {
        return itemToUnlockWith;
    }

    public void setItemToUnlockWith(Item itemToUnlockWith) {
        this.itemToUnlockWith = itemToUnlockWith;
    }

    public Item getItemToUnlock() {
        return itemToUnlock;
    }

    public void setItemToUnlock(Item itemToUnlock) {
        this.itemToUnlock = itemToUnlock;
    }

    public Item getItemToOpenWith() {
        return itemToOpenWith;
    }

    public void setItemToOpenWith(Item itemToOpenWith) {
        this.itemToOpenWith = itemToOpenWith;
    }

    public Item getItemToBeOpened() {
        return itemToBeOpened;
    }

    public void setItemToBeOpened(Item itemToBeOpened) {
        this.itemToBeOpened = itemToBeOpened;
    }

    public Item getItemToCloseWith() {
        return itemToCloseWith;
    }

    public void setItemToCloseWith(Item itemToCloseWith) {
        this.itemToCloseWith = itemToCloseWith;
    }

    public int getItemToBeUsedOnID() {
        return itemToBeUsedOnID;
    }

    public void setItemToBeUsedOnID(int itemToBeUsedOnID) {
        this.itemToBeUsedOnID = itemToBeUsedOnID;
    }

    public int getItemToBeUsedByID() {
        return itemToBeUsedByID;
    }

    public void setItemToBeUsedByID(int itemToBeUsedByID) {
        this.itemToBeUsedByID = itemToBeUsedByID;
    }

    public int getItemToCutWithID() {
        return itemToCutWithID;
    }

    public void setItemToCutWithID(int itemToCutWithID) {
        this.itemToCutWithID = itemToCutWithID;
    }

    public int getNpcToGiveItemToID() {
        return npcToGiveItemToID;
    }

    public void setNpcToGiveItemToID(int npcToGiveItemToID) {
        this.npcToGiveItemToID = npcToGiveItemToID;
    }

    public int getItemToListenWithID() {
        return itemToListenWithID;
    }

    public void setItemToListenWithID(int itemToListenWithID) {
        this.itemToListenWithID = itemToListenWithID;
    }

    public int getItemToUnlockWithID() {
        return itemToUnlockWithID;
    }

    public void setItemToUnlockWithID(int itemToUnlockWithID) {
        this.itemToUnlockWithID = itemToUnlockWithID;
    }

    public int getItemToUnlockID() {
        return itemToUnlockID;
    }

    public void setItemToUnlockID(int itemToUnlockID) {
        this.itemToUnlockID = itemToUnlockID;
    }

    public int getItemToOpenWithID() {
        return itemToOpenWithID;
    }

    public void setItemToOpenWithID(int itemToOpenWithID) {
        this.itemToOpenWithID = itemToOpenWithID;
    }

    public int getItemToBeOpenedID() {
        return itemToBeOpenedID;
    }

    public void setItemToBeOpenedID(int itemToBeOpenedID) {
        this.itemToBeOpenedID = itemToBeOpenedID;
    }

    public int getItemToCloseWithID() {
        return itemToCloseWithID;
    }

    public void setItemToCloseWithID(int itemToCloseWithID) {
        this.itemToCloseWithID = itemToCloseWithID;
    }
}
