# Assignment 3

Maximum number of words for this document: 18000

**IMPORTANT**: In this assignment you will fully model and impement your system. The idea is that you improve your UML models and Java implementation by (i) applying (a subset of) the studied design patterns and (ii) adding any relevant implementation-specific details (e.g., classes with “technical purposes” which are not part of the domain of the system). The goal here is to improve the system in terms of maintainability, readability, evolvability, etc.    

**Format**: establish formatting conventions when describing your models in this document. For example, you style the name of each class in bold, whereas the attributes, operations, and associations as underlined text, objects are in italic, etc.

### Summary of changes of Assignment 2
Author(s): `name of the team member(s) responsible for this section`

Provide a bullet list summarizing all the changes you performed in Assignment 2 for addressing our feedback.

Maximum number of words for this section: 1000

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
Author(s): `name of the team member(s) responsible for this section`

This chapter contains the description of a "snapshot" of the status of your system during its execution. 
This chapter is composed of a UML object diagram of your system, together with a textual description of its key elements.

`Figure representing the UML class diagram`
  
`Textual description`

Maximum number of words for this section: 1000

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

In this chapter you will describe the following aspects of your project:
- the strategy that you followed when moving from the UML models to the implementation code;
- the key solutions that you applied when implementing your system (for example, how you implemented the syntax highlighting feature of your code snippet manager, how you manage fantasy soccer matches, etc.);
- the location of the main Java class needed for executing your system in your source code;
- the location of the Jar file for directly executing your system;
- the 30-seconds video showing the execution of your system (you can embed the video directly in your md file on GitHub).

IMPORTANT: remember that your implementation must be consistent with your UML models. Also, your implementation must run without the need from any other external software or tool. Failing to meet this requirement means 0 points for the implementation part of your project.

----------------------------------------------
Our UML diagrams have drastically changed from the state they were in as part of Assignment 2. As such those changes naturally had to be represented in our implementation. Firstly, we constructed the necessary packages to organize the plethora of classes we suddenly had to work with. This division proved to be crucial in allowing us to visually orientate between related and unrelated classes. As such it made it clear when one aspect of our system was communicating with another. It was the most transparent during transitions between back-end and front-end parts of our source code.  
Our classes were redesigned while maintaining the same frame of mind in terms of key aspects of our program. One of the key fundamental features of our game was to implement our internal logic in such a way as to allow new stories to be implemented in our system. As such any change to our UML, and by extension our implementation, was made in such a way as to accommodate the introduction of new storylines.  
While transforming our class diagram into a functional source code we encountered a number of issues that couldn't have been predicted by UML diagrams. There are two most notable ones. The first one being the intricacies related to serializing classes into json format. The library of our choice to support us with this challenge was google's gson. The issue we encountered early on that we never managed to find an easy solution to was maintaining the object references through json data. If the same object was references in multiple locations it was impossible, using out-of-the-box gson, to maintain those same references when saving and loading from json file. If we were to do that, the result would be multiple copies of the references object which do not share the information between each other. As such if there would be a change to the contents of the object references in one part of the source code; that change wouldn't be seen in the other references to said object. The solution to this problem that we ended up implementing was a system of IDs for classes that carry unique information and have multiple instances during runtime of our program. An example of such class would be Location class. **PlayerStats** class wouldn't be an example of such class due to the fact there is always a single instance of this class during runtime. However, the element of complexity for this issue occurs when a class such as **PlayerStats** has variables which are of the type Location. In those situations, which were numerous, we had to implement a unique encode/decode logic for saving and loading json files. The gist of our solution was to replace the actual object references to references to the object's ID. As such when saving game the actual variables with data type of other classes are not included but instead their replacements in the form of ID variations are included. When loading json we are able to reconstruct the original "graph of objects" for further use using this method. The second one main issue is stemming from the factory method design pattern and it's interactions with gson library. In order for gson to properly write **NPC** abstract class to json format we had to implement a custom class adapter for gson to use.  
The key challenges related to Assignment 3 implementation were revolving around the implementation of design patterns as we had to gain additional knowledge in order to be able to implement them. Additionally, both design patterns proved problematic to support them in save and load logic. When deciding on design patterns we looked at the elements of our system in which they would naturally provide an alternative to our current approach. As such we didn't only look at the places where certain design pattern could be implemented but more importantly the places in which they would actually prove useful. As such for our factory method design pattern we decided to go with our **NPC** class. Initially we didn't have a clear vision as to the direction in which we'd like to take the enemies from the structural point of view. After analysing the existing classes and considering creating a separate, independent class, we've decided that it makes the most sense for enemies to be treated similarly to, at the time, our **NPC** class. From that moment onward when the question of where does the factory method belong in our system it was clear to us that the division into friendly and enemy **NPC** is the most natural and desired separation. Before we had thought of implementing our second design pattern we had **Inventory** and **PlayerStats** be standard non-static classes. As part of our work on other parts of implementation we learned about the concept of singletons and it became clear that those two classes shouldn't be standard non-static classes if there is only one instance of them at any point in time during runtime. As such we decided to turn them into singletons. The change itself was very easy to implement; however, the save and load logic once again proved to be a difficulty. Due to the nature of instance variable the saving process doubled the contents of any arraylist. Additionally, it seems that our singleton classes are saved twice, however, we failed ot come up with solution in which there is no information loss during saving and loading.  
During the majority of our work on source work we mostly manage to implement solutions from first attempt without the need of system overhauls. However, there is one exception which is the input validation logic. The overarching idea was to analyse words one by one and try to segregate them such that we know which part of our system the word belongs. The shortcoming of this approach, which we failed to recognise early, was that certain elements of our storyline might be longer than one word. The most notable example of that are names of game elements. The workaround we implemented for that is that player can input the first word that is part of the game element's name and our system would then properly assign it it's intended meaning. However, this is obviously less than desirable implementation of the system due to it's quirkiness and irrational input expectations from user. The temporary solution put in place for our game was to categorize the game elements which would be called by their name through user input and change their names such that spaces are replaced by other characters such as underscore. Due to late realization of this shortcoming we were unable to redesign our input validation system to accommodate for names longer than one word.
  
The class needed for executing our system is found at: "\src\main\java\Main.java". This class is responsible for forwarding the initial program start up method call to appropriate method within our front-end UI class. We believe it allows a person who looks at our source code for the first time to navigate through the chain of method calls easier.  
The fat jar can be found at: "\build\libs\software-design-vu-2020.jar". It is crucial to never relocate this file from it's original location as that **will** result in loss of save files. Since jar is write only, we were unable to include save files, which are created dynamically during gameplay, as part of the jar executable.  
*Video Placeholder*

> Word Count 0/2000

## References

References, if needed.