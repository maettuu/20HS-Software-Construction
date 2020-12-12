## Assignment 5
This project now uses gradle. In order for it to work, you will have to import the gradle projects.

Make sure to open the folder Task_1 separately with intellij and if there are any issues, try deleting your local copies of .gradle and .idea before reopening the project.

### Exercise 1

#### Model-View-Controller Pattern

#### Class Diagram

### Exercise 2

#### Class Diagram ShoppingSW

#### Composite Pattern
To build the classes for the products a tree-like structure with the abstract class ´Product´ as root was chosen. This enables it to easily iterate through the
respective instances of a class when filtering products or specific clothes/shoes. For the color of a product as well as the size an enum was chosen, with which it's
simple to add new colors or sizes without changing a lot of code (this also leaves open the option to filter by color/size easily if it were desired).
