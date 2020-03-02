# Assignment 1
Maximum number of words for this document: 2500
## Introduction
Author: Taylor Doughty





Inspiration:

[Zork](https://en.wikipedia.org/wiki/Zork)

[How to Make Text Adventure Game with GUI in Java](https://www.youtube.com/watch?v=G5yr4sekAI0)

## Features
Authors: Valeriya Komarnitskaya, Mateusz Belka, Ece Doganer

### Functional features

Core Features:

| ID | Short name | Description | Rationale |
|---|---|---|---|
| F1 | Room | Independently from the story, the player shall always belong to an individual room. Each story has its room configuration, which is a list connected of rooms in terms of how the player can move between them. | Division of locations, such as rooms allows for clear communication between structural elements of the game logic. Moreover, it allows user to get familiar with the core concepts of the game from which all other features branch out from. |
| F2 | Movement | The player shall have the choice to move freely between rooms that are interconnected and story-related. | The progression of the story is crucial to our game because it incentivizes user to continue playing. Ability to move between rooms allows a story creator to create a compelling and complex story that would otherwise not be achievable. |
| F3 | New Game | At the start of the game the user shall have the option to start a new game. That allows the user to begin the first game or restart his/her progress and begin anew. | Providing a user-friendly interface to start a new game is crucial. It also allows the user to restart the game conveniently. |
| F4 | Continue Game | At the start of the game the user shall have the option to continue previously started, automatically saved game. That allows the user to carry on with already achieved progress. | We aim to support complex and unique stories; thus, they might not be completed during one session. Giving the user the ability to decide how long each session will create a positive user experience. |
| F5 | Items | The player shall be informed about the possible items present in the room he/she is currently in. The player shall have the option to pick up those items and place them in the inventory. | Puzzle-solving is a crucial part of progression in adventure games, so our goal is to implement an item system that is intuitive and fun to use by players. |
| F6 | Inventory | The player shall have the option of picking up items, storing them in inventory and using them in the room that the player is currently in. | We aim to provide users with high quality and intuitive inventory system that fully supports meaningful and challenging use of items to solve puzzles. |

Bonus Features 

| ID | Short name | Description | Rationale |
|---|---|---|---|
| F7 | Health Points/HP | Health points are indicating the level of health of a character and determine the ability to function. Health value can be lost due to attack by an enemy or through starvation, and restored by consuming food. | Including health points in a game is essential to implement combat or hunger features. These features together add a sense of danger, exciting challenges and make a gameplay experience more enjoyable. |
| F8 | Combat | A battle against an enemy until a player will die or defeat an opponent. A chance of receiving items after defeating an enemy. A player might be able to receive special weapons. The player will be able to use those weapons in combat in order to increase the probability of win and decrease the time of the battle. | Combat system presents another level of depth to our TAG. It allows the player to have unique challenges and progress in a different manner in comparison to puzzle-solving. |
| F9 | Experience points/XP | Numerical measurement indicating the experience of the character. Through successful puzzle-solving and defeating enemies, a character gains points. Experience points' collection leads to a level upgrade. | Implementing XP in our game is essential to include an additional feature such as a level upgrade. Thus, a player will have a larger motivation to gain experience and upgrade a level. |
| F10 | Levelling | The level is a numerical value indicating the level you are at. Through successful puzzle-solving and defeating enemies, a character gains XP. After getting a certain amount of points, it shall be possible to level up. | Adding levelling feature will create additional challenges and will motivate his/her to level up in the game. The feature will make our TAG more interesting and attractive to a player. |

### Quality requirements
Author: Ece Doganer

| ID | Short name | Quality attribute | Description | Rationale | Alternatives |
|---|---|---|---|---|---|
| QR1 | Extensible World | Maintainability, Reusability | System shall be extensible in terms of levels, rooms, and objects. | Adaptability: code is less complex, less reliant on storyline, more adaptable to different stories. | A system designed for one unique story-line. |
| QR2 | Instantaneous results | Responsiveness, Reliability | System shall respond to any action player performs, within 1 second. If action is impossible, input is unclear, there should be a message. | Expected from software experience: instant results. Also, requirement signals response time to user, thus indicating error. | Long waiting times in game. Coding without speed in mind, resulting in loading messages. |
| QR3 | Ready for input | Availability | System shall show full story immediately, and be ever-ready for input. | Users have their own speed of reading. User’s desire for system's readiness for input is connected to desire for immediate output. | Story-based text shown in increments, helping readers read along the intentions/pacing of story. Our system shall show story-text immediately, signaling input-readiness when screen is printed. If user intends to move north 12 steps, there is no delay. |
| QR4 | Bonus: Help Orientate | Understandability | All rooms should have a clear name. The backtrack feature helps users orientate in text-based world. System should record visited locations, and through backtrack-button go to previously visited locations. The map of the level, shows previously visited, clickable rooms (teleporting). | Users can get lost in text-adventure games, or forget which room needed which item. Our aim is to make orientation easier. | Backtrack feature is a bad solution if user backtracks big amount of steps, and has to return to furthest room. Alternative is a graphical map of visited rooms. Human brains have limited memory space, thus it is more useful to see previous rooms a few steps back than all visited rooms combined (think big levels). Thus, our first priority is the backtrack feature, and then visual map. |
| QR5 | Bonus: Natural Language Parsing | Understandability, Usability | CLI input should function with natural language form. Input string should be segmented into words. Input is valid iff: input is a valid direction in current room, is an existing item in the room that needs to be "used", or are two existing items where one is in the inventory, and the other is an item in the room that cannot be picked up, and requires an item to solve a puzzle. | Game should be immersive and playable for any human mastering basic English (and typing skill). | 1. Console-like commands. Not user-friendly, and requires user to learn before playing. Game should be intuitive, should give cognitive space for storyline immersion. 2. QR6. |
| QR6 | Bonus: GUI | Understandability, Usability, Security | Through graphical user interface, player immediately, intuitively sees which actions at current location can be performed. (Movement buttons should highlight when movable. Inventory would be graphically represented by a table, with scroll-buttons indicating infinite item-space. If Hint-feature is on, items should be sorted to usability in current room, and highlighted if usable.) Use of GUI, enabling user to see which actions can be performed at present location, will lessen error messages received from basic actions (movement, inventory actions), permitting user to spend cognitive effort on the story. | Qualitative games are intuitive and immersive. GUI solves issues of CLI: 1. Cognitive overload of user through error messages received for basic actions. 2. Security of game: predefined buttons can only be clicked. If error arises, it is not due to misuse of CLI by user. 3. User orientation should be better than with words. 4. GUI  visually explains rules of game, while CLI does not. | Error messages from CLI solved by storyline jokes (not a technical, extensible solution). |

### Java libraries
Author: Mateusz Belka

| Name (with link) | Description |
|---|---|
| [Gradle](https://gradle.org) | Our project, as well as the majority of projects in Java, make extensive use of libraries and frameworks. Thus, it is necessary to have a method of dependency management to allow developers to focus on designing the software itself and not manage the tools. Gradle provides such support, and therefore we use it to simplify the process of using pre-existing tools to aid our sophisticated design. |
| [Text-IO](https://github.comberyxtext-io) | Users interact with their computers in widely different manners. Therefore, a part of them has very limited knowledge of the capabilities of their operating system. As such in order not to force users into launching our game from terminal, which many users may be unfamiliar with, our goal is provide an executable file that can be launched by just clicking on it. In a default situation attempting to do that would result in nothing happening as console input and output calls would be ignored without terminal being present. However, our intention is for our game to open in custom third-party swing terminal in scenarios where the game is not already being launched through one. Such terminal would naturally integrate with java.io.Console calls. |
| [JOpt Simple](https://jopt-simple.github.iojopt-simple) | Our aim is to allow users to communicate with our system using natural language form. In order to achieve this the users input has to be parsed. We intend to utilize this library to maintain high quality readable input parsing code which executes highly complicated tasks behind the scene. |
| [JDSL](https://cs.brown.educgcjdsl) | Due to the nature of our project, specific data structures will be necessary to maintain information about the state of the game comprehensively and transparently. It is possible to have such an outcome only in a scenario where proper data structures are utilized. As such, we will be making use of java library specifically created to provide an extensive choice of data structures we can tailor specifically to our needs. |
| [Time4J](https://github.comMenoDataTime4J) | Time management will be necessary as part of the hunger system. This management will be aided by Time4J library. |
| [FXGL](https://almasb.github.ioFXGL) | As part of bonus feature we aim to implement a GUI widget toolkit instead of CLI due to it's more user-friendly interface as well as additional graphical functionality which hopefully will allow the user to have more enjoyable interface experience. Additionally, GUI provides a more stable executable version of software since it's independent of users terminal. On top of that default terminals tend to frighten novice computer users. JavaFX is more preferential than similar libraries such as Lanterna due to more advanced and accessible documentation. Additionally, the proposed GUI libraries all provide the same functionality for our limited needs, and therefore it makes sense to select the one which is the most straightforward in implementation. The final version of GUI aims to represent a variation of terminal-based UI. |