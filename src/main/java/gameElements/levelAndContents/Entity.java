package gameElements.levelAndContents;

import java.util.HashMap;

abstract public class Entity {
    String name;
    String description;
    String descriptionAfterPuzzleComplete;
    String textForReading;
    String textForTalking;
    String textForExamining;
    String textForSmelling;
    String textForBreaking;
    String textForListening;
    HashMap<String, String> descriptionAfterCommand = new HashMap<>();
    Boolean canBeConsumed = false;
    Boolean canBePickedUp = false;
    Boolean canBeDropped = false;
    Boolean canBeInteractedWith = false;
    Boolean canBeUsedOnItem = false;
    Item itemToBeUsedOn;
    Boolean canBeUsedByItem = false;
    Item itemToBeUsedBy;
    Boolean canBeRead = false;
    Boolean canBeAttacked = false;
    Boolean canAttack = false;
    Boolean canBeTalkedWith = false;
    Boolean canBeListenedTo = false;
    Boolean canBeSmelled = false;
    Boolean canBeOpened = false;
    Boolean canBeClosed = false;
    Boolean canBeExamined = false;
    Boolean canBeBrokenWithItem = false;
    Boolean canBeBrokenWithoutItem = false;
    Boolean canBeTurnedOn = false;
    Boolean canBeTurnedOff = false;
    Boolean canBeGiven = false;
    Boolean needsItem = false;
    Boolean canBeUsedOnNPC = false;
    Boolean canBePushed = false;
    Boolean canBePulled = false;
    Boolean canBeCutWith = false;
    Item itemToCutWith;
    Boolean canBeCut = false;
    Boolean canBeUsed = false;
    Boolean firstTimeEnteringLocation = true;
    Boolean canBeListenedWith = false;
    Boolean canBreak = false;
    Boolean canBeUnlockedByItem = false;
    Item itemToGive;
    NPC npcToGiveItemTo;
    Item itemToListenWith;
    NPC npcToListenWithItemTo;
    Item itemToBreakWith;
    Item itemToUnlockWith;
    Item itemToUnlock;
    Item itemToOpenWith;
    Item itemToBeOpened;
    Item itemToCloseWith;
    Item itemToBeClosed;






    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLocation.equals(true)){
            firstTimeEnteringLocation = false;
            return true;
        }
        return firstTimeEnteringLocation;
    }

    public void puzzleCompleted (){
        description = descriptionAfterPuzzleComplete;

    }

    public String getTextForListening() {
        return textForListening;
    }

    public void setDescriptionAfterCommand(HashMap<String, String> descriptionAfterCommand) {
        this.descriptionAfterCommand = descriptionAfterCommand;
    }

    public void setOneDescriptionAfterCommand(String command, String description){
        descriptionAfterCommand.put(command, description);
    }

    public String getTextForExamining() {
        return textForExamining;
    }

    public Boolean getCanBeUnlockedByItem() {
        return canBeUnlockedByItem;
    }

    public String getTextForBreaking() {
        return textForBreaking;
    }

    public Item getItemToBeClosed() {
        return itemToBeClosed;
    }

    public Item getItemToBeOpened() {
        return itemToBeOpened;
    }

    public Item getItemToCloseWith() {
        return itemToCloseWith;
    }

    public Item getItemToOpenWith() {
        return itemToOpenWith;
    }

    public Boolean getCanBeCut() {
        return canBeCut;
    }

    public Item getItemToUnlock() {
        return itemToUnlock;
    }

    public Item getItemToUnlockWith() {
        return itemToUnlockWith;
    }

    public Item getItemToBreakWith() {
        return itemToBreakWith;
    }

    public Boolean getCanBreak() {
        return canBreak;
    }

    public Boolean getCanBeListenedWith() {
        return canBeListenedWith;
    }

    public Item getItemToListenWith() {
        return itemToListenWith;
    }

    public NPC getNpcToGiveItemTo() {
        return npcToGiveItemTo;
    }

    public NPC getNpcToListenWithItemTo() {
        return npcToListenWithItemTo;
    }

    public Boolean getNeedsItem() {
        return needsItem;
    }

    public Item getItemToGive() {
        return itemToGive;
    }

    public NPC getNpcTiGiveItemTo() {
        return npcToGiveItemTo;
    }

    public Boolean getCanBeCutWith() {
        return canBeCutWith;
    }

    public String getTextForSmelling() {
        return textForSmelling;
    }

    public Boolean getCanBePushed() {
        return canBePushed;
    }

    public Boolean getCanBePulled() {
        return canBePulled;
    }

    public String getTextForReading() {
        return textForReading;
    }

    public String getTextForTalking() {
        return textForTalking;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Boolean getCanBeGiven() {
        return canBeGiven;
    }

    public Boolean getCanBeUsedOnNPC() {
        return canBeUsedOnNPC;
    }

    public Boolean getCanBeDropped() {
        return canBeDropped;
    }

    public Boolean getCanBeSmelled() {
        return canBeSmelled;
    }

    public Boolean getCanBeRead() {
        return canBeRead;
    }

    public Boolean getCanBePickedUp() {
        return canBePickedUp;
    }

    public Boolean getCanBeListenedTo() {
        return canBeListenedTo;
    }

    public Boolean getCanBeOpened() {
        return canBeOpened;
    }

    public Boolean getCanBeInteractedWith() {
        return canBeInteractedWith;
    }

    public Boolean getCanBeConsumed() {
        return canBeConsumed;
    }

    public Boolean getCanBeAttacked() {
        return canBeAttacked;
    }

    public Boolean getCanAttack() {
        return canAttack;
    }

    public Boolean getCanBeTalkedWith() {
        return canBeTalkedWith;
    }

    public Boolean getCanBeUsedByItem() {
        return canBeUsedByItem;
    }

    public Boolean getCanBeUsedOnItem() {
        return canBeUsedOnItem;
    }

    public Item getItemToBeUsedBy() {
        return itemToBeUsedBy;
    }

    public Item getItemToBeUsedOn() {
        return itemToBeUsedOn;
    }

    public Boolean getCanBeClosed() {
        return canBeClosed;
    }

    public Boolean getCanBeExamined() {
        return canBeExamined;
    }

    public Boolean getCanBeBrokenWithItem() {
        return canBeBrokenWithItem;
    }

    public Boolean getCanBeTurnedOff() {
        return canBeTurnedOff;
    }

    public Boolean getCanBeTurnedOn() {
        return canBeTurnedOn;
    }

    public Boolean getCanBeBrokenWithoutItem() {
        return canBeBrokenWithoutItem;
    }

    public Item getItemToCutWith() {
        return itemToCutWith;
    }

    public String getDescriptionAfterPuzzleComplete() {
        return descriptionAfterPuzzleComplete;
    }

    public Boolean getCanBeUsed() {
        return canBeUsed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemToBeClosed(Item itemToBeClosed) {
        this.itemToBeClosed = itemToBeClosed;
    }

    public void setItemToCloseWith(Item itemToCloseWith) {
        this.itemToCloseWith = itemToCloseWith;
    }

    public void setItemToBeOpened(Item itemToBeOpened) {
        this.itemToBeOpened = itemToBeOpened;
    }

    public void setItemToOpenWith(Item itemToOpenWith) {
        this.itemToOpenWith = itemToOpenWith;
    }

    public void setCanBreak(Boolean canBreak) {
        this.canBreak = canBreak;
    }

    public void setItemToBreakWith(Item itemToBreakWith) {
        this.itemToBreakWith = itemToBreakWith;
    }

    public void setItemToUnlock(Item itemToUnlock) {
        this.itemToUnlock = itemToUnlock;
    }

    public void setItemToUnlockWith(Item itemToUnlockWith) {
        this.itemToUnlockWith = itemToUnlockWith;
    }

    public void setCanBeDropped(Boolean canBeDropped) {
        this.canBeDropped = canBeDropped;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCanBeRead(Boolean canBeRead) {
        this.canBeRead = canBeRead;
    }

    public void setCanBePickedUp(Boolean canBePickedUp) {
        this.canBePickedUp = canBePickedUp;
    }

    public void setTextForListening(String textForListening) {
        this.textForListening = textForListening;
    }

    public void setCanBeInteractedWith(Boolean canBeInteractedWith) {
        this.canBeInteractedWith = canBeInteractedWith;
    }

    public void setCanBeConsumed(Boolean canBeConsumed) {
        this.canBeConsumed = canBeConsumed;
    }

    public void setCanBeSmelled(Boolean canBeSmelled) {
        this.canBeSmelled = canBeSmelled;
    }

    public void setCanBeListenedTo(Boolean canBeListenedTo) {
        this.canBeListenedTo = canBeListenedTo;
    }

    public void setTextForExamining(String textForExamining) {
        this.textForExamining = textForExamining;
    }

    public void setTextForBreaking(String textForBreaking) {
        this.textForBreaking = textForBreaking;
    }

    public void setCanBeAttacked(Boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

    public void setCanBeOpened(Boolean canBeOpened) {
        this.canBeOpened = canBeOpened;
    }

    public void setCanAttack(Boolean canAttack) {
        this.canAttack = canAttack;
    }

    public void setCanBeUsedByItem(Boolean canBeUsedByItem) {
        this.canBeUsedByItem = canBeUsedByItem;
    }

    public void setCanBeClosed(Boolean canBeClosed) {
        this.canBeClosed = canBeClosed;
    }

    public void setCanBeTalkedWith(Boolean canBeTalkedWith) {
        this.canBeTalkedWith = canBeTalkedWith;
    }

    public void setCanBeExamined(Boolean canBeExamined) {
        this.canBeExamined = canBeExamined;
    }

    public void setCanBeUsedOnItem(Boolean canBeUsedOnItem) {
        this.canBeUsedOnItem = canBeUsedOnItem;
    }

    public void setCanBeBrokenWithItem(Boolean canBeBrokenWithItem) {
        this.canBeBrokenWithItem = canBeBrokenWithItem;
    }

    public void setDescriptionAfterPuzzleComplete(String descriptionAfterPuzzleComplete) {
        this.descriptionAfterPuzzleComplete = descriptionAfterPuzzleComplete;
    }

    public void setCanBeUnlockedByItem(Boolean canBeUnlockedByItem) {
        this.canBeUnlockedByItem = canBeUnlockedByItem;
    }

    public void setItemToBeUsedBy(Item itemToBeUsedBy) {
        this.itemToBeUsedBy = itemToBeUsedBy;
    }

    public void setItemToBeUsedOn(Item itemToBeUsedOn) {
        this.itemToBeUsedOn = itemToBeUsedOn;
    }

    public void setCanBeTurnedOn(Boolean canBeTurnedOn) {
        this.canBeTurnedOn = canBeTurnedOn;
    }

    public void setCanBeBrokenWithoutItem(Boolean canBeBrokenWithoutItem) {
        this.canBeBrokenWithoutItem = canBeBrokenWithoutItem;
    }

    public void setTextForSmelling(String textForSmelling) {
        this.textForSmelling = textForSmelling;
    }

    public void setCanBeTurnedOff(Boolean canBeTurnedOff) {
        this.canBeTurnedOff = canBeTurnedOff;
    }

    public void setTextForReading(String textForReading) {
        this.textForReading = textForReading;
    }

    public void setTextForTalking(String textForTalking) {
        this.textForTalking = textForTalking;
    }

    public void setCanBeGiven(Boolean canBeGiven) {
        this.canBeGiven = canBeGiven;
    }

    public void setCanBeUsedOnNPC(Boolean canBeUsedOnNPC) {
        this.canBeUsedOnNPC = canBeUsedOnNPC;
    }

    public void setCanBePushed(Boolean canBePushed) {
        this.canBePushed = canBePushed;
    }

    public void setCanBePulled(Boolean canBePulled) {
        this.canBePulled = canBePulled;
    }

    public void setCanBeCutWith(Boolean canBeCutWith) {
        this.canBeCutWith = canBeCutWith;
    }

    public void setCanBeUsed(Boolean canBeUsed) {
        this.canBeUsed = canBeUsed;
    }

    public void setItemToCutWith(Item itemToCutWith) {
        this.itemToCutWith = itemToCutWith;
    }

    public void setCanBeCut(Boolean canBeCut) {
        this.canBeCut = canBeCut;
    }

    public void setItemToGive(Item itemToGive) {
        this.itemToGive = itemToGive;
    }

    public void setNeedsItem(Boolean needsItem) {
        this.needsItem = needsItem;
    }

    public void setNpcToGiveItemTo(NPC npcToGiveItemTo) {
        this.npcToGiveItemTo = npcToGiveItemTo;
    }

    public void setCanBeListenedWith(Boolean canBeListenedWith) {
        this.canBeListenedWith = canBeListenedWith;
    }

    public void setNpcToListenWithItemTo(NPC npcToListenWithItemTo) {
        this.npcToListenWithItemTo = npcToListenWithItemTo;
    }

    public void setItemToListenWith(Item itemToListenWith) {
        this.itemToListenWith = itemToListenWith;
    }
}
