# Assignment 3

Maximum number of words for this document: 18000

**IMPORTANT**: In this assignment you will fully model and implement your system. The idea is that you improve your UML models and Java implementation by (i) applying (a subset of) the studied design patterns and (ii) adding any relevant implementation-specific details (e.g., classes with “technical purposes” which are not part of the domain of the system). The goal here is to improve the system in terms of maintainability, readability, evolvability, etc.    

**Format**: establish formatting conventions when describing your models in this document. For example, you style the name of each class in bold, whereas the attributes, operations, and associations as underlined text, objects are in italic, etc.

### Summary of changes of Assignment 2
Author(s): Ece Doganer

- For A1 and A2 phase, we had received heavy feedback on our functional features list, and quality requirements. This is now revised in full detail. We now have a total of 43 features. A big portion of it, are instructions and their issued game mechanics. Multiple features the TA has stated missing, are now described. Some QR are moved to features. A better distinction is made between core and bonus features. In general, more detail and care is added to explain our multitude of features.
- Pickupable Items and Static items is fully revised according to TA's feedback. These classes are changed into one Item class. This Item class has 'traits' per object, so an item might be pickup-able or immovable.
- Input Validation is fully revised, according to TA's feedback. Also, is divided into multiple classes with different responsibilities. Enumeration is used. Multiple instructions in one input, is not followed through, as suggested. Use of trigger words is described in detail, in A1.
- Player class is broken up into multiple classes with different responsiblities, according to TA's feedback.
- Initializer class is broken up into multiple classes with different responsiblities, according to TA's feedback.
- Level class is broken up into multiple classes with different responsiblities, according to TA's feedback.
- We have renamed Room class with Location class.
- We have changed the way 'puzzles' are solved. Previously, there were only two ways of solving a puzzle: interacting with a static item by writing its name, or, using a pickupable item on a static item, by writing both their names on the terminal. The idea there, was that our GUI would be clickable, thus player didn't need to ever type anything. We have moved away from this idea. Firstly, TA did not like it. Secondly, the broad experience that Zork gives, through making multiple command available, was not respected. Our new approach is to have a combination of trigger words, as described in A1. Solving puzzles can now be a multitude of interactions. See A1's Puzzles feature for a description.
- Game class is deleted, and its contents and responsibilities have been moved, partly to GameProgression, which deals with level and puzzle progress.
- Following the Zork-clone train of thought, our output is revised. We now print level description and location description, with the items and npcs descriptions in this location, once. Then, these descriptions can be asked again. Also, performing valid interactions now prints a specific description for that interaction with that entity (item or npc).
- Items and NPCs have an abstract class, Entity. Their common attributes and resulting methods, are shared.
- All diagrams are updated.
- All descriptions of those diagrams are updated. 

### Application of design patterns
Author(s): `name of the team member(s) responsible for this section`

`Figure representing the UML class diagram in which all the applied design patterns are highlighted graphically (for example with a red rectangle/circle with a reference to the ID of the applied design pattern`

For each application of any design pattern you have to provide a table conforming to the template below.

| ID  | DP1  |
|---|---|
| **Design pattern**  | Name of the applied pattern |
| **Problem**  | A paragraph describing the problem you want to solve |
| **Solution**  | A paragraph describing why with the application of the design pattern you solve the identified problem |
| **Intended use**  | A paragraph describing how you intend to use at run-time the objects involved in the applied design patterns (you can refer to small sequence diagrams here if you want to detail how the involved parties interact at run-time |
| **Constraints**  | Any additional constraints that the application of the design pattern is imposing, if any |
| **Additional remarks**  | Optional, only if needed |

Maximum number of words for this section: 2000

## Class diagram									
Author(s): `name of the team member(s) responsible for this section`

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

`Figure representing the UML class diagram`
  
As opposed to assignment 2, for assignment 3 we were able to prepare fully functional game and surrounding storyline. As such, new 

> Word Count 0/1000

## State machine diagrams									
Author(s): `name of the team member(s) responsible for this section`

This chapter contains the specification of at least 2 UML state machines of your system, together with a textual description of all their elements. Also, remember that classes the describe only data structures (e.g., Coordinate, Position) do not need to have an associated state machine since they can be seen as simple "data containers" without behaviour (they have only stateless objects).

For each state machine you have to provide:
- the name of the class for which you are representing the internal behavior;
- a figure representing the part of state machine;
- a textual description of all its states, transitions, activities, etc. in a narrative manner (you do not need to structure your description into tables in this case). We expect 3-4 lines of text for describing trivial or very simple state machines (e.g., those with one to three states), whereas you will provide longer descriptions (e.g., ~500 words) when describing more complex state machines.

The goal of your state machine diagrams is both descriptive and prescriptive, so put the needed level of detail here, finding the right trade-off between understandability of the models and their precision.

Maximum number of words for this section: 4000

## Sequence diagrams									
Author(s): `name of the team member(s) responsible for this section`

This chapter contains the specification of at least 2 UML sequence diagrams of your system, together with a textual description of all its elements. Here you have to focus on specific situations you want to describe. For example, you can describe the interaction of player when performing a key part of the videogame, during a typical execution scenario, in a special case that may happen (e.g., an error situation), when finalizing a fantasy soccer game, etc.

For each sequence diagram you have to provide:
- a title representing the specific situation you want to describe;
- a figure representing the sequence diagram;
- a textual description of all its elements in a narrative manner (you do not need to structure your description into tables in this case). We expect a detailed description of all the interaction partners, their exchanged messages, and the fragments of interaction where they are involved. For each sequence diagram we expect a description of about 300-500 words.

The goal of your sequence diagrams is both descriptive and prescriptive, so put the needed level of detail here, finding the right trade-off between understandability of the models and their precision.

Maximum number of words for this section: 4000

## Implementation									
Author: Mateusz Belka

Our UML diagrams have drastically changed from the state they were in as part of Assignment 2. As such, those changes naturally had to be represented in our implementation. Firstly, we constructed the necessary packages to organise the plethora of classes that we had recently added. This division proved to be crucial in allowing us to orientate between related and unrelated classes visually. As such, it made it clear when one aspect of our system was communicating with another. It was the most transparent during transitions between back-end and front-end parts of our source code.  
We redesigned our classes while maintaining the same frame of mind in terms of critical aspects of our program. One of the vital features of our game was to implement our internal logic in such a way as to allow the implementation of new stories in our system. As such, any change to our UML, and by extension our implementation, was made in such a way as to accommodate the introduction of new storylines.  
While transforming our class diagram into functional source code, we encountered several issues that couldn't have been predicted by UML diagrams. There are two most notable ones. The first one being the intricacies related to serialising classes into JSON format. The library of our choice to support us with this challenge was google's gson. The issue we encountered early on that we never managed to find an easy solution to was maintaining the object references through JSON data. If the same object was referenced in multiple locations, it was impossible, using out-of-the-box gson, to support those same references when saving and loading from the JSON file. If we were to do that, the result would be multiple copies of the references object which do not share the information between each other. As such if there would be a change to the contents of the object references in one part of the source code; that change wouldn't be seen in the other references to said object. The solution to this problem that we ended up implementing was a system of IDs for classes that carry unique information and have multiple instances during the runtime of our program. An example of such a class would be Location class. **PlayerStats** class wouldn't be an example of such class due to the fact there is always a single instance of this class during runtime. However, the element of complexity for this issue occurs when a class such as **PlayerStats** has variables which are of the type Location. In those situations, which were numerous, we had to implement a unique encode/decode logic for saving and loading JSON files. The gist of our solution was to replace the actual object references to references to the object's ID. As such, when saving a game, the variables with the data type of other classes are not included, but instead, their replacements in the form of ID variables are included. When loading JSON, we are able to reconstruct the original "graph of objects" for further use using this method. The second main issue is stemming from the factory method design pattern, and it's interactions with the gson library. For gson to correctly write **NPC** abstract class to JSON format, we had to implement a custom class adapter for gson to use.  
The key challenges related to Assignment 3 implementation were revolving around the implementation of design patterns as we had to gain additional knowledge to be able to implement them. Additionally, both design patterns proved problematic to support them in save and load logic. When deciding on design patterns, we looked at the elements of our system in which they would naturally provide an alternative to our current approach. As such, we didn't only look at the places where particular design pattern could be implemented but more importantly, the areas in which they would prove useful. As such for our factory method design pattern we decided to go with our **NPC** class. Initially, we didn't have a clear vision as to the direction in which we'd like to take the enemies from the structural point of view. After analysing the existing classes and considering creating a separate, independent class, we've decided that it makes the most sense for enemies to be treated similarly to, at the time, our **NPC** class. From that moment onward when the question of where does the factory method belong in our system, it was clear to us that the division into friendly and enemy **NPC** is the most natural and desired separation. Before we had thought of implementing the second design pattern we had **Inventory** and **PlayerStats** be standard non-static classes. As part of our work on other parts of the implementation, we learned about the concept of singletons, and it became clear that those two classes shouldn't be standard non-static classes if there is only one instance of them at any point in time during runtime. As such we decided to turn them into singletons. The change itself was straightforward to implement; however, the save and load logic once again proved to be a difficulty. Due to the nature of instance variable, the saving process doubled the contents of any ArrayList. Additionally, it seems that our singleton classes are saved twice; however, we failed to come up with a solution in which there is no information loss during saving and loading.  
During the majority of our work on source work, we mostly manage to implement solutions from the first attempt without the need for system overhauls. However, there is one exception which is the input validation logic. The overarching idea was to analyse words one by one and try to segregate them such that we know which part of our system the word belongs. The shortcoming of this approach, which we failed to recognise early, was that certain elements of our storyline might be longer than one word. The most notable example of that are names of game elements. The workaround we implemented for that is that player can input the first word that is part of the game element's name and our system would then correctly assign it's intended meaning. However, this is less than the desirable implementation of the system due to its quirkiness and irrational input expectations from the user. The temporary solution put in place for our game was to categorise the game elements which would be called by their name through user input and change their names such that spaces are replaced by other characters such as underscore. Due to late realisation of this shortcoming, we were unable to redesign our input validation system to accommodate for names longer than one word.
  
The class needed for executing our system is found at: "\src\main\java\Main.java". This class is responsible for forwarding the initial program start-up method call to appropriate method within our front-end UI class. We believe it allows a person who looks at our source code for the first time to navigate through the chain of method calls easier.  
The fat jar can be found at: "\build\libs\software-design-vu-2020.jar". It is crucial never to relocate this file from its original location as that will result in loss of save files. Since the jar is write-only, we were unable to include save files, which are created dynamically during gameplay, as part of the jar executable.



Click image to watch short video of our game!
[![30sec Video Presentation](https://i.imgur.com/PnZiE5f.png)](https://youtu.be/ydla-xiwkoM)

> Word Count 1223/2000

## References

References, if needed.