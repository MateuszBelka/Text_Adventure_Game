# Assignment 1
## Introduction
Author: Taylor Doughty

   In this course, Software Design, we are going to be designing a text-based adventure game coded with Java. We will be using GitHub in order to collaborate while writing code, which will be synched to IntelliJ. For this system, we will be implementing game features along with satisfying quality requirements. As a main idea for developing our system, we are focused on dividing implementation of the features from the game logic. In doing so, the features of the game can act as a “blueprint” for game developers to create a game of their own. Therefore, the users of this project will be not only players, but also game developers.
   
The main idea of our game, is that it will be a single-player text adventure game in which a player can navigate through a series of rooms. The player will have the ability to interact with their environment in order to progress through the game. We will implement interactable objects in a way in which game developers may change and apply their own game logic easily.

To give a more detailed look at the exact features of the game, they are the following: The first feature is rooms. How this works, is that independently of the story, the player will always belong to a room, as they are the overacting system of the adventure game. The second feature is movement. The player will be able to move freely between the rooms, assuming that the rooms are interconnected and the storyline of the game allows them to do so. Concerning features available during the start-up of the game, they are the following three: The third feature is the ability to create a new game. When the game is first started-up, the user will have the option to start a new game, which allows the user to begin the first game save or to restart. Next, the fourth feature is the ability to continue a saved game. When the game is started-up, the user will also have the option to continue a previously started game, this way, they can carry-on with progress. The fifth feature is the option to be a game creator. What this means exactly, is that at the start-up of the game, the user will be able to create a new story, along with determining room configuration and information concerning each room. As for the sixth feature, concerning items, players will be informed about the possible items present in the room they are currently in. They will also have the ability to pick up items and place them in their inventory. Concerning items, that leads to the seventh feature. The players will be able to store these items in their inventory, and use them in the room in which they are currently in. Regarding saving progress of the game, there are two functionalities. The first being our eighth feature, in which the player will have the option to save current progress tied to the story they are playing. This will allow them to resume the game from the same position and same necessary information necessary to continue the game.There is also the feature of automatic saving, which is out ninth feature. The system will automatically save the player’s progress, and therefore the player will have the ability to access their latest saved information by selecting “continue” at the start menu. The ninth feature of the game is HP (health points). This feature indicates the level of health of a character, which then determines the ability to function and perform certain tasks in the game. HP can be lost due to attacks or starvation, and it can be restored by consuming food. The current HP value will be displayed along with the maximum HP possible as a numerical value on the screen. We also have determined three bonus features that should be implemented into our game. These bonus features are combat, experience,  hunger, and a GUI function feature, meaning an interface with buttons that players will be able to press in order to perform certain movements, actions, and use items.

When thinking of the features and design of our project, we were influenced by the game Zork. Primarily, the idea is that the protagonist adventures and explores a world, in which they can interact with objects and the world around them. Because the project is to be a “minimal clone” of the game, we also designed the features of the gameplay taking inspiration from the game. As for the display/appearance of the game, we have taken inspiration from a tutorial. 




Inspiration:  
[Zork](https://en.wikipedia.org/wiki/Zork)  
[How to Make Text Adventure Game with GUI in Java](https://www.youtube.com/watch?v=G5yr4sekAI0)

## Features
Author: Valeriya Komarnitskaya

<When defining both functional features and quality requirements, remember that you will need to come back to them in Assignments 2 and 3 and explicitly state how specific parts of models/implementation satisfy them.>

### Functional features

As a preamble to the table, you can discuss the main line of reasoning you applied for defining the functional features provided in the table.

| ID  | Short name  | Description  |
|---|---|---|
| F1  | Tags | Code snippets can be tagged via freely-defined labels called tags  |
| F2  | Commands  | The player can control the main character by issuing command-line commands following this syntax: `command-name [target-objects]*`. The available `command-names` are the following: <br/> - move: ... <br/> - use: ... <br/> - inspect: ... <br/> |
| F3  | Movements  | The main character shall move freely in the environment according  |
| F4  | ... | ... |

### Quality requirements
Author: Ece Doğaner

Reasoning followed for coming up with the quality requirements is mostly grounded on user-friendly interaction through terminal, ease of extendability of game, and basic system expectancies for a good gaming experience, in terms of system readiness and responsiveness. More detailed reasoning per quality feature is given in the 'Rationale' section.

| ID  | Short name  | Quality attribute | Description and Rationale | Rationale |
|---|---|---|---|---|
| QR1  | Commands known to user | Understandability/Usability  | At all times, game shall show which directions are possible to move towards. Objects present in inventory shall always be visible. Users shall see at all times which features they can use. | This feature helps users understand which actions and command combinations are possible. |
| QR2  | Undo move | Understandability | Game shall record visited locations, and be able to go to previously visited locations. | This feature helps users with orientation in text-based world. |
| QR3  | Extensible world | Maintainability/Reusability  | The game shall be easily extendable in terms of levels, worlds, and objects. | This feature helps expand the game easily, and makes game code less complex. |
| QR4  | Instantaneous results | Responsiveness | The game shall respond to any action the player performs, within 1 second. | This feature adds to the gaming experience. |
| QR5  | Game saved automatically | Reliability | When restarting game, game shall load in current location, shall load inventory, and previously visited locations. This information will be saved when it is performed, so that a possible crash will not result loss of data. There will be a setting to reset the game completely, in order to begin from scratch. | This feature fulfills expectancy of users to continue game where left off. |
| QR6  | Ready for input | Availability | Game shall be ready at all times for input of the user. | This adds to the gaming experience. |
| QR7  | All actions lead to result | Reliability | As game shows possible interactions, all possible user actions shall lead to a response from the game. | This adds to the gaming experience, as features behave in the intended manner. |
| QR8  | Security through limited interaction | Security / Usability | Game terminal shall be designed in such a way that data is not able to be manipulated other than how it is intended through user actions. Game actions shall be simplified by using clickable buttons. Game should also make possible to use arrows on keyboard to move. | This feature, opposed to a command line interface, protects game from possible misuse through actions. Also, the less error messages are shown, the smoother the gaming experience will be. |

### Java libraries
Author: Mateusz Belka

| Name (with link) | Description  |
|---|---|
| [Gradle](https://gradle.org/) | Our project, as well as the majority of projects in Java, make extensive use of libraries and frameworks. Thus, it is necessary to have a method of dependency management to allow developers to focus on designing the software itself and not manage the tools. Gradle provides such support, and therefore we use it to simplify the process of using pre-existing tools to aid our sophisticated design. |
| [FXGL](https://almasb.github.io/FXGL/) | As opposed to bash terminal CLI, we choose to utilize a GUI widget toolkit due to it's more user-friendly interface as well as additional graphical functionality which hopefully will allow the user to have more enjoyable interface experience. Additionally, GUI provides a more stable executable version of software since it's independent of users terminal. On top of that default terminals tend to frighten novice computer users. JavaFX is more preferential than similar libraries such as Lanterna due to more advanced and accessible documentation. Additionally, the proposed GUI libraries all provide the same functionality for our limited needs, and therefore it makes sense to select the one which is the most straightforward in implementation. The final version of GUI aims to represent a variation of terminal-based UI. |
| [JDSL](https://cs.brown.edu/cgc/jdsl/) | Due to the nature of our project, specific data structures will be necessary to maintain information about the state of the game comprehensively and transparently. It is possible to have such an outcome only in a scenario where proper data structures are utilized. As such, we will be making use of java library specifically created to provide an extensive choice of data structures we can tailor specifically to our needs. |
| [Time4J](https://github.com/MenoData/Time4J) | Time management will be necessary as part of the hunger system. This management will be aided by Time4J library. |
