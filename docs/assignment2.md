# Assignment 2

Maximum number of words for this document: 12000

**IMPORTANT**: In this assignment you will model the whole system. Within each of your models, you will have a *prescriptive intent* when representing the elements related to the feature you are implementing in this assignment, whereas the rest of the elements are used with a *descriptive intent*. In all your diagrams it is strongly suggested to used different colors for the prescriptive and descriptive parts of your models (this helps you in better reasoning on the level of detail needed in each part of the models and the instructors in knowing how to assess your models).   

**Format**: establish formatting conventions when describing your models in this document. For example, you style the name of each class in bold, whereas the attributes, operations, and associations as underlined text, objects are in italic, etc.

### Implemented feature

| ID  | Short name  | Description  |
|---|---|---|
| F1  | Tags | Code snippets can be tagged via freely-defined labels called tags  |

### Used modeling tool
Add here the name of the modeling tool you are using for your project.

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

Maximum number of words for this section: 3000

## Object diagrams								
Author: Mateusz Belka

<div align="center">
    <img src="visual/ObjectDiagram.png" width="90%">
</div>
  
The object diagram seen here presents the structure of a specific state of our system through the lens of UML. The aim of this diagram is, as opposed to class diagram, to allow the reader to understand the functional purpose of all classes quickly as well as to see the relationships between classes play out in action. The initial idea behind the structure of relationships between our classes was to maintain a tree-like structure in which the flow of information usually would go through some mediator instead of directly accessing the data from the desired class. Of course, such an approach has limitations as it's at times very troublesome to maintain such structure. Hence, our diagram aims to maintain such structure; however, it someone deviates from it.  

One shall start examining the diagram by noticing the instance of the game class. The purpose of its existence is to allow multiple games to be played at the same time. This allows for future expansions of the system, such as multiplayer. Implementing this structure now allows us, developers, to continuously maintain a lack of shared attributes between different instances of the game class. From the information flow point of view, the instance of the player class is the crucial point of the diagram. As we chose player class to be responsible for the majority of player-related activities, hence most events overall, most of the method calls either start or end in that class. As a result of our approach, the instance of player class also has the most direct accesses to instances of other classes to ease the need to talk to them continually. The instance of the player class is most notably connected to its inventories instance, and that object is connected to all of the items currently in it. On the left side from the instance of the game class, we can see the entire structure of areas player can reside in as well as the structures that support the existence of those areas. As standard game vocabulary etiquette suggests, we firstly split location into levels, which there can be multiple instances of, however, they are independent, and player can only have access to one at a time. Each level can be connected to multiple instances of room. Those object of room class represents a singular, specific location a player can reside in. Rooms can have a multitude of items, both static items and pickupable items, connected to them or they can have no items. Pickupable items have unique one-to-one connection with static items which can be seen in the instances of both of those classes on the diagram.

Word Count: 439/1000

## State machine diagrams									
Author(s): `name of the team member(s) responsible for this section`

This chapter contains the specification of at least 2 UML state machines of your system, together with a textual description of all their elements. Also, remember that classes the describe only data structures (e.g., Coordinate, Position) do not need to have an associated state machine since they can be seen as simple "data containers" without behaviour (they have only stateless objects).

For each state machine you have to provide:
- the name of the class for which you are representing the internal behavior;
- a figure representing the part of state machine;
- a textual description of all its states, transitions, activities, etc. in a narrative manner (you do not need to structure your description into tables in this case). We expect 3-4 lines of text for describing trivial or very simple state machines (e.g., those with one to three states), whereas you will provide longer descriptions (e.g., ~500 words) when describing more complex state machines.

The goal of your state machine diagrams is both descriptive and prescriptive, so put the needed level of detail here, finding the right trade-off between understandability of the models and their precision.

Maximum number of words for this section: 3000

## Sequence diagrams									
Author(s): `name of the team member(s) responsible for this section`

This chapter contains the specification of at least 2 UML sequence diagrams of your system, together with a textual description of all its elements. Here you have to focus on specific situations you want to describe. For example, you can describe the interaction of player when performing a key part of the videogame, during a typical execution scenario, in a special case that may happen (e.g., an error situation), when finalizing a fantasy soccer game, etc.

For each sequence diagram you have to provide:
- a title representing the specific situation you want to describe;
- a figure representing the sequence diagram;
- a textual description of all its elements in a narrative manner (you do not need to structure your description into tables in this case). We expect a detailed description of all the interaction partners, their exchanged messages, and the fragments of interaction where they are involved. For each sequence diagram we expect a description of about 300-500 words.

The goal of your sequence diagrams is both descriptive and prescriptive, so put the needed level of detail here, finding the right trade-off between understandability of the models and their precision.

Maximum number of words for this section: 3000

## Implementation									
Author(s): `name of the team member(s) responsible for this section`

In this chapter you will describe the following aspects of your project:
- the strategy that you followed when moving from the UML models to the implementation code;
- the key solutions that you applied when implementing your system (for example, how you implemented the syntax highlighting feature of your code snippet manager, how you manage fantasy soccer matches, etc.);
- the location of the main Java class needed for executing your system in your source code;
- the location of the Jar file for directly executing your system;
- the 30-seconds video showing the execution of your system (you can embed the video directly in your md file on GitHub).

IMPORTANT: remember that your implementation must be consistent with your UML models. Also, your implementation must run without the need from any other external software or tool. Failing to meet this requirement means 0 points for the implementation part of your project.

Maximum number of words for this section: 2000

## References

References, if needed.
