# 20HS Software Construction (SoCo)
This repository includes the practical assignments of the course SoCo. All code is written in `Java`.

## Assignment 1: OpenPDF Code Analysis
The first assignments focuses on analyzing the open source project [OpenPDF](https://github.com/LibrePDF/OpenPDF). UML diagrams show how the different parts of project are coupled, how they interact, and what packages are included. A call graph shows which elements are executed when a `Hello World` file  is written. Furthermore, several flow graphs show the behavior of the methods `Document.add`, `PdfCell.addImage`, `PdfDocument.flushLines`, `PdfPRow.writeBorderAndBackground`, `PdfString.ToPdf` and `Table.addColumns`.

## Assignment 2: Battleships
For this task the game **Battleships** is implemented. The folder contains the code as well as the corresponding test suite.

Includes packages: `util` : {`List`, `Scanner`}, `JUnit`

## Assignment 3: Battleships Pro
During this assignment the game **Battleships** from assignment 2 is improved. The *Observer*, *Singleton* and *Iterator* design patterns have been added. Furthermore, the game was extended to include more features for which the test suite is adjusted. The project now uses `Gradle`.

Includes packages: `util` : {`List`, `Scanner`, `HashMap`, `Collections`, `Iterator`}, `InputStream`, `JUnit`, `Gradle`

## Assignment 4: Bank Management
A bank management system is implemented using classes `Person`, `Level`, `CreditCard`, `Employee`, `Customer` and `Technician`. The UML diagram depicts how the classes are coupled to each other. The test suite can be found [here](./assignment-4/src/test).

Includes packages: `lombok`: {`Getter`, `Setter`}, `util` : {`UUID`, `Calendar`, `ArrayList`}, `JUnit`, `PrintStream`, `ByteArrayOutputStream`, `Gradle`

## Assignment 5: Cakes and Rides
This assignment consists of two separate tasks which both aim to implement design patterns. In the first task, the *Composite* and *Decorator* design patterns are applied to a cake bakery scenario. The second task applies the *Strategy* pattern to a Shuttle Service. Both tasks include their own test suite.

Includes packages: `util` : {`ArrayList`, `Calendar`, `HashMap`}, `lombok`: {`Getter`}, `JUnit`, `PrintStream`, `ByteArrayOutputStream`, `Gradle`

## Assignment 6: Model-View-Controller (MVC) Pattern
Here the *MVC* pattern is implemented to a employee management system. The UML diagram depicts how the classes are coupled to each other. As a second part, a UML for a shopping software is constructed to depict a potential system architecture.

Includes packages: `lombok`: {`Getter`, `Setter`}, `util` : {`UUID`, `Scanner`, `ArrayList`}, `PrintStream`, `ByteArrayOutputStream`, `Gradle`
