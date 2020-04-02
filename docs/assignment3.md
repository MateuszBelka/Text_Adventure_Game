# Assignment 3

Maximum number of words for this document: 18000

**IMPORTANT**: In this assignment you will fully model and implement your system. The idea is that you improve your UML models and Java implementation by (i) applying (a subset of) the studied design patterns and (ii) adding any relevant implementation-specific details (e.g., classes with “technical purposes” which are not part of the domain of the system). The goal here is to improve the system in terms of maintainability, readability, evolvability, etc.    

**Format**: establish formatting conventions when describing your models in this document. For example, you style the name of each class in bold, whereas the attributes, operations, and associations as underlined text, objects are in italic, etc.

### Summary of changes of Assignment 2
Author(s): `Ece Doganer`

- For A1 and A2 phase, we had received heavy feedback on our functional features list, and quality requirements. This is now revised in full detail. We now have a total of 43 features. Multiple features the TA has stated missing, are now described. Some QR are moved to features. A better distinction is made between core and bonus features. In general, we tried to be straightforward and tried to cover more detail, when explaining our multitude of features.
- All diagrams are revised.
- All descriptions of those diagrams are revised accordingly. 
- Pickupable Items and Static items is fully revised according to TA's feedback. These classes are changed into one Item class. This Item class has 'traits' per object, so an item might be pickup-able or immovable.
- Even though input validation was fully functional, TA suggested to change it. Our train of thought previously, was to make it easy to play the game using GUI only. Thus, we would only require two types of items. We have fully revised it according to TA's feedback. The aim now, has been to make a Zork clone. Just like Zork, we tried to make a multitude of inputs, possible.<br><br> Input validation is divided into multiple classes with single responsibilities. Enumeration is used. Multiple instructions in one input, is not followed through, as suggested. Use of trigger words is described in detail, in A1. Being able to customize the response text when issuing input, has been given attention while coming up with a new plan. 
- Player class is broken up into multiple classes with different responsibilities, according to TA's feedback.
- Initializer class is broken up into multiple classes with different responsibilities, according to TA's feedback.
- Level class is broken up into multiple classes with different responsibilities, according to TA's feedback.
- We have changed the way 'puzzles' are solved, and updated our description accordingly. Previously, there were only two ways of solving a puzzle: interacting with a static item by writing its name, or, using a pickupable item on a static item, by writing both their names on the terminal. The idea there, was that our GUI would be clickable, thus player didn't need to ever type anything. This was our focus, because we wanted to improve gameplay for text-based games, which is frustrating when getting multiple errors when an instruction isn't available. We have moved away from this idea, as suggested in the feedback. TA probably wanted to steer us away from a project that might not be finished, due to focusing on changing gameplay by using GUI entirely. Another good reason to change our approach, is that we have not respected the broad experience that Zork gives, through making multiple command available. Our new approach is to have a combination of trigger words, as described in A1. Solving puzzles can now be a multitude of interactions. See A1's Puzzles feature for a description.
- Following the Zork-clone train of thought, our output is revised. We now print level description and location description, with the items and npcs descriptions in this location, once. Then, these descriptions can be asked again. Also, performing valid interactions now prints a specific description for that interaction with that entity (item or npc). This description is customisable.
- Game class is deleted, and the responsibilities is was supposed to have, have been moved. These are now partly in GameProgression, which deals with puzzle progress.
- Items and NPCs now have an abstract class, Entity. Their common attributes and resulting methods, are shared.
- We have renamed Room class with Location class (thus, "outside" is a location instead of a room now).
- Initialisation has been revised, as the whole game now works differently. Feedback for it in the class diagram has been taken into account.

> Word Count 633/2000

### Application of design patterns
Author(s): Valeriya Komarnitskaya, Mateusz Belka

[Figure representing the UML class diagram in which all the applied design patterns are highlighted graphically (for example with a red rectangle/circle with a reference to the ID of the applied design pattern] (https://github.com/Ece-Doganer/Software-Design/blob/Assignment3/docs/visual/Class_Diagram_DP.png)

For each application of any design pattern you have to provide a table conforming to the template below.

| ID  | DP1 | DP2 |
|---|---|---|
| **Design pattern**  | Factory Method | Singleton |
| **Problem**  | No matter how well we prepare our UML diagrams before we begin implementation there is always a possibility of encountering a hiccup or overlooking a potential issue. In the case of game elements we learned a lot as we were progressing with implementation. As we were discussing the role of newly added game elements such as **NPC** more, we realized that there will be a need for a unique solutions such that friendly and enemy **NPCs** are recognized as the same class in certain elements of our implementation but as separate in other parts. We shortly after realized that factory method will play a crucial role into creating this unique **NPC** class. | Our game supports only a single-player experience and as such there is never more than one instance of **PlayerStats** or **Inventory** class. The initial implementation of those classes allowed for more than one instance of them to exist. |
| **Solution**  | Factory method design pattern is a solution for this problem for multiple reasons. Firstly, it allows creation of an object of the class without exposing the logic to the elements of source code that will require this class later on. It is crucial for information hiding. Secondly, it creates a controlled environment where different versions of **NPC**  have their own limitations and as such different purposes. | In order to prevent the existance of multiple instances of **PlayerStats** and **Inventory**, both of those classes follow the Singleton design pattern. As such, it should prevent the possibility of wrongly creating additional instances of those classes. |
| **Intended use**  | As system gets more complex, more non-playable characters might appear in the further versions of the game that will have different roles in the story. Thus, in order to maintain simplicity of each singular game element the creation of **NPCs** will be done by providing an argument stating which type of **NPC** it is that you'd like to create. Currently it is possible to create **NPC** of the type **FriendlyNPC** or **EnemyNPC**. | When initiating new instances of classes, when it comes to **PlayerStats** and **Inventory** those classes can only be initiated through the call of their static method getInstance(). This method ensures that only one instance of those classes will exist during runtime. |

Maximum number of words for this section: 2000

## Class diagram									
Author(s): Valeriya Komarnitskaya, Ece Doganer, Mateusz Belka

The class diagram is divided into two parts due to the overwhelming amount of information. First part represents the relationships between classes while keeping the classes empty. The second part has no relationships but has all the attributes for classes. Due to the large size of the diagram we also included the original vpp files which can be opened directly from software "visual paradigm" to allow for best viewing experience. Those files can be found at: "docs/diagramsOriginalFormat".

<div align="center">
    <img src="visual/ClassDiagram1Assignment3.png" width="90%">
</div>

<div align="center">
    <img src="visual/ClassDiagram2Assignment3.png" width="90%">
</div>

The save and load package provides the backend implementation for saving and loading storylines. In the current implementation the package is also responsible for holding information about the included storylines, Dev Demo and Meow Manor. The entire package doesn't contain any attributes; however, it has plethora of operations. Starting with the **Save** class: writeGameSave is the public method meant to be called by other areas of source code when a save of current state of the game into JSON is wanted. The method requires a parameter with the absolute path for the file that the information is meant to be saved in. The next set of operation within Save class are all private and are called directly or indirectly through writeGameSave method. The six operations that start with setIDsOf... aim to set the id attributes of respective objects to desired values. Those attributes are then later used by the Load class during the loading of JSON file. EncodeIDsOfObjects is a container operation which aims to localize all calls to further operations which connect instances of one class to another. The purpose of this is to allow during loading to recreate the existing graph of objects which otherwise wouldn't be achievable with unchanged gson library. All of the connect operations replace the objects references to references of the object's id. PopulateJsonWithClasses is an operation which takes all of the classes kept inside **InitOfClassesThroughSaveFile** and serializes them into JSON file. The JSON file has the exact path that was provided in the operation's parameter. **NPCClassAdapter** and it's operations serialize and deserialize are responsible for providing additional functionality to gson library such that it is possible to save and load objects of the abstract class, **NPC**. The Load class's operations aim to reverse the process of the Save class's operations. LoadGameFromSave and LoadGame are responsible for loading information from JSON file to **InitOfClassesThroughSaveFile** class such that this information is now accessible within source code. The two operations differ due to the minor changes in the loading process for games that are stored in resources directory and saves which are stored in the saves directory. DecodeIDsToObjects is a container operations which groups up all calls to methods which transform the id attributes to their intended object references. All of the connect operations reconstruct the intended graph of objects in such a way that no duplicates of objects are creates in the result. The last operation within this class, configPrintingDescriptions is responsible for resetting the value of the boolean attribute firstTimeEnteringLocation of **Items** and **FriendlyNPCs** to true as to allow player to see the descriptions once again. The packages meowManor and demoOne have identical structure and operate on the same principle so they will be discussed together. CreateDemo operation is the public method responsible for initiating the process of creating a game as described in the other files within its package. **InitClasses** class and it's operation initEverything is responsible for calling all other init operations within the class. Those operations in turn aim to create the right number of instances of different classes as to accommodate for the story being presented. Afterward the **ConfigureClasses** class and it's operation configureEverything is responsible for changing the individual attributes of all the recently created objects in such a way as to have a fully functional storyline. **SerializeClasses** class and it's operation serializeDemo is responsible for acquiring the appropriate absolute path and calling the writeGameSave method within **Save** class.

note 1: Our tool does not create the compartments (attributes, operations, responsibility) of a class, if there is no content in them.
note 2: All the setters and getters of an attribute are self-explanatory and will not be explained in this class diagram. They will be simply mentioned by name, for completeness.
note 3: For binary association : Our tool only has a normal line with a floating arrow next to it, instead of a solid-line with an open arrow end. For big groups of binary associations, we have added notes, in order not to have too many floating arrows.

Package Engine:<br>
*- inputsUntilAutoSave : int* <br>
*+ getInputsUntilAutoSave() : int* <br>
*+ setInputsUntilAutoSave(inputsUntilAutoSave : int) : int* <br>
*+ initializeGameScene(terminal : TextArea) : void* <br>
*+ progressGame(input : String, terminal : TextArea, actionEvent : ActionEvent) : void* <br>
*- autoSaveCheck() : void* <br>
 
 Package GameProgress:GameProgression :<br>
 *+ checkLevelProgression() : void*<br>
 *- progressLevel() : void*<br>
 *+ isGameCompleted() : boolean*<br>
 *- printGameCompleted() : void*<br>
 *+ inputValidationAfterGameOver(input : String, actionEvent : ActionEvent) : void*<br>
 
 Package GameProgress:PuzzleProgression :<br>
 *+ resetPuzzlesSolvedCount() : void*<br>
 *+ incrementPuzzlesSolvedCount() : void*<br>
 *+ getPuzzlesSolvedCount() : int*<br>
 *+ incrementPuzzleCountGiveXPDrainHunger() : void*<br>
 
 Package Initialisation:InitOfClassesThroughSaveFile:<br>
 *- items : ArrayList<Item>*<br>
 *- levels : ArrayList<Level>*<br>
 *- locations : ArrayList<Location>*<br>
 *- friendlyNPCs : ArrayList<NPC>*<br>
 *- enemyNPCs : ArrayList<NPC>*<br>
 *- inventory : Inventory*<br>
 *- playerStats : PlayerStats*<br>
 *+ setItems(items : ArrayList<Item>) : void*<br>
 *+ setLevels(levels : ArrayList<Level>) : void*<br>
 *+ setLocations(locations : ArrayList<Location>) : void*<br>
 *+ setFriendlyNPCs(friendlyNPCs : ArrayList<NPC>) : void*<br>
 *+ getEnemyNPCs() : ArrayList<NPC>*<br>
 *+ setEnemyNPCs(enemyNPCs : ArrayList<NPC>) : void*<br>
 *+ setInventory(inventory : Inventory) : void*<br>
 *+ setPlayerStats(playerStats : PlayerStats) : void*<br>
 *+ getItems() : ArrayList<Item>*<br>
 *+ getLevels() : ArrayList<Level>*<br>
 *+ getLocations() : ArrayList<Location>*<br>
 *+ getFriendlyNPCs() : ArrayList<NPC>*<br>
 *+ getInventory() : Inventory*<br>
 *+ getPlayerStats() : PlayerStats*<br>
 
 Package Initialisation:InitOfStoryIndependentClasses:<br>
 *- adventure : Adventure*<br>
 *+ getAdventure() : Adventure*<br>
 *+ setAdventure(adventure : Adventure) : void*<br>
 
 Package SaveAndLoad:Save :<br>
 *+ writeGameSave(fileName : String ) : void*<br>
 *- setIDsOfObjects() : void*<br>
 *- setIDsOfItems() : void*<br>
 *- setIDsOfLevels() : void*<br>
 *- setIDsOfLocations() : void*<br>
 *- setIDsOfFriendlyNPCs() : void*<br>
 *- setIDsOfEnemyNPCs() : void*<br>
 *- encodeIDsOfObjects() : void*<br>
 *- connectPlayerToLocation() : void*<br>
 *- connectPlayerToLevel() : void*<br>
 *- connectPlayerToLocations() : void*<br>
 *- connectLevelsToLocation() : void*<br>
 *- connectLevelsToLevels() : void*<br>
 *- connectLocationsToItems() : void*<br>
 *- connectLocationsToFriendlyNPCs() : void*<br>
 *- connectLocationsToEnemyNPCs() : void*<br>
 *- connectLocationsToHashMap() : void*<br>
 *- connectItemsToNPCs() : void*<br>
 *- connectItemsToItems() : void*<br>
 *- connectNPCToNPC() : void*<br>
 *- connectNPCToItems() : void*<br>
 *- connectInventoryToItems() : void*<br>
 *- populateJsonWithClasses(fileName : String) : void*<br>
 
 Package SaveAndLoad:Load :<br>
 *+ loadGameFromSave(filePath : String) : void*<br>
 *- initializeClassesFromJsonSave(filePath : String) : void*<br>
 *+ loadGame(fileName : String) : void*<br>
 *- initializeClassesFromJson(fileName : String) : void*<br>
 *- decodeIDsToObjects() : void*<br>
 *- connectPlayerToLocation() : void*<br>
 *- connectPlayerToLevel() : void*<br>
 *- connectPlayerToLocations() : void*<br>
 *- connectPlayerToInventory() : void*<br>
 *- connectLevelsToLocation() : void*<br>
 *- connectLevelsToLevels() : void*<br>
 *- connectLocationsToItems() : void*<br>
 *- connectLocationsToFriendlyNPCs() : void*<br>
 *- connectLocationsToEnemyNPCs() : void*<br>
 *- connectLocationsToHashMap() : void*<br>
 *- connectItemsToItems() : void*<br>
 *- connectItemsToNPCs() : void*<br>
 *- connectNPCToItems() : void*<br>
 *- connectNPCToNPC() : void*<br>
 *- connectInventoryToItems() : void*<br>
 *- configPrintingDescriptions() : void*<br>
 
 Package SaveAndLoad:NPCClassAdapter:<br>
 *+ serialize(src : NPC, typeOfSrc : Type, context : JsonSerializationContext) : JsonElement*<br>
 *+ deserialize(json : JsonElement, typeOfT : Type, context : JsonDeserializationContext)*<br>
 
 Package SaveAndLoad:MeowManor:ConfigureClasses:<br>
  *+ configureEverything() : void*<br>
  *+ configureItems() : void*<br>
  *+ configureLevels() : void*<br>
  *+ configureLocations() : void*<br>
  *+ configureFriendlyNPCs() : void*<br>
  *- configureEnemyNPCs() : void *<br>
  *+ configureInventory() : void*<br>
  *+ configurePlayer() : void*<br>
  
  Package SaveAndLoad:MeowManor:CreateGame:<br>
  *+ createDemo() : void*<br>
  
  Package SaveAndLoad:MeowManor:InitClasses:<br>
  *+ initEverything() : void*<br>
  *+ initPlayer() : PlayerStats*<br>
  *+ initInventory() : Inventory*<br>
  *+ initLevels() : ArrayList<Level>*<br>
  *+ initLocations() : ArrayList<Location>*<br>
  *+ initItems() : ArrayList<Item>*<br>
  *+ initFriendlyNPC() : ArrayList<NPC>*<br>
  *+ initEnemyNPC() : ArrayList<NPC>*<br>
  
  Package SaveAndLoad:MeowManor:SerializeClasses:<br>
  *+ serializeDemo() : void*<br>
 
 Package SaveAndLoad:DemoOne:ConfigureClasses:<br>
 *+ configureEverything() : void*<br>
 *+ configureItems() : void*<br>
 *+ configureLevels() : void*<br>
 *+ configureLocations() : void*<br>
 *+ configureFriendlyNPCs() : void*<br>
 *- configureEnemyNPCs() : void *<br>
 *+ configureInventory() : void*<br>
 *+ configurePlayer() : void*<br>
 
 Package SaveAndLoad:DemoOne:CreateGame:<br>
 *+ createDemo() : void*<br>
 
 Package SaveAndLoad:DemoOne:InitClasses:<br>
 *+ initEverything() : void*<br>
 *+ initPlayer() : PlayerStats*<br>
 *+ initInventory() : Inventory*<br>
 *+ initLevels() : ArrayList<Level>*<br>
 *+ initLocations() : ArrayList<Location>*<br>
 *+ initItems() : ArrayList<Item>*<br>
 *+ initFriendlyNPC() : ArrayList<NPC>*<br>
 *+ initEnemyNPC() : ArrayList<NPC>*<br>
 
 Package SaveAndLoad:DemoOne:SerializeClasses:<br>
 *+ serializeDemo() : void*<br>
 
 Package Output:CombatPrinter:<br>
 *+ printCombat() : void*<br>
 
 Package Output:InteractionPrinter:<br>
 *- listToPrint : ArrayList<String>*<br>
 *- getListToPrint() : ArrayList<String>*<br>
 *- setListToPrint(listToPrint : ArrayList<String>) : void*<br>
 *+ print(newline : String) : void*<br>
 *+ printToTerminal() : void*<br>
 
 Package Output:DescriptionGetter:<br>
 *- listToPrint : ArrayList<String>*<br>
 *+ compileStoryText() : ArrayList<String>*<br>
 *- addLevelTextIfFirstPrint() : void*<br>
 *- addLocationTextAndListOfEntitiesIfFirstPrint() : void*<br>
 *- addListOfEntitiesInLocationIfFirstPrint() : void*<br>
 *- addListOfItems() : String*<br>
 *- addListOfNPCs() : String*<br>
 
 Package Output:DescriptionPrinter:<br>
 *+ printStory(terminal : TextArea) : void*<br>
 
 Package Output:UserInputPrinter:<br>
 *+ printUserInput(input : String) : void*<br>
 
 Package ui:UI:<br>
 
 Package ui:Controllers:<br>
 
 Package gameElements:battle:<br>
 
 Package gameElements:Player:PlayerStats:<br>
 
 Package gameElements:Player:Inventory:<br>
 
 Package gameElements:Player:PlayerHealthProgression:<br>
 
 Package gameElements:Player:PlayerHungerProgression:<br>
 
 Package gameElements:Player:PlayerLevellingProgression:<br>
 
 Package gameElements:levelAndContents:npc:EnemyNPC:<br>
 
 Package gameElements:levelAndContents:npc:FriendlyNPC:<br>
 
 Package gameElements:levelAndContents:npc:NPCFactory:<br>
 
 Package gameElements:levelAndContents:Entity:<br>
 
 Package gameElements:levelAndContents:Item:<br>
 
 Package gameElements:levelAndContents:Level:<br>
 
 Package gameElements:levelAndContents:Location:<br>
 
 Package input:combatValidation:<br>
 
 Package input:commands:DoAttack:<br>
 
 Package input:commands:DoBack:<br>
 
 Package input:commands:DoBreak:<br>
 
 Package input:commands:DoClose:<br>
 
 Package input:commands:DoConsume:<br>
 
 Package input:commands:DoCut:<br>
 
 Package input:commands:DoDrop:<br>
 
 Package input:commands:DoExamine:<br>
 
 
 Package input:commands:DoExit:<br>
 *+ doExit (actionEvent : ActionEvent) : void*<br>
 
 Package input:commands:DoGetDirections:<br>
 *+ doGetDirections() : void*<br>
 
 Package input:commands:DoGetInventory:<br>
 *+ doInventoryLookUp() : void*<br>
 
 Package input:commands:DoGiveItemToNPC:<br>
 *+ doGiveItemToNPC(item : Item, npc : NPC) : void*<br>
 
 Package input:commands:DoGoToMenu:<br>
 *+ doGoToMenu(actionEvent : ActionEvent) : void*<br> 
 
 Package input:commands:DoHelp:<br>
 *+ doHelp() : void*<br>
 
 Package input:commands:DoListen:<br>
 *+ doListen() : void*<br>
 *+ doListenTo(item : Item) : void*<br>
 *+ doListenTo(npc : NPC) : void*<br>
 *+ doListenToNPCWithItem(npc : NPC, item : Item) : void*<br>
 *+ doListenToItemWithItem(itemToListenTo : Item, itemToListenWith : Item) : void*<br>
 
 Package input:commands:DoLoad:<br>
 *+ doLoad(actionEvent : ActionEvent)*<br>
 
 Package input:commands:DoLook:<br>
 *+ doLook() : void*<br>
 
 Package input:commands:DoMove:<br>
 *+ doMove (location : Location) : void*<br>
 
 Package input:commands:DoOpen:<br>
 *+ doOpen (item : Item) : void*<br>
 *+ doOpen (npc : NPC) : void*<br>
 *+ doOpenItemWithItem (itemToOpen : Item, itemToOpenWith : Item) : void*<br>
 
 Package input:commands:DoPickUp:<br>
 *+ doPickUp(item : Item) : void*<br>
 
 Package input:commands:DoPull:<br>
 *+ doPull (item : Item) : void*<br>
 *+ doPull (npc : NPC) : void*<br>
 
 Package input:commands:DoPush:<br>
 *+ doPush(item : Item) : void*<br>
 *+ doPush(npc : NPC) : void*<br>
 
 Package input:commands:DoRead:<br>
 *+ doRead(item : Item) : void*<br>
 
 Package input:commands:DoSave:<br>
 *+ doSave : void*<br>
 *+ doAutoSave : void*<br>
 *- saveLogic(jsonFileName : String) : void*<br>
 
 Package input:commands:DoSmell:<br>
 *+ doSmell() : void*<br>
 *+ doSmell(item : Item) : void*<br>
 *+ doSmell(npc : NPC)*<br>
 
 Package input:commands:DoTalkWith:<br>
 *+ doTalkWith(npc : NPC) : void*<br>
 *+ doTalkWith(item : Item) : void*<br>
 
 Package input:commands:DoUnlock:<br>
 *+ doUnlockItemWithItem (itemToUnlock : Item, itemToUnlockWith : Item) : void*<br>
 
 Package input:commands:DoUse:<br>
 *+ doUse(item : Item) : void*<br>
 *+ doUse(npc : NPC) : void*<br>
 *+ doUseItemOnNPC(item : Item, npc : NPC) : void*<br>
 *+ doUseItemOnItem(item1 : Item, item2 : Item)  : void*<br>
 
 Package input:validation:HandlerOf1Word<br>
 *# validateAndHandle1Word(validInputList : HashMap<String, String>, actionEvent : ActionEvent) : void*<br>
 *- handle1Command(command : String , actionEvent : ActionEvent) : void*<br>
 *- doCommand(command : String, actionEvent : ActionEvent) : void*<br>
 *- handleReadCommand() : void*<br>
 *- handle1Item(item : Item) : void*<br>
 *- handle1NPC(npc : NPC) : void*<br>
 *# handle1Direction(direction : String) : void*<br>
 
 Package input:validation:HandlerOf2Words <br>
 *# validateAndHandle2Words( validInputList : HashMap<String, String>) : void*<br>
 *- validateAndHandleItemAndNPCCombination(item : Item, npc : NPC) : void*<br>
 *- validateAndHandleCommandAndItemCombination(command : String, item : Item) : void*<br>
 *- cutItemCommand(item : Item) : void*<br>
 *- validateAndHandleCommandAndNPCCombination(command : String, npc : NPC) : void*<br>
 *- cutNPCCommand(npc : NPC) : void*<br>
 *- validateAndHandleCommandAndDirectionCombination(command : String, direction : String) : void*<br>
 
 Package input:validation:HandlerOf3Words<br>
 *# validateAndHandle3Words(validInputList : HashMap<String, String>) : void*<br>
 *- validateAndHandleCommandItemNpcCombination(command : String, item : Item, npc : NPC) : void*<br>
 *- validateAndHandleCommandItemItemCombination(command : String, item1 : Item, item2 : Item) : void*<br>
 
 Package input:validation:inputValidation<br>
 *+ inputValidator(validInputList : HashMap<String, String>, actionEvent : ActionEvent) : void*<br>
 *# getKeyInValidInputList(validInputList : HashMap<String, String>, value : String) : String*<br>
 *- deleteFirstAndLastChar(value : String) : String*<br>
 *# getItem(validInputList : HashMap<String, String>) : Item*<br>
 *# getCommand(validInputList : HashMap<String, String>) : String*<br>
 *# getNPC(validInputList : HashMap<String, String>) : NPC*<br>
 *# getDirection(validInputList : HashMap<String, String>) : String*<br>
 
 Package input:validation:Validation<br>
 *+ validator(String input, ActionEvent actionEvent) : void*<br>
 *- inputParser(String input) : String*<br>
 *+ compileValidList(inputList : String[]) : HashMap<String, String>*<br>
 
 Package input:validation:WordValidation<br>
 *+ wordValidator(inputList : String[]) : HashMap<String, String>* validates words by getting lists from enum Commands, Directions, and from player's currentLocation's items and npcs. Returns a Hashmap containing those words, with a value of "command", "item", "direction", or "npc".<br>
 *- commandValidator(word : String,  validInputList : HashMap<String, String>) : void*<br>
 *- directionValidator(word : String, validInputList : HashMap<String, String>) : void*<br>
 *- itemValidator(word : String, validInputList : HashMap<String, String>) : void*<br>
 *- addItemToValidInputListIfFoundInPassedList (word : String, validInputList : HashMap<String, String>, list : ArrayList<Item>) : void*<br>
 *- npcValidator(word : String, validInputList : HashMap<String, String>) : void*<br>
 
 
 
 
 
 
 ####Initialisation: 
 **InitOfClassesThroughSaveFile** and **InitOfStoryIndependentClasses** is a part of the initialisation package and contains a group of methods and attributes that are responsible for initialisation of the system. It is done by configuration and creation of necessary instances, story-related objects, getters and setters methods.
 **InitOfClassesThroughSaveFile :** 
 *items* - a private variable providing information about the items that are in the room or in inventory
 *levels* - a private variable that contains information about levels in the game
 *locations* - a private variable referring to the locations in the game and storyline, usually related to the name of the room/some space where the character is located
 *friendlyNPCs* - a private variable referring to the non-playable characters that is not going to harm a player
 *enemyNPCs* - a private variable referring to non-playable characters whose aim is to defeat the player
 *inventory* - a private variable that contains information about items that were picked up by a player and currently are in his/her inventory
 *playerStats* - a private variable that contains information about a playable character: current health, hunger, level, damage, etc.
 *setItems*, *getItems* - setter and getter function for items
 *setLevels*, *getLevels* -  setter and getter function for levels
 *setLocations*, *getLocations* -  setter and getter function for locations
 *setFriendlyNPCs*, *getFriendlyNPCs* -  setter and getter function for friendly NPCs
 *setEnemyNPCs*, *getEnemyNPCs* -  setter and getter function for enemy NPCs
 *setInventory*, *getInventory* - setter and getter function for player’s inventory
 *setPlayerStats*, *getPlayerStats* - setter and getter function for player’s characteristics
 
 **InitOfStoryIndependentClasses :**
 *adventure* - a private variable that is responsible for UI scene. Without this variable, accessing terminal and input is not possible
 *getAdventure* and *setAdventure* - getter and setter for UI scene
 
 
 

This chapter contains the specification of the UML class diagram of your system, together with a textual description of all its elements.

`Figure representing the UML class diagram`

For each class (and data type) in the class diagram you have to provide a paragraph providing the following information:
- Brief description about what it represents
- Brief description of the meaning of each attribute
- Brief description of the meaning of each operation
- Brief description of the meaning of each association involving it (each association can be described only once in this deliverable)

Also, you can briefly discuss fragments of previous versions of the class diagram (with figures) in order to show how you evolved from initial versions of the class diagram to the final one.

In this document you have to adhere to the following formatting conventions:
- the name of each **class** is in bold
- the *attributes*, *operations*, *associations*, and *objects* are in italic.

Maximum number of words for this section: 4000

## Object diagrams								
Author: Mateusz Belka

The object diagram is divided into two parts due to the overwhelming amount of information. First part represents the relationships between classes while keeping the classes empty. The second part has no relationships but has all the attributes for classes. Due to the large size of the diagram we also included the original vpp files which can be opened directly from software "visual paradigm" to allow for best viewing experience. Those files can be found at: "docs/diagramsOriginalFormat".

<div align="center">
    <img src="visual/ObjectDiagram1Assignment3.png" width="90%">
</div>

<div align="center">
    <img src="visual/ObjectDiagram2Assignment3.png" width="90%">
</div>
  
As opposed to assignment 2, for assignment 3, we were able to prepare a fully functional game and surrounding storyline. As such, a new opportunity arose in the case of object diagram as now we can represent our system during the actual runtime. In a state that the user will be at during certain point in time while playing our game. The purpose of this diagram is to represent an instance at a particular moment, which is concrete in nature. Our object diagram aims to allow for a closer look at our system's behaviour. The objective of such representation of our design is to enable third parties to gain insight into the ongoing information exchanges and manipulations within our software. We believe such information could not be collected by merely exploring the end product.  
The object diagram at hand aims to represent the initial state of our system after loading the Meow Manor game through the new game UI scene. Our objective was to allow easy replication of this state from the executable jar as to add to the validity of it and potentially provide further ability for the third party to become acquainted with how our system works. Similarly to our approach in assignment 2, the object diagram revolves around the initialisation package. In order for all classes to have access to instances of other classes, we use the initialisation package to contain this information. That includes mainly the information that is loaded through the JSON file, with once exception. To implement seamless output functionality, we had to implement a storage class for the instance of a UI controller **Adventure**. The only controller which we always need access to is the one responsible for handling information flow from the main gameplay scene, which we call **Adventure**. The **Adventure** scene is loaded whenever the player decides to play a new game or loads up an existing save. The other key aspect of our object diagram is the structure of game elements which describe the possible movement options for the player. This is most likely the aspect of our overall system that has changed the least. However, we believed that changing the class name from **Room** to **Location** allows for more ambiguous interpretation, which is what we are aiming for since we are attempting to support a wide range of different storylines. The essential division between **Levels** and **Locations** is maintained. The instance of our system we chose to represent has three **Levels**. The primary purpose of this division is to guide user experience through the requirement to complete a certain number of puzzles in each **Level**. It is, however, entirely within the story creators tools to make use of this structure in a wholly different way. An implementation with one **Level** is just as valid if that is what the story constitutes.  
There are, however, two structures within game elements package which received a much-needed overhaul, which is apparent in the object diagram. Those being **NPC** and **Item**. The changes made aren't strictly noticeable from the gameplay perspective; however, while analysing the object diagram, it becomes clear that the internal structure and logic of the system works much differently. 
We aspired to allow for vast flexibility with the way a user might want to implement **NPCs** in their story. As such we wanted to support enemies who would attack the player during the change of **Location**. Additionally, our goal was to implement friendly **NPCs** that the player can interact with. Further in the development, we realised attacking a friendly **NPC** should also be a possibility. From that moment onward, we knew that enemy and friendly characters should be inherently treated like the same game element by **Battle Sequence** logic. In contrast, internally we'd make the distinction between the ones that are friendly and the ones that are not. As a result of this approach, each instance of **NPC** class has an immense number of attributes which are needed for the system to accurately know in which ways can player interact with each **NPC**. Even while working on assignment 1, we knew that there should be a distinction between items which are meant to be picked up and ones that are a static element of the world. In assignment 2, we attempted to create this distinction by making two independent classes **PickupableItem** and **StaticItem**. We've learned, however, that this approach has many shortcomings which would arise as we expand on the features that are implemented in source code. For assignment 3, we've decided to merge them into a single **Item** class and to control their behaviour and interactions with the player they currently have a wide range of attributes.  
In the runtime scenario presented in our object diagram, the player is positioned in the Foyer **Location** which is part of **Level** one. Player has two edible **Items**, Red Bull and KitKat, in their inventory. Using the information from Foyer **Location** we know that the player can move to the west and east and reach the Study and Garden **Locations** respectively.

> Word Count 839/1000

## State machine diagrams									
Author(s): Valeriya Komarnitskaya, Taylor Doughty

<div align="center">
    <img src="visual/TaylorSMDLevel.png" width="90%">
</div>

[ Package controllers: classes Welcome, NewGame, LoadGame ](https://github.com/Ece-Doganer/Software-Design/blob/Assignment3/docs/visual/diagram.pdf)

State machine diagram represents states and events that are happening from the moment a user opens executable until the actual start of the game and the storyline. The decision to implement this part of the process in the diagram was made because, in our opinion, it is crucial to show what happens as a very first thing when the player enters the game, through which states does the game go to load the game. 

The diagram starts with a state called "Game Option Selection" after a user turns on the executable file. It is a menu with three clickable options: "New Game", "Load Game" and "Quit". Depending on the choice you are making, you can have three outcomes as follows: to begin a new game from the start, to continue previously played game and to exit to the desktop. The following structure can be considered as a tree. Then, depending on the choice a player has made, a choice pseudostate is entered. It is necessary because different inputs lead to different states. Guards are checking which command was pressed. 
If the button "New Game" was pressed, the player is transferred to a state called "Game selection" and sees a screen with three options: "DevDemo", "Meow Manor" and "Back". "DevDemo" and "Meow Manor" are different game stories. "Back" will open the starting screen again, the state called "Game Option Selection". A choice pseudostate determines with a guard which command was pressed. "DevDemo" and "Meow Manor" lead to the pseudostate called "Game State", in which game terminal is open, there is a welcoming text and program is ready for input. When a player types command, a terminal is processing it, outputs a description of the location, items in the room and is waiting for the new input.
If the button "Load Game" is pressed, then a new state is entered called "Loading Game selection".  A player sees three options as well: "Auto-Save" means that a player will enter the previously played game on the latest auto-saved moment. "Save0" is the name of the game that was saved manually by a player. Save0 is just an indicator; it can be any name that a player will want. For the next state, after a player pressed a command, guards check the input. If the command that was pressed is either "Save0" or "AutoSave", it leads to the state called "GameState". "Back" will take a user to the very first starting screen, a state called "Game option selection". 

This chapter contains the specification of at least 2 UML state machines of your system, together with a textual description of all their elements. Also, remember that classes the describe only data structures (e.g., Coordinate, Position) do not need to have an associated state machine since they can be seen as simple "data containers" without behaviour (they have only stateless objects).

For each state machine you have to provide:
- the name of the class for which you are representing the internal behavior;
- a figure representing the part of state machine;
- a textual description of all its states, transitions, activities, etc. in a narrative manner (you do not need to structure your description into tables in this case). We expect 3-4 lines of text for describing trivial or very simple state machines (e.g., those with one to three states), whereas you will provide longer descriptions (e.g., ~500 words) when describing more complex state machines.

The goal of your state machine diagrams is both descriptive and prescriptive, so put the needed level of detail here, finding the right trade-off between understandability of the models and their precision.

Maximum number of words for this section: 4000

## Sequence diagrams									
Author(s): Valeriya Komarnitskaya, Ece Doganer

[ Package input, Class DoMove ](https://github.com/Ece-Doganer/Software-Design/blob/Assignment3/docs/visual/Movement%20SD.png)

Sequence Diagram represents states and events that are arranged in time sequence. The following sequence diagram describes processes from the moment a player enters the direction he/she wants to move in till the moment when the message about the successful movement and further description will appear on the screen. 

The process starts with the user typing the input to the terminal. For movement, there are four possible ways of moving in eight directions: move/run/go/walk [in direction: North/South/East/West/Northeast/Northwest/Northeast/Southeast/Southwest] or [direction:North/South/East/West/Northeast/Northwest/Northeast/Southeast/Southwest]. We implemented it this way, so a player will have a smaller chance of getting an input error and a higher chance to parse the input. This makes our game more user-friendly and allows a player to choose the most convenient option. After that, the inputted command is passed to the class **Validation**. **Validation** class has three responsibilities. First is checking the input: if the input is valid, parsing the input and checking if the direction is valid in terms of spelling. Second, in order to understand if a player can move in a certain direction, we need to take into account the configuration of rooms. Depending on the room you are in, it is important to request a list of available directions class and check if the inputted direction is within the list. As a result of checks inside **Validation** here are two scenarios: either the input is valid(correct spelling, valid direction, valid movement) or not valid. If it is not valid, the **StoryTextGetter** receives information about it and the user receives a message stating where exactly the input was invalid. If the input is valid, then a function <u>doMove</u> from the class DoMove is called that allows a character to change a location and <u>setCurrentLocation</u> to location. This way, the *movedLocationList* variable is increased by 1. It is important to keep track of the rooms visited due to our backtracking feature. We decrease our hunger points due to the fact that every time we move, we are getting hungrier. In the diagram we show it as if it is decreased by 1 - it is an abstraction. In the implementation, we have a special variable for decreasing hunger level. After that, the **StoryTextGetter** class receives a text to print, which will include a description of the room, items, possible enemies, quests. 


>Word count 378/4000

#### Two Steps of Input Validation

Validating input is a three-step process. First, an input sentence is validated per word. Then, the input as a whole is considered for validation, grouping certain types of inputs together. Beyond the scope of these diagrams is step three, named "logical validation". What is meant with this term is that a final check is done before an input can be handled. This check is different per valid instruction.

![Word Validation Diagram](./visual/WordValidation.png "Part one of Input Validation : Word Validation Diagram" )

This diagram begins at the <b>Validation</b> Class. The sole instance of this class receives the input, which needs to be validated. First off, the input is parsed internally. Then, this parsed input is sent to the sole instance of class <b>WordValidator</b>. 

The <b>WordValidator</b> instance needs to do a number of things. Firstly, the input sentence is parsed into words. From here on, comparing the words to a list of previously known words, begins. This is done as follows:

A word is compared with with a list of other known words. We will call these known words, trigger words. Trigger words can be into grouped into 4 different types: a `[command]`, a `[direction]`, an `[item]`, an `[npc]`. Anything which is not within these 4 types of grouped words, is not understood by the system. An error message will be given if this is the case. It will state that no valid input is detected.

A `[command]` type word for example, is "eat". All possible words in this group, are listed in the enumeration class as constants. The instance of <b>WordValidator</b> will request this list, from the enumeration class <b>Commands</b>.

The same terms apply to `[direction]`: The list of associated trigger words will be requested from the <b>Directions</b> enumeration class.

For the `[item]` and `[npc]` types, the sequence differs. Instead of comparing words with all possible items and non-playable-characters in an interactive story, the following happens: First, <b>InputValidation</b> instance requests the current location of the player, which is stored in the instance of the <b>PlayerStats class</b>. This instance of the class <b>Location</b>, has two lists: a list of items, and a list of non-playable-characters. The instance of <b>WordValidator</b> requests both these lists. This comparison is superior to comparing with all the possible items and non-playable characters, as size of the list to compare will be smaller.

After having collected all the lists with all possible words that are valid, the instance of <b>WordValidator</b> can start comparing. When comparing, a HashMap is made. In this HashMap, the word is noted as a key, and the value belonging to that key, is the type of trigger word. For example, key "eat" would have value "command". Additionally, if the compared word is not listed in the lists of trigger words, nothing will happen.

The <b>WordValidator</b> instance has fulfilled its responsibility: words have now been validated, and the HashMap is sent to the <b>Validation</b> instance. The next step for validating input, can commence.

![Word Validation Diagram](./visual/InputValidation.png "Part two of Input Validation : Word Validation Diagram" )

Valid instructions in this game, have a typical syntax. Instructions can be one word, for example 'save', 'help', or 'look'. Instructions of two words is another possibility. Examples are 'eat apple', 'attack Henry', or 'pull lever'. The third type of syntax for instructions is of three words. Examples are 'open box with key', or 'give book to Henry', where prepositions are ignored. Subsequently, the second step of validating input is to check for the size of the HashMap. 

If the HashMap has no entries, then all compared words were invalid. In this case, a message is shown, which states that no valid input is detected by the validator.

If the HashMap has one entry, the HashMap is sent to the instance of class <b>HandlerOf1Word</b>, which handles one valid word. This word can still be any of  `[command]`, `[direction]`, `[item]`, or `[npc]`.

If the HashMap has two entries, it will be sent to the instance of <b>HandlerOf2Words</b>, respectively.

With three entries, the HashMap is sent to the instance of <b>HandlerOf3Words</b>.

If there are more entries than three, then the syntax is simply is too complicated for the system to handle. A message is then printed, stating to use less words.

By sending the HashMap to the right handlers, or by printing an error message, the responsibility of the <b>InputValidator</b> instance is now fulfilled. This concludes step two of the validation.

> Word count 704/4000<br>
> Word count total for sequence diagram descriptions: 1082/4000 

## Implementation									
Author: Mateusz Belka

Our UML diagrams have drastically changed from the state they were in as part of Assignment 2. As such, those changes naturally had to be represented in our implementation. Firstly, we constructed the necessary packages to organise the plethora of classes that we had recently added. This division proved to be crucial in allowing us to orientate between related and unrelated classes visually. As such, it made it clear when one aspect of our system was communicating with another. It was the most transparent during transitions between back-end and front-end parts of our source code.  
We redesigned our classes while maintaining the same frame of mind in terms of critical aspects of our program. One of the vital features of our game was to implement our internal logic in such a way as to allow the implementation of new stories in our system. As such, any change to our UML, and by extension our implementation, was made in such a way as to accommodate the introduction of new storylines.  
While transforming our class diagram into functional source code, we encountered several issues that couldn't have been predicted by UML diagrams. There are two most notable ones. The first one being the intricacies related to serialising classes into JSON format. The library of our choice to support us with this challenge was google's gson. The issue we encountered early on that we never managed to find an easy solution to was maintaining the object references through JSON data. If the same object was referenced in multiple locations, it was impossible, using out-of-the-box gson, to support those same references when saving and loading from the JSON file. If we were to do that, the result would be multiple copies of the references object which do not share the information between each other. As such if there would be a change to the contents of the object references in one part of the source code; that change wouldn't be seen in the other references to said object. The solution to this problem that we ended up implementing was a system of IDs for classes that carry unique information and have multiple instances during the runtime of our program. An example of such a class would be Location class. **PlayerStats** class wouldn't be an example of such class due to the fact there is always a single instance of this class during runtime. However, the element of complexity for this issue occurs when a class such as **PlayerStats** has variables which are of the type Location. In those situations, which were numerous, we had to implement a unique encode/decode logic for saving and loading JSON files. The gist of our solution was to replace the actual object references to references to the object's ID. As such, when saving a game, the variables with the data type of other classes are not included, but instead, their replacements in the form of ID variables are included. When loading JSON, we are able to reconstruct the original "graph of objects" for further use using this method. The second main issue is stemming from the factory method design pattern, and it's interactions with the gson library. For gson to correctly write **NPC** abstract class to JSON format, we had to implement a custom class adapter for gson to use.  
The key challenges related to Assignment 3 implementation were revolving around the implementation of design patterns as we had to gain additional knowledge to be able to implement them. Additionally, both design patterns proved problematic to support them in save and load logic. When deciding on design patterns, we looked at the elements of our system in which they would naturally provide an alternative to our current approach. As such, we didn't only look at the places where particular design pattern could be implemented but more importantly, the areas in which they would prove useful. As such for our factory method design pattern we decided to go with our **NPC** class. Initially, we didn't have a clear vision as to the direction in which we'd like to take the enemies from the structural point of view. After analysing the existing classes and considering creating a separate, independent class, we've decided that it makes the most sense for enemies to be treated similarly to, at the time, our **NPC** class. From that moment onward when the question of where does the factory method belong in our system, it was clear to us that the division into friendly and enemy **NPC** is the most natural and desired separation. Before we had thought of implementing the second design pattern we had **Inventory** and **PlayerStats** be standard non-static classes. As part of our work on other parts of the implementation, we learned about the concept of singletons, and it became clear that those two classes shouldn't be standard non-static classes if there is only one instance of them at any point in time during runtime. As such we decided to turn them into singletons. The change itself was straightforward to implement; however, the save and load logic once again proved to be a difficulty. Due to the nature of instance variable, the saving process doubled the contents of any ArrayList. Additionally, it seems that our singleton classes are saved twice; however, we failed to come up with a solution in which there is no information loss during saving and loading.  
During the majority of our work on source work, we mostly manage to implement solutions from the first attempt without the need for system overhauls. However, there is one exception which is the input validation logic. The overarching idea was to analyse words one by one and try to segregate them such that we know which part of our system the word belongs. The shortcoming of this approach, which we failed to recognise early, was that certain elements of our storyline might be longer than one word. The most notable example of that are names of game elements. The workaround we implemented for that is that player can input the first word that is part of the game element's name and our system would then correctly assign it's intended meaning. However, this is less than the desirable implementation of the system due to its quirkiness and irrational input expectations from the user. The temporary solution put in place for our game was to categorise the game elements which would be called by their name through user input and change their names such that spaces are replaced by other characters such as underscore. Due to late realisation of this shortcoming, we were unable to redesign our input validation system to accommodate for names longer than one word. During the final debugging after the implementation of Meow Manor story, we realized that player is capable of soft locking themselves in the scenario in which to progress current level the player needs an item from the previous level. In the situation where the player does not have said item there currently is no way for them to go back to the previous level and retrieve it, effectively soft locking themselves.
  
The class needed for executing our system is found at: "\src\main\java\Main.java". This class is responsible for forwarding the initial program start-up method call to appropriate method within our front-end UI class. We believe it allows a person who looks at our source code for the first time to navigate through the chain of method calls easier.  
The fat jar can be found at: "\build\libs\software-design-vu-2020.jar". It is crucial never to relocate this file from its original location as that will result in loss of save files. Since the jar is write-only, we were unable to include save files, which are created dynamically during gameplay, as part of the jar executable.



Click image to watch short video of our game!
[![30sec Video Presentation](https://i.imgur.com/PnZiE5f.png)](https://youtu.be/ydla-xiwkoM)

> Word Count 1294/2000

## References

References, if needed.