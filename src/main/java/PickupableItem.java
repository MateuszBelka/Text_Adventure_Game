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

public class PickupableItem {

    private String name;
    private StaticItem staticItemToUseOn;
    private String textAboutThisItem;
    private String textForItemPickedUp;

    //Get Methods
    //gets name of the pickupableItem
    public String getName() { return name; }
    //gets the name of the staticItem to use on pickupable item
    public StaticItem getStaticItemToUseOn() { return staticItemToUseOn; }
    //returns description about the pickupable item
    public String getTextAboutThisItem() { return textAboutThisItem; }
    //returns some text and description about pickupable item that was just picked up
    public String getTextForItemPickedUp() { return textForItemPickedUp; }

    //Set Methods
    //setting the name of the pickupable item
    public void setName(String name){ this.name = name; }
    //setting the name of static item to use pickupable item on
    public void setStaticItemToUseOn(StaticItem staticItemToUseOn) { this.staticItemToUseOn = staticItemToUseOn; }
    //setting the text and description about pickupable item
    public void setTextAboutThisItem(String textAboutThisItem) { this.textAboutThisItem = textAboutThisItem; }
    //setting next and description about the pickupable item that was just picked up
    public void setTextForItemPickedUp(String textForItemPickedUp) { this.textForItemPickedUp = textForItemPickedUp; }
}