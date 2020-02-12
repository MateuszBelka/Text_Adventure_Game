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
Author: Valeriya Komarnitskaya, Mateusz Belka, Ece Doganer

<When defining both functional features and quality requirements, remember that you will need to come back to them in Assignments 2 and 3 and explicitly state how specific parts of models/implementation satisfy them.>

### Functional features

**Core Features** Note:(use "shall" instead of "should")

| ID  | Short name  | Description  |  Rationale |
|---|---|---|---|
| F1 | Room | Rooms are the overarching system in our variation of the text adventure game. Independently from the story, the player shall always belong to an individual room. Each story has its own room configuration which is a list of rooms which are connected in terms of how the player can move between them. | Rooms allow for a precise organization of fundamental part of any text adventure game which is exploration. Division of locations which the player can inhabit into rooms allows for clear communication between structural elements of the game logic. From gameplay perspective is allows user to get familiar with the core concepts of the game from which all other features branch out from. |
| F2 | Movement | The player shall have the choice to move freely between rooms as long as those rooms are interconnected and possible story-related requirements are met. | The progression of the story is crucial to our game as we believe it incentivizes user to continue playing. Ability to move between rooms gives the story creator the means to create a compelling and complex story that would otherwise not be achievable. |
| F3 | New Game | At the start of the game the user shall have the option to start a new game. That allows the user to begin the first game or restart his/her progress and begin anew. | providing a user-friendly interface to start a new game is crucial. It also allows the user to conveniently be able to restart the game if the player desires so. |
| F4 | Continue Game| At the start of the game the user shall have the option to continue previously started game. That allows the user to carry on with already achieved progress. | We aim to support complex and unique stories, and as such, they might not be completed during one session. Giving the user the ability to decide how long each session will create a positive user experience. |
| F5 | Game Creator | At the start of the game, our product shall allow the user to create new stories. That includes determining room configuration and information about each room. | As part of our support for adaptability for new stories, we've decided to provide on top of easily changeable stories an easily accessible GUI that allows users without required technical knowledge to be to able to create their own story. |
| F6 | Items | The player shall be informed about the possible items present in the room he/she is currently in. The player shall have the option to pick up those items and place them in the inventory. | Puzzle-solving is crucial part o progression in adventure games, so our goal is to implement an item system that is intuitive and fun to use by players. |
| F7 | Inventory | The player shall have the option of picking up items, storing them in inventory and using them in the room that the player is currently in. | Puzzle-solving is a crucial part of progression in adventure games. As such, we want to provide users with high quality and intuitive inventory system that fully supports meaningful and challenging use of items to solve puzzles. |
| F8 | Explicit Save | The player shall have the option to save current progress tied to the story she/he is playing at the moment. That will include all necessary information needed to resume the game at a later point after the game executable is opened again. | The ability to have an explicit button for saving tends to give players a relaxing feeling. From our personal experience, we've noticed people generally tend to not trust automatic save systems and depend on their action of saving the game. |
| F9 | Automatic Save| The system shall automatically save the player's progress. The player shall automatically have access to the latest saved information by selecting "Continue" at the start menu. | Novice users tend to go to another extreme of never saving their progress and afterwards regret not saving. To avoid such issues, we decided to implement autosave feature as part of our quality of life improvements for users. |


**Bonus Features** Note:(instead of "shall" use "should")

| ID  | Short name  | Description  |  Rationale |
|---|---|---|---|
| F10 | health | placeholder | placeholder |
| F11 | combat | placeholder | placeholder |
| F12 | experience | placeholder | placeholder |
| F13 | hunger | placeholder | placeholder |
| F12 | hints | - highlights which item can be used in room. is toggle button so players can decide if they want an easier type of game | placeholder |

### Quality requirements
Author: Ece Doğaner

Reasoning followed for the quality requirements is mostly grounded on user-friendly interaction through terminal, basic system expectancies for a good gaming experience, all while considering the extendability of the game. More detailed reasoning per quality requirement is given in the 'Rationale' section.

|ID| Short name | Quality attribute | Description | Rationale | Alternatives |
|---|---|---|---|---|---|
|QR1| GUI: All actions are known to user | Understandability, Usability  | At all times, game shall show all possible actions able to perform at the current location. Actions consist of movement, and inventory actions. Indicating a possible movement towards a direction, (ex. buttons with highlighting valid movement, lowlighting invalid movement) indicates to the player which rooms are connected to the current room the player is in, intuitively. Inventory actions consist of scrolling through the table-shaped inventory, and using an object by clicking on it. | The rationale behind a buttoned GUI is user-friendly interaction, by explaining without words how the rules of the game work. The user should spend cognitive load on the game story, and as less as possible on how to play the game. | 1. We have considered a CLI for users to perform actions. Our reasoning not to do it was that it would be coder-friendly, but not user-friendly to play a game where you might misspell actions. This would cause needless frustration for the user, having to check their own spelling as well as receiving multiple error messages in a row. 2. We have considered showing the inventory as a list of items currently in the inventory, opposed to designated spaces for items in the inventory box,that might be empty. Our reasoning is that it would be messy if your list of items is very large (extensible world QR), and that tables in general give more overview than a list with differently sized words. Also, the inventory has scrolling buttons, indicating that the space for items will grow infinitely, depending on how many items the player finds in the world. This would explain the player that there is no dropping function for items: you can hold an item until it is used. |
| QR2 | GUI: Security through limited interaction | Security | Game terminal shall be designed to disallow data to be manipulated, other than how it is intended through user actions. | Protecting game by limiting the user to clicking predefined actions makes sure that there won't be overlooked misuse of a CLI that could cause errors. Also, the less error messages are shown, the smoother the gaming experience will be. | Alternatives: messy CLI inputs, error messages for basic moving. (If hint function (bonus) is implemented, there won't be error messages for moving nor item use. |
| QR3 | Backtrack | Understandability | This feature helps users orientate in text-based world. Game shall record visited locations, and through backtrack-button go to previously visited locations. | Reasoning is to make it easier to backtrack a few steps back, in case the user forgets which direction the previous room was. In practice, it might become easier to find a previously visited room, when user was missing an item. | This interpretation would be a bad solution if the user needs to backtrack a big amount of steps, and then return to furthest room. Alternative is a visual map of visited rooms. We did not go this route due to time restrictions, as well as not being able to indicate the previous few rooms (only rooms visited, thus orientation). For our game to be truly extensible(n rooms), it is more useful to see previous rooms of a few steps back than all the visited rooms combined. (Visual map could be bonus feature). |
| QR4 | Extensible world | Maintainability, Reusability | The game shall be easily extendable in terms of levels, worlds, and objects. | As we are making a type of game tool to fit different stories, this feature helps expand the game easily, makes game code less complex, and more adaptable to different stories. | Alternatives: none. |
| QR5  | Instantaneous results | Responsiveness | The game shall respond to any action the player performs, within 1 second. If action is not possible (if item cannot be used in current room), there will be an error message. If user has many items, causing delay in our 1 second responsiveness rule, then a message will be shown. | In general this feature is expected from any software experience: instant results. Secondly, this feature signals that user can expect the game to respond. This signaling could be beneficial in case there is a big crash or grand error. | Alternatives: none. |
| QR6 | All actions lead to immediate result / reply | Reliability | As game shows all possible interactions, all actions shall lead to a response from the game. In terms of item misuse, it will result in an error. If hints toggle feature will be implemented (bonus), there will be no errors shown for movement and inventory actions. | Signals what can be expected. | Alternatives: error messages telling the user what isn't possible, bad gaming experience. There are games that solve this by storyline jokes or one-liner jokes on what the user is intending to do. But that would be a story-line based solution, and not a technical one. |
| QR7 | Ready for input | Availability | Game shall show full story immediately, and be ever ready for input. | This adds to the gaming experience, as users have their own speed of reading. Readiness for input is connected to immediate output. | Alternatives: Some games prefer story-based text to be shown in increments, helping readers read along the intentions and pacing of the story. Our actions are always visible, as well as our story-line per room. In this way, we signal that input is possible at any moment. If user intends to move north 12 steps, there won't be a delay. |

### Java libraries
Author: Mateusz Belka

| Name (with link) | Description  |
|---|---|
| [Gradle](https://gradle.org/) | Our project, as well as the majority of projects in Java, make extensive use of libraries and frameworks. Thus, it is necessary to have a method of dependency management to allow developers to focus on designing the software itself and not manage the tools. Gradle provides such support, and therefore we use it to simplify the process of using pre-existing tools to aid our sophisticated design. |
| [FXGL](https://almasb.github.io/FXGL/) | As opposed to bash terminal CLI, we choose to utilize a GUI widget toolkit due to it's more user-friendly interface as well as additional graphical functionality which hopefully will allow the user to have more enjoyable interface experience. Additionally, GUI provides a more stable executable version of software since it's independent of users terminal. On top of that default terminals tend to frighten novice computer users. JavaFX is more preferential than similar libraries such as Lanterna due to more advanced and accessible documentation. Additionally, the proposed GUI libraries all provide the same functionality for our limited needs, and therefore it makes sense to select the one which is the most straightforward in implementation. The final version of GUI aims to represent a variation of terminal-based UI. |
| [JDSL](https://cs.brown.edu/cgc/jdsl/) | Due to the nature of our project, specific data structures will be necessary to maintain information about the state of the game comprehensively and transparently. It is possible to have such an outcome only in a scenario where proper data structures are utilized. As such, we will be making use of java library specifically created to provide an extensive choice of data structures we can tailor specifically to our needs. |
| [Time4J](https://github.com/MenoData/Time4J) | Time management will be necessary as part of the hunger system. This management will be aided by Time4J library. |
