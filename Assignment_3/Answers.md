# Assignment 2
This project now uses gradle. 
In order for it to work, you will have to import
the gradle projects. 

Make sure to open the folder Assignment_3 directly and 
if there are any issues, try deleting your local copies of
.gradle and .idea before reopening the project.

## Example of Board Creation
Compared to the board creation in the project of the second assignment we changed quite a bit.
Since each player now has his/her own board the ships get added to it by calling the method `ship.addToBoard()`.
We included the option for a human player to print a suggestion for a playing board. The method `example()` can
be found in the `HumanPlayer` class. For this an instance of the `BotPlayer` class gets generated with which
a random board is generated. This can be found in the `addShips()` method of that class.
 
## Design Patterns
### Observer pattern
- **Observer**: src.main.java.battleships.IO.InputObserver
- **Subject**: src.main.java.battleships.IO.Input

#### Why
User inputs are used in many places in the battleship game. 
In some cases we will want to use a different InputStream than
the standard ``System.In``, with this design Pattern we simply
pass a different ``InputStream`` to the ``Input`` class.
Also in the future, it may be beneficial to read the inputs in several places
at once, which is also possible with this design.

Since ``Input`` is a Subject, services which want access the user input,
can simply subscribe to the input Class, which is great for encapsulation.

#### How
We are using a standard observer subject pattern, where an ``InputObserver``
can subscribe to the ``Input`` object, by calling the method ``Input.subscribe()``. 
In case the Observer is not interested in the inputs anymore, it can call ``Input.unsubscribe()``.


### Singleton pattern
**Location**: src.main.java.battleshipe.Game

#### Why
For the uniqueness of each game we added the singleton pattern. Like that, there is only one instance of the class `Game` at a time.
A new game can be started once the old one was ended.

#### How
To make a Singleton out of the class `Game`, we introduced a private static instance `uniqueGameInstance` which is declared in the `getInstance()` method,
whenever no other instance already exists otherwise the method returns the current instance.


### Iterator pattern
src.main.java.battleships.Board.genereateCoordinateIterator

src.main.java.battleships.coordinates.CoordinateIterator

TODO
