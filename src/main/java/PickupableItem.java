
public class PickupableItem {

    private String name;
    private StaticItem staticItemToUseOn;
    private String textAboutThisItem;

    //Constructors
    public PickupableItem(){}

    //Get Methods
    public String getName() { return name; }
    public StaticItem getStaticItemToUseOn() { return staticItemToUseOn; }
    public String getTextAboutThisItem() { return textAboutThisItem; }

    //Set Methods
    public void setName(String name){ this.name = name; }
    public void setStaticItemToUseOn(StaticItem staticItemToUseOn) {
        this.staticItemToUseOn = staticItemToUseOn;
    }
    public void setTextAboutThisItem(String textAboutThisItem) {
        this.textAboutThisItem = textAboutThisItem;
    }
}