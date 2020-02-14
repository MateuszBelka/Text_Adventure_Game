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

Reasoning followed for the quality requirements is mostly grounded on user-friendly interaction through terminal, basic system expectancy for a good gaming experience, all while considering the extendability of the game. More detailed reasoning per quality requirement is given in the 'Rationale' section.

| ID | Short name | Quality attribute | Description | Rationale | Alternatives |
|---|---|---|---|---|---|
| QR1 | NLP | Understandability, Usability | Input on the command line shall function with natural language form as much as possible. | Game should be immersive and playable for any human mastering basic English and some typing skill. | 1. Console-like commands. Not user-friendly, and requires user to learn before playing. Game should be intuitive, and should immediately give cognitive space for storyline immersion. 2. See bonus QR6: GUI |
| QR2 | Extensible World | Maintainability, Reusability | The game shall be easily extensible in terms of levels, rooms, and objects. | As we are making a sort of game backbone tool to fit different stories, this requirement focuses on adaptability in general, makes game code less complex and less reliant on storyline, and more adaptable to different stories. | Alternatives: A system designed for one unique story-line. Or a system designed for  |
| QR3  | Instantaneous results | Responsiveness, Reliability | The game shall respond to any action the player performs, within 1 second. If action is not possible, input is not understood, or there is some delay in our 1 second responsiveness rule (ex. big amount of items to check through), there will be a message. | This feature is expected from any software experience: instant results. Secondly, this requirement signals that user can expect the game to respond. This signaling could be beneficial in case there is a big crash or grand error. | Alternatives: User would not like loading messages, while game has crashed. |
| QR4 | Ready for input | Availability | Game shall show full story immediately, and be ever ready for input. | Users have their own speed of reading. User desire for system's readiness for input is connected to desire for immediate output. | Alternatives: Some games prefer story-based text to be shown in increments, helping readers read along the intentions and pacing of the story. Our game will show all information immediately. In this way, we signal that input is possible when loading screen is possible. If user intends to move north 12 steps, there won't be a delay like waiting for printing story text to terminal. |
| QR5 | Help user orientate | Understandability | All rooms will have a clear name. The backtrack feature helps users orientate in text-based world. Game shall record visited locations, and through backtrack-button go to previously visited locations. A bonus feature we might implement is a map of the level, which shows previously visited rooms, which are click-able (a sort of teleport function). | Reasoning is that users can easily get lost in rooms full of text, or forget which room needed which item. Our aim is to make orientation in text-based games, easier. | This backtrack feature would be a bad solution if the user needs to backtrack a big amount of steps, and then return to furthest room. Or backtracking through teleporting (bonus map feature) might be confusing. Alternative is a visual map of visited rooms. For our game to be truly extensible(think big amount of rooms), it is more useful to see previous rooms of a few steps back than all the visited rooms combined. (Thus, we picked backtrack feature first, and visual map as bonus feature). |
|QR6| BONUS : GUI | Understandability, Usability, Security | Through a graphical user interface, player can immediately and intuitively see which actions at the current place can be performed. (Movement buttons can be highlighted when they are able to be performed. Inventory would be visually represented by a table, with buttons to indicate its infiniteness and scrollability. If the bonus hint feature is toggled on, items will be sorted to usability in the current room, and highlighted if they can be used.) The use of a GUI, enabling user to see which actions can be performed at present time, will nullify error messages received from basic actions (movement, inventory actions), permitting user to spend their effort on the story. | A qualitative game is intuitive and immersive. GUI solves issues of CLI: Firstly, cognitive overload of user through error messages received for basic actions. Secondly, security of game: predefined buttons can only be clicked. We provide visual clue of buttons that work at current room. If an error arises, it is not due to misuse of CLI by user. Thirdly, user orientation should be better than with words. And finally, GUI visually explains how to play the game. CLI would need to explain rules for playing. | Alternatives: CLI : error messages telling the user what isn't possible, resulting in possible frustration and bad gaming experience. There are games that solve this by storyline jokes or one-liner jokes on what the user is intending to do. But that would be a story-line based solution per action taken, not a technical, extensible solution. |

Word Count: 804

### Java libraries
Author: Mateusz Belka

| Name (with link) | Description  |
|---|---|
| [Gradle](https://gradle.org/) | Our project, as well as the majority of projects in Java, make extensive use of libraries and frameworks. Thus, it is necessary to have a method of dependency management to allow developers to focus on designing the software itself and not manage the tools. Gradle provides such support, and therefore we use it to simplify the process of using pre-existing tools to aid our sophisticated design. |
| [FXGL](https://almasb.github.io/FXGL/) | As opposed to bash terminal CLI, we choose to utilize a GUI widget toolkit due to it's more user-friendly interface as well as additional graphical functionality which hopefully will allow the user to have more enjoyable interface experience. Additionally, GUI provides a more stable executable version of software since it's independent of users terminal. On top of that default terminals tend to frighten novice computer users. JavaFX is more preferential than similar libraries such as Lanterna due to more advanced and accessible documentation. Additionally, the proposed GUI libraries all provide the same functionality for our limited needs, and therefore it makes sense to select the one which is the most straightforward in implementation. The final version of GUI aims to represent a variation of terminal-based UI. |
| [JDSL](https://cs.brown.edu/cgc/jdsl/) | Due to the nature of our project, specific data structures will be necessary to maintain information about the state of the game comprehensively and transparently. It is possible to have such an outcome only in a scenario where proper data structures are utilized. As such, we will be making use of java library specifically created to provide an extensive choice of data structures we can tailor specifically to our needs. |
| [Time4J](https://github.com/MenoData/Time4J) | Time management will be necessary as part of the hunger system. This management will be aided by Time4J library. |
