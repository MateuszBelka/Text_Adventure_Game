public class StaticItem {
    //Variable Declaration
    private PickupableItem needsItem;
    private String textAboutThisItem;
    private String textForPuzzleSolved;
    private String name;

    //Constructor
    public StaticItem(PickupableItem needsItem, String textAboutThisItem, String textForPuzzleSolved, String name) {
        this.needsItem = needsItem;
        this.textAboutThisItem = textAboutThisItem;
        this.textForPuzzleSolved = textForPuzzleSolved;
        this.name = name;
    }

    //Get Methods
    private PickupableItem getNeedsItem() {
        return needsItem;
    }
    private String getTextAboutThisItem() {
        return textAboutThisItem;
    }
    private String getTextForPuzzleSolved() {
        return textForPuzzleSolved;
    }
    private String getName() {
        return name;
    }

    //Set Methods
    private void setNeedsItem(PickupableItem needsItem) {
        this.needsItem = needsItem;
    }
    private void setTextAboutThisItem(String textAboutThisItem) {
        this.textAboutThisItem = textAboutThisItem;
    }
    private void setTextForPuzzleSolved(String textForPuzzleSolved) {
        this.textForPuzzleSolved = textForPuzzleSolved;
    }
    private void setName(String name) {
        this.name = name;
    }
}
