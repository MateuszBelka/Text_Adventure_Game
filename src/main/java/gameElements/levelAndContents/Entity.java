package gameElements.levelAndContents;

import java.util.HashMap;

abstract public class Entity {
    private int id;
    String name;
    String description;
    String descriptionAfterPuzzleComplete;
    HashMap<String, String> descriptionAfterCommand = new HashMap<>();
    String textForReading; //can be put in "descriptionAfterCommand"
    String textForTalking; //can be put in "descriptionAfterCommand"
    String textForExamining; //can be put in "descriptionAfterCommand"
    String textForSmelling; //can be put in "descriptionAfterCommand"
    String textForBreaking; //can be put in "descriptionAfterCommand"
    String textForListening; //can be put in "descriptionAfterCommand"
    Boolean firstTimeEnteringLocation = true; //Used for printing descriptions, once. Just like in Zork.
    Boolean canBeConsumed = false;
    Boolean canBeUsedOnItem = false;
    Item itemToBeUsedOn;
    Boolean canBeUsedByItem = false;
    Item itemToBeUsedBy;
    Boolean canBeAttacked = false;
    Boolean canBeTalkedWith = false;
    Boolean canBeListenedTo = false;
    Boolean canBeSmelled = false;
    Boolean canBeOpened = false;
    Boolean canBeClosed = false;
    Boolean canBeExamined = false;
    Boolean needsItem = false;
    Boolean canBeUsedOnNPC = false;
    Boolean canBePushed = false;
    Boolean canBePulled = false;
    Item itemToCutWith;
    Boolean canBeCut = false;
    Boolean canBeUsed = false;
    NPC npcToGiveItemTo;
    Item itemToListenWith;
    Item itemToUnlockWith;
    Item itemToUnlock;
    Item itemToOpenWith;
    Item itemToBeOpened;
    Item itemToCloseWith;

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

    public String getTextForReading() {
        return textForReading;
    }

    public void setTextForReading(String textForReading) {
        this.textForReading = textForReading;
    }

    public String getTextForTalking() {
        return textForTalking;
    }

    public void setTextForTalking(String textForTalking) {
        this.textForTalking = textForTalking;
    }

    public String getTextForExamining() {
        return textForExamining;
    }

    public void setTextForExamining(String textForExamining) {
        this.textForExamining = textForExamining;
    }

    public String getTextForSmelling() {
        return textForSmelling;
    }

    public void setTextForSmelling(String textForSmelling) {
        this.textForSmelling = textForSmelling;
    }

    public String getTextForBreaking() {
        return textForBreaking;
    }

    public void setTextForBreaking(String textForBreaking) {
        this.textForBreaking = textForBreaking;
    }

    public String getTextForListening() {
        return textForListening;
    }

    public void setTextForListening(String textForListening) {
        this.textForListening = textForListening;
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


    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLocation.equals(true)){
            firstTimeEnteringLocation = false;
            return true;
        }
        return firstTimeEnteringLocation;
    }

    public void changeDescriptionWhenPuzzleCompleted (){
        description = descriptionAfterPuzzleComplete;

    }

}
