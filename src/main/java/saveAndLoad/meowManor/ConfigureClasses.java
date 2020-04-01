package saveAndLoad.meowManor;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class ConfigureClasses {
    public static void configureEverything() {
        //File Dependent
        configureItems();
        configureLevels();
        configureLocations();
        configureFriendlyNPCs();
        configureEnemyNPCs();
        configureInventory();
        configurePlayer();
    }


    public static void configureItems() {
        //static
        Item canOfAnchovies = InitOfClassesThroughSaveFile.getItems().get(0);
        Item fishTank = InitOfClassesThroughSaveFile.getItems().get(1);
        Item bagOfCatTreats = InitOfClassesThroughSaveFile.getItems().get(2);
        Item cart = InitOfClassesThroughSaveFile.getItems().get(3);
        Item door = InitOfClassesThroughSaveFile.getItems().get(4);
        Item milk = InitOfClassesThroughSaveFile.getItems().get(11);

        //pickupable
        Item rock = InitOfClassesThroughSaveFile.getItems().get(5);
        Item fishShapedKey = InitOfClassesThroughSaveFile.getItems().get(6);
        Item salmon = InitOfClassesThroughSaveFile.getItems().get(7);
        Item canOfTuna = InitOfClassesThroughSaveFile.getItems().get(8);

        //Starting inv items
        Item redBull = InitOfClassesThroughSaveFile.getItems().get(9);
        Item kitKat = InitOfClassesThroughSaveFile.getItems().get(10);


        // canOfAnchovies
        canOfAnchovies.setName("Anchovies");
        canOfAnchovies.setDescription("Gross, canned anchovies? " +
                "Well, food is food. It doesn't have a tab to be pulled, " +
                "so it must be opened another way.");
        canOfAnchovies.setCanBeBrokenWithoutItem(true);
        canOfAnchovies.setCanBreak(true);
        canOfAnchovies.getDescriptionAfterCommand().put("break","With brute human force, " +
                "you were able to open the can. Thankfully, no cat saw you do it.");
        canOfAnchovies.setCanBeConsumed(true);
        canOfAnchovies.getDescriptionAfterCommand().put("consume","Eating anchovies " +
                "face-first from a can is not what you expected to do on a Tuesday afternoon, " +
                "but at least you found something to eat.");
        canOfAnchovies.setCanBeSmelled(true);
        canOfAnchovies.getDescriptionAfterCommand().put("smell","Anchovies, those scary slivers " +
                "of canned fish, have a taste so pungent, so intensely fishy and salty that when " +
                "served improperly, they can make the heartiest eater recoil from their punch.");


        // fishTank
        fishTank.setName("Fish_Tank");
        fishTank.setDescription("The fish tank is huge, " +
                "and it looks like the owner put jewels " +
                "at the bottom rather than rocks…");
        fishTank.setCanBeBrokenWithItem(true);
        fishTank.setItemToBreakWith(rock);
        fishTank.getDescriptionAfterCommand().put("break","Water is going everywhere, but " +
                "thankfully no cats are in the room to complain about it. You better leave " +
                "the jewels there, but now you can get the salmon that was inside.");
        fishTank.getItemsToDropOnBreak().add(salmon);

        // bagOfCatTreats
        bagOfCatTreats.setName("Cat_Treats");
        bagOfCatTreats.setDescription("A large bag of high-quality cat treats.");
        bagOfCatTreats.setCanBeOpened(true);
        bagOfCatTreats.getDescriptionAfterCommand().put("open","The cat treats are in all " +
                "kinds of funny shapes. Well, it is better than eating a can of anchovies.");
        bagOfCatTreats.setCanBeConsumed(true);
        bagOfCatTreats.getDescriptionAfterCommand().put("consume","They are surprisingly " +
                "tasty, and you are no longer as hungry.");

        // cart
        cart.setName("Cart");
        cart.setDescription("The cart is full of all kinds of dried catnip.");
        cart.setCanBePushed(true);
        cart.getDescriptionAfterCommand().put("push","How could a cat possibly move this heavy thing?");
        cart.getDescriptionAfterCommand().put("pull","How could a cat possibly move this heavy thing?");

        // door
        door.setName("Door");
        door.setDescription("The golden-colored print on this door's sign is really small...");
        door.setCanBeRead(true);
        door.getDescriptionAfterCommand().put("read","Definitely NOT Patches' Meowster Bedroom.");
        door.setCanBeUnlockedByItem(true);
        door.setItemToUnlockWith(fishShapedKey);
        door.getDescriptionAfterCommand().put("unlock","You opened the door to Meowster Bedroom");

        // rock
        rock.setName("Rock");
        rock.setDescription("Even a garden rock at Meow Manor is somehow glamorous.");
        rock.setCanBePickedUp(true);
        rock.getDescriptionAfterCommand().put("pickup","You picked up a rock. It might come in handy later");
        rock.setCanBreak(true);

        // fishShapedKey
        fishShapedKey.setName("Fish-Shaped_Key");
        fishShapedKey.setDescription("A fish-shaped, gold and diamond-encrusted key.");
        fishShapedKey.setCanBePickedUp(true);
        fishShapedKey.getDescriptionAfterCommand().put("pickup","This key is really heavy... " +
                "and can cats even open doors with their paws? Anyways, it must be important.");
        fishShapedKey.setItemToUnlock(door);
        fishShapedKey.getDescriptionAfterCommand().put("unlock","It worked! The door is open!");

        // salmon
        salmon.setName("Salmon");
        salmon.setDescription("I've heard Patches loooves salmon. ;)");
        salmon.setCanBePickedUp(true);
        salmon.getDescriptionAfterCommand().put("pickup","You picked up salmon. Someone might want it later...");
        salmon.setCanBeGiven(true);
        NPC patchesFriendly = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(2);
        salmon.setNpcToGiveItemTo(patchesFriendly);
        canOfTuna.getDescriptionAfterCommand().put("give","Patches is very happy with his afternoon snack.");

        // canOfTuna
        canOfTuna.setName("Tuna");
        canOfTuna.setDescription("A feline-favorite. It appears to be of high-quality.");
        canOfTuna.setCanBePickedUp(true);
        canOfTuna.getDescriptionAfterCommand().put("pickup","You picked up a can of tuna many cats would kill over.");
        canOfTuna.setCanBeGiven(true);
        NPC christofur = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(1);
        canOfTuna.setNpcToGiveItemTo(christofur);
        canOfTuna.getDescriptionAfterCommand().put("give","You gave a can of tuna to Christofur.");

        // redBull
        redBull.setName("RedBull");
        redBull.setDescription("Refreshing dose of pure sugar.");
        redBull.setCanBeDropped(true);
        redBull.setCanBeConsumed(true);
        redBull.getDescriptionAfterCommand().put("consume","Ahh. Totally refreshing. I won't at all regret " +
                "drinking this later. However, I do feel less hungry from all that sugar.");

        // kitKat
        kitKat.setName("KitKat");
        kitKat.setDescription("Ultimate weapon against cats or a tasty snack.");
        kitKat.setCanBeDropped(true);
        kitKat.setCanBeConsumed(true);
        kitKat.getDescriptionAfterCommand().put("consume","You couldn't eat it by ripping the bars apart, " +
                "so you had to eat it by taking bites from the whole thing like a savage. But you feel " +
                "less hungry and eating something besides cat food was nice.");

        // milk
        milk.setName("Milk");
        milk.setDescription("A very ordinary bowl of fresh milk.");
        milk.setCanBeSmelled(true);
        milk.getDescriptionAfterCommand().put("smell","Didn't know it was possible, " +
                "but the bowl of milk smells delicious.");
    }

    public static void configureLevels() {
        Level level1 = InitOfClassesThroughSaveFile.getLevels().get(0);
        Level level2 = InitOfClassesThroughSaveFile.getLevels().get(1);
        Level level3 = InitOfClassesThroughSaveFile.getLevels().get(2);

        //level1
        Location foyer = InitOfClassesThroughSaveFile.getLocations().get(0);
        Location garden = InitOfClassesThroughSaveFile.getLocations().get(1);
        Location theStudy = InitOfClassesThroughSaveFile.getLocations().get(2);
        level1.setName("Ground Floor");
        level1.setStartLocation(foyer);
        level1.setDescription("The ground floor of Meow Manor. You get goosebumps by just looking around.");
        ArrayList<Location> listOfLocationForLevel1 = new ArrayList<>();
        listOfLocationForLevel1.add(foyer);
        listOfLocationForLevel1.add(garden);
        listOfLocationForLevel1.add(theStudy);
        level1.setListOfLocations(listOfLocationForLevel1);
        level1.setNextLevel(level2);
        level1.setTotalPuzzleCount(1000);//fixme

        //level2
        Location livingRoom = InitOfClassesThroughSaveFile.getLocations().get(3);
        level2.setName("Second Floor");
        level2.setStartLocation(livingRoom);
        level2.setDescription("The second floor of Meow Manor. Seems too quiet...");
        ArrayList<Location> listOfLocationForLevel2 = new ArrayList<>();
        listOfLocationForLevel2.add(livingRoom);
        level2.setListOfLocations(listOfLocationForLevel2);
        level2.setNextLevel(level3);
        level2.setTotalPuzzleCount(1000);//fixme

        //level3
        Location meowsterBedroom = InitOfClassesThroughSaveFile.getLocations().get(4);
        level3.setName("The Attic");
        level3.setStartLocation(meowsterBedroom);
        level3.setDescription("The attic of Meow Manor. The lair of famous Patches.");
        ArrayList<Location> listOfLocationForLevel3 = new ArrayList<>();
        listOfLocationForLevel2.add(meowsterBedroom);
        level2.setListOfLocations(listOfLocationForLevel3);
        level3.setNextLevel(null);
        level3.setTotalPuzzleCount(1000);//fixme
    }

    public static void configureLocations() {
        //level1
        Location foyer = InitOfClassesThroughSaveFile.getLocations().get(0);
        Location garden = InitOfClassesThroughSaveFile.getLocations().get(1);
        Location theStudy = InitOfClassesThroughSaveFile.getLocations().get(2);

        foyer.setName("Foyer");
        foyer.getListOfConnectedLocations().put("east",theStudy);
        foyer.getListOfConnectedLocations().put("west",garden);
        foyer.setDescription("You are in the foyer of Meow Manor establishment.");

        theStudy.setName("The Study");
        theStudy.getListOfConnectedLocations().put("west",foyer);
        theStudy.setDescription("You are in the private office of Meow Manor establishment. " +
                "There are plenty of ripped books all around you. You wonder who could have done that...");

        garden.setName("Garden");
        garden.getListOfConnectedLocations().put("east",foyer);
        garden.setDescription("You are in the beautiful gard of Meow Manor establishment. " +
                "It is blooming with all sorts of flowers");

        //level2
        Location livingRoom = InitOfClassesThroughSaveFile.getLocations().get(3);
        livingRoom.setName("Living Room");
        livingRoom.setDescription("As you enter the living room of the Meow Manor you are " +
                "astonished by the sheer beauty of everything around you.");

        //level3
        Location meowsterBedroom = InitOfClassesThroughSaveFile.getLocations().get(4);
        meowsterBedroom.setName("Meowster Bedroom");
        meowsterBedroom.setDescription("The heart of Meow Manor. The epicenter of danger. " +
                "You enter very carefully as to make sure you are not walking " +
                "into a trap set up by the Patches himself.");


        //Items
        Item canOfAnchovies = InitOfClassesThroughSaveFile.getItems().get(0);
        Item fishTank = InitOfClassesThroughSaveFile.getItems().get(1);
        Item bagOfCatTreats = InitOfClassesThroughSaveFile.getItems().get(2);
        Item cart = InitOfClassesThroughSaveFile.getItems().get(3);
        Item door = InitOfClassesThroughSaveFile.getItems().get(4);
        Item rock = InitOfClassesThroughSaveFile.getItems().get(5);
        Item fishShapedKey = InitOfClassesThroughSaveFile.getItems().get(6);
        Item canOfTuna = InitOfClassesThroughSaveFile.getItems().get(8);
        Item milk = InitOfClassesThroughSaveFile.getItems().get(11);

        foyer.getListOfItems().add(fishTank);
        foyer.getListOfItems().add(canOfTuna);

        theStudy.getListOfItems().add(canOfAnchovies);
        theStudy.getListOfItems().add(fishShapedKey);

        garden.getListOfItems().add(cart);
        garden.getListOfItems().add(rock);
        garden.getListOfItems().add(bagOfCatTreats);
        garden.getListOfItems().add(milk);

        livingRoom.getListOfItems().add(door);

        //FriendlyNPC
        NPC christofur = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(0);
        NPC bartholomeow = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(1);
        NPC kitty = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(3);

        theStudy.getListOfFriendlyNPCs().add(bartholomeow);
        theStudy.getListOfFriendlyNPCs().add(kitty);

        garden.getListOfFriendlyNPCs().add(christofur);

        //EnemyNPC
        NPC lucky = InitOfClassesThroughSaveFile.getEnemyNPCs().get(0);
        NPC patchesEnemy = InitOfClassesThroughSaveFile.getEnemyNPCs().get(1);
        NPC wildCat = InitOfClassesThroughSaveFile.getEnemyNPCs().get(2);

        foyer.getListOfEnemyNPCs().add(wildCat);
        theStudy.getListOfEnemyNPCs().add(wildCat);
        garden.getListOfEnemyNPCs().add(wildCat);

        livingRoom.getListOfEnemyNPCs().add(lucky);

        meowsterBedroom.getListOfEnemyNPCs().add(patchesEnemy);
    }

    public static void configureFriendlyNPCs() {
        NPC christofur = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(0);
        NPC bartholomeow = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(1);
        NPC patchesFriendly = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(2);
        NPC kitty = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(3);

        // christofur
        christofur.setName("Christofur");
        christofur.setDescription("A large, majestic grey cat. It has " +
                "a collar on, with a tag that says <Christofur>. He seems… a bit suspicious, yet kind enough.");
        Item canOfTuna = InitOfClassesThroughSaveFile.getItems().get(8);
        christofur.setItemToGive(canOfTuna);
        christofur.getDescriptionAfterCommand().put("give","Tuna! How Meowonderful! " +
                "Sorry for being so fiesty. I'm going to eat this then have short 10-hour nap in the sun.");
        christofur.setCanBeTalkedWith(true);
        christofur.getDescriptionAfterCommand().put("talk","Don't talk to me unless " +
                "you're talkin' tuna! Now scram!");

        // kitty
        kitty.setName("Kitty");
        kitty.setDescription("A tuxedo cat with a pink nose. She has a collar with a tag. It looks like her name" +
                "is... Kitty? Not very creative, but it is cute.");
        kitty.setCanBeTalkedWith(true);
        kitty.getDescriptionAfterCommand().put("talk","I have been looking for Patches but I can't find him " +
                "anywhere! I have heard he has locked himself away somewhere…");

        // bartholomeow
        bartholomeow.setName("Bartholomeow");
        bartholomeow.setDescription("This black and white cat has a black spot on his nose, along with spectacles and a tophat. It" +
                " looks like he is reading something out loud...");
        bartholomeow.setCanBeListenedTo(true);
        bartholomeow.getDescriptionAfterCommand().put("listen","You listened in, but you can't understand it. " +
                "It sounds like he is speaking in Latin! What a smart cat.");

        patchesFriendly.setName("Patches");
        patchesFriendly.setDescription("After you defeated Patches he seems to no longer be the blood craving monster he used to be." +
                " Tho it seems like there is something he wants from you.");

        Item salmon = InitOfClassesThroughSaveFile.getItems().get(7);
        patchesFriendly.setItemToGive(salmon);
        patchesFriendly.getDescriptionAfterCommand().put("give","Patches is finally satisfied. His eyes lit up when he saw the salmon" +
                " and now he is having the feast of his life.");
    }

    private static void configureEnemyNPCs() {
        NPC lucky = InitOfClassesThroughSaveFile.getEnemyNPCs().get(0);
        NPC patchesEnemy = InitOfClassesThroughSaveFile.getEnemyNPCs().get(1);
        NPC wildCat = InitOfClassesThroughSaveFile.getEnemyNPCs().get(2);

        NPC patchesFriendly = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(2);

        lucky.setName("Lucky");
        lucky.setDescription("His orange and white fur may seem friendly, but this cat has an evil look to his eyes. His " +
                "collar may say <Lucky> but you have a feeling you aren't so lucky to have crossed paths with " +
                "him... Something must be done!\n");
        lucky.setPercentChanceToShowUpAtLocationSwitch(100);
        lucky.setCanAttack(true);
        lucky.setCanBeAttacked(true);
        lucky.setDamage(10);
        lucky.setCurrentHealth(50);

        patchesEnemy.setName("Patches");
        patchesEnemy.setDescription("The cat. The myth. The legend. It is finally Patches himself!. " +
                "Only Patches would be able to afford a bedroom so lavish. \n" +
                "Ahh, I knew the day would come in which a human would make it here. I have been waiting. " +
                "Living in the lap of luxury, is nice, but I was beginning to become bored. Sure, you can run off " +
                "and tell all of your hairless human friends what it is like in here… if you can defeat me first!!");
        patchesEnemy.setNPCSpawnedAfterBattle(patchesFriendly);
        patchesEnemy.setPercentChanceToShowUpAtLocationSwitch(100);
        patchesEnemy.setCanAttack(true);
        patchesEnemy.setCanBeAttacked(true);
        patchesEnemy.setDamage(20);
        patchesEnemy.setCurrentHealth(100);

        wildCat.setName("WildCat");
        wildCat.setDescription("You stumble upon a crazy cat that is hissing at your louder than " +
                "could ever imagine a cat can hiss! It is clear he is thirsty for blood!");
        wildCat.setPercentChanceToShowUpAtLocationSwitch(30);
        wildCat.setCanAttack(true);
        wildCat.setCanBeAttacked(true);
        wildCat.setDamage(5);
        wildCat.setCurrentHealth(40);
    }

    public static void configureInventory() {
        Inventory inv = InitOfClassesThroughSaveFile.getInventory();

        Item redBull = InitOfClassesThroughSaveFile.getItems().get(9);
        Item kitKat = InitOfClassesThroughSaveFile.getItems().get(10);

        inv.getListOfItems().add(redBull);
        inv.getListOfItems().add(kitKat);
    }

    public static void configurePlayer() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Inventory inventory = InitOfClassesThroughSaveFile.getInventory();
        Level level1 = InitOfClassesThroughSaveFile.getLevels().get(0);

        playerStats.setCurrentLevel(level1);
        playerStats.setCurrentLocation(level1.getStartLocation());
        playerStats.setInventory(inventory);
        playerStats.setDamage(20);
    }
}
