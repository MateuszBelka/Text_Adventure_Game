/*
 * It should not be necessary to change any variable from private to public.
 * The GetSet Methods provide this functionality.
 * If you need one of them in your class, you can switch the specific method to public.
 */

public class StaticItem {
    //Variable Declaration
    private PickupableItem needsItem;
    private String textAboutThisItem;
    private String textForPuzzleSolved;
    private String name;

    //Constructor
    public StaticItem(){}
    public StaticItem(PickupableItem needsItem,
                      String textAboutThisItem,
                      String textForPuzzleSolved,
                      String name) {
        this.needsItem = needsItem;
        this.textAboutThisItem = textAboutThisItem;
        this.textForPuzzleSolved = textForPuzzleSolved;
        this.name = name;
    }

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

    //Boolean Methods
    public boolean isActionable(){
        return getNeedsItem() == null;
    }
}
