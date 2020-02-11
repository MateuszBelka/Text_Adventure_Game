# Assignment 1
Maximum number of words for this document: 2500


## Introduction									
Author: Taylor Doughty

Write a short description of your version of the system you are going to design and implement in this course.
Clearly specify which are the key aspects of your system, such as:
- customizations/extensions w.r.t. the project track,
- main type of user(s)
- overall idea about how it works
- ...

Be creative here!

Don’t forget to use links to external URLs (e.g., the direct link to the Fantasy soccer league you are getting inspiration from, the link to the original video game you are getting inspiration from, etc.), if applicable.

Maximum number of words for this section: 1000

## Features
Author: Valeriya Komarnitskaya

<When defining both functional features and quality requirements, remember that you will need to come back to them in Assignments 2 and 3 and explicitly state how specific parts of models/implementation satisfy them.>

### Functional features

#####Core Features Note:(use "shall" instead of "should")

| ID  | Short name  | Description  |  Rationale |
|---|---|---|---|
| F1 | Room | Rooms are the overarching system in our variation of the text adventure game. Independently of story, the player shall always belong to an individual room. Each story has it's own room configuration which is a list of rooms which are connected in terms of how the player can move between them. | Rooms allow for a precise organization of fundamental part of any text adventure game which is exploration. Division of locations which the player can inhabit into rooms allows for clear communication between structural elements of the game logic. From gameplay perspective is allows user to get familiar with the core concepts of the game from which all other features branch out from. |
| F2 | Movement | The player shall have the choice to move freely between rooms as long as those rooms are interconnected and possible story-related requirements are met. | The progression of the story is crucial to our game as we believe it incentivizes user to continue playing. Ability to move between rooms gives the story creator the means to create a compelling and complex story that would otherwise not be achievable. |
| F3 | New Game | At the start of the game the user shall have the option to start a new game. That allows the user to begin the first game or restart his/her progress and begin anew. | providing a user-friendly interface to start a new game is crucial. It also allows the user to conveniently be able to restart the game if the player desires so. |
| F4 | Continue Game| At the start of the game the user shall have the option to continue previously started game. That allows the user to carry on with already achieved progress. | We aimed to support complex and unique stories, and as such, they might not be completed during one session. Giving the user the ability to decide how long each session will create a positive user experience. |
| F5 | Game Creator | At the start of the game, our product shall allow the user to create new stories. That includes determining room configuration and information about each room. | As part of our support for adaptability for new stories, we've decided to provide on top of easily changeable stories an easily accessible GUI that allows users without required technical knowledge to be to able to create their own story. |
| F6 | Items | The player shall be informed about the possible items present in the room he/she is currently in. The player shall have the option to pick up those items and place them in the inventory. | Puzzle-solving is crucial part o progression in adventure games, so our goal is to implement an item system that is intuitive and fun to use by players. |
| F7 | Inventory | The player shall have the option of picking up items, storing them in inventory and using them in the room that the player is currently in. | Puzzle-solving is a crucial part of progression in adventure games. As such, we want to provide users with high quality and intuitive inventory system that fully supports meaningful and challenging use of items to solve puzzles. |
| F8 | Explicit Save | The player shall have the option to save current progress tied to the story she/he is playing at the moment. That will include all necessary information needed to resume the game at a later point after the game executable is opened again. | The ability to have an explicit button for saving tends to give players a relaxing feeling. From our personal experience, we've noticed people generally tend to not trust automatic save systems and depend on their action of saving the game. |
| F9 | Automatic Save| The system shall automatically save the player's progress. The player shall automatically have access to the latest saved information by selecting "Continue" at the start menu. | Novice users tend to go to another extreme of never saving their progress and afterwards regret not saving. To avoid such issues, we decided to implement autosave feature as part of our quality of life improvements for users. |


#####Bonus Features Note:(instead of "shall" use "should")

| ID  | Short name  | Description  |  Rationale |
|---|---|---|---|
| F10 | health | placeholder | placeholder |
| F11 | combat | placeholder | placeholder |
| F12 | experience | placeholder | placeholder |
| F13 | hunger | placeholder | placeholder |

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
