## Assignment 6
This project now uses gradle. In order for it to work, you will have to import the gradle projects.

Make sure to open the folder Assignment_6 separately with intellij and if there are any issues, try deleting your local copies of .gradle and .idea before reopening the project.

### Exercise 1

#### Model-View-Controller Pattern

##### Structure 

We have decided to use the strategy design pattern for the implementation details of 
the MVC pattern. Meaning the the ``View`` only communicates with the ``Controller`` and the 
``Model`` also only with the ``Controller``. The ``Controller`` implements all logic and decides 
how to react to specific user inputs. The ``View`` then only has to read the user input
and leaves the decision process to the ```Controller```

##### View
The ``View`` class is a straight forward user interface which works either using the
System.in and System.out Streams or it can also be driven by another virtual instance
using the ``handleInput`` method. 

##### Controller
The ``Controller`` parses the input strings and selects the proper algorithm to convert 
them into commands on the ``Model``. It also handles requests for displaying information
back to the ``View``.

##### Model
The ```Model``` takes care of all the data. It allows to update ``Employees``  instances, create new ones,
and delete them.  

#### Class Diagram

### Exercise 2

#### Class Diagram ShoppingSW

#### Composite Pattern
To build the classes for the products a tree-like structure with the abstract class `Product` as root was chosen. This enables it to easily iterate through the
respective instances of a class when filtering products or specific clothes/shoes. For the color of a product as well as the size an enum was chosen, with which it's
simple to add new colors or sizes without changing a lot of code (this also leaves open the option to filter by color/size easily if it were desired).
