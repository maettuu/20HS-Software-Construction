# Assignment 1

## Part 1

### Architecture

#### Diagram

![OpenPDF architecture](OpenPDF.png)

#### Reasoning

As writing PDF files is one of the main tasks of the OpenPDF library, the focus lies on the creation of such a file. Furthermore, the HTML package is included
seeing that it is a great part of the library as well. The goal is to show the different layers of classes that are necessary for writing a `Hello World` file
(this will be shown more in detail in the following call graph). The diagram shows how the classes are connected to each other and on which parts of the library
most classes are built on. Naturally, there are several layers between the classes shown in the diagram (e.g. between several classes and the interface `Element`)
that are used for implementation/extension. For easier readability those have been left out. In addition, relations which do not help the reader understand the structure
have been ignored as well.

### Call Graph

#### Diagram

#### Reasoning

Since OpenPDF is a library, a central entry point is not easy to determine. As mentioned before the focus lies on the creation of a `Hello World` file.
The methods called and necessary for this are shown in the call graph. For a better overview not all methods are listed.

## Part 2

### Six Methods
