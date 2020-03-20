/*
 * We've decided to change our project structure to utilize
 * packages for Assignment 3.
 *
 * The following file is temporary and will be removed
 * when it's functionality is copied by corresponding new file.
 *
 * Due to this work in progress currently only UI part of our code fully works.
 * That includes initial framework for IO.
 */

public class StaticItem {
    //Variable Declaration
    private PickupableItem needsItem;
    private String textAboutThisItem;
    private String textForPuzzleSolved;
    private String name;

    //Get Methods
    public PickupableItem getNeedsItem() {
        return needsItem;
    }
    public String getTextAboutThisItem() {
        return textAboutThisItem;
    }
    public String getTextForPuzzleSolved() {
        return textForPuzzleSolved;
    }
    public String getName() {
        return name;
    }

    //Set Methods
    public void setNeedsItem(PickupableItem needsItem) {
        this.needsItem = needsItem;
    }
    public void setTextAboutThisItem(String textAboutThisItem) {
        this.textAboutThisItem = textAboutThisItem;
    }
    public void setTextForPuzzleSolved(String textForPuzzleSolved) {
        this.textForPuzzleSolved = textForPuzzleSolved;
    }
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Returns a boolean indicating whether the current StaticItem can be used by player
     * or if it still requires a PickupableItem to be used on it firstly.
     */
    public boolean isActionable(){
        return getNeedsItem() == null;
    }
}
