# Assignment 2

This project now uses gradle. 
In order for it to work, you will have to import
the gradle projects. 

Make sure to open the Folder Assignment3 directly and 
if there are any issues, try deleting your local copies of
.gradle and .idea before reopening the project.
 
### Observer pattern
- **Observer**: src.main.java.battleships.IO.InputObserver
- **Subject**: src.main.java.battleships.IO.Input

#### Why
User inputs are used in many places in the battleship game. 
In some cases we will want to use a different InputStream than
the standard ``System.In``, with this design Pattern with simply
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

TODO

### Iterator pattern

src.main.java.battleships.Board.genereateCoordinateIterator
src.main.java.battleships.coordinates.CoordinateIterator

TODO