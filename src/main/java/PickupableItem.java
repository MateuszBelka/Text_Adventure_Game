public class PickupableItem {

    private String name;
    private StaticItem staticItemToUseOn;
    private String textAboutThisItem;
    private String location;

    void setName(String newName){ name = newName; }
    String getName(){ return name; }

    PickupableItem(String name,
                   String location,
                   StaticItem staticItemToUseOn,
                   String textAboutThisItem) {
        this.name = name;
        this.location = location;
        this.staticItemToUseOn = staticItemToUseOn;
        this.textAboutThisItem = textAboutThisItem;
    }
    public void nullifyLocation() { location = null; }
    public String getTextAboutThisItem() { return textAboutThisItem; }
}

