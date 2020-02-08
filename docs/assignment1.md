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
| Gradle | Our project, as well as the majority of projects in Java, make extensive use of libraries and frameworks. Thus, it is necessary to have a method of dependency management to allow developers to focus on designing the software itself and not manage the tools. Gradle provides such support, and therefore we use it to simplify the process of using pre-existing tools to aid our sophisticated design. |
| JavaFX | As opposed to bash terminal CLI, we choose to utilize a GUI widget toolkit due to it's more user-friendly interface as well as additional graphical functionality which hopefully will allow the user to have more enjoyable interface experience. Additionally, GUI provides a more stable executable version of software since it's independent of users terminal. On top of that default terminals tend to frighten novice computer users. JavaFX is more preferential than similar libraries such as Lanterna due to more advanced and accessible documentation. Additionally, the proposed GUI libraries all provide the same functionality for our limited needs, and therefore it makes sense to select the one which is the most straightforward in implementation. |
| JDSL | Due to the nature of our project, specific data structures will be necessary to maintain information about the state of the game comprehensively and transparently. It is possible to have such an outcome only in a scenario where proper data structures are utilized. As such, we will be making use of java library specifically created to provide an extensive choice of data structures we can tailor specifically to our needs. |

Maximum number of words for this section: 500
