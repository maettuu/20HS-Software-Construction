## Assignment 5
This project now uses gradle. In order for it to work, you will have to import the gradle projects.

Make sure to open the folders Task_1 and Task_2 separately with intellij and if there are any issues, try deleting your local copies of .gradle and .idea before reopening the project.

### Exercise 1

#### Composite Pattern
`BakeryComponent` serves as our component interface which all offices and bakeries implement.
`Office` represents a node and `Bakery` represents a leaf which all specific offices and bakeries
inherit from them.
We added a method `printName` and a method `printAllChildrenNames` for the print functionality to `BakeryComponent`.
A bakery prints only its own name when calling `printAllChildrenNames` while an office prints its own name 
and calls `printAllChildrenNames` on all of its children. 
This allows us to add more offices (for example `CountryOffice` or `DistrictOffice`) without 
modifying existing code. An office doesn't need to know if its children are offices or 
bakeries therefore we took some freedom and named the required method 
`printAllBakeriesNames` as `printAllChildrenNames` since this makes more sense.

`CentralOffice` is a bit awkward as it behaves different compared to other offices. 
As it doesn't print its name, we Override the `printName` method to do nothing.
The required method `printAllOffices` simply calls `printAllChildrenNames`.
It is a singleton as only one is allowed to exist. 

A `BakeryComponent` can only have one parent which we ensure by storing a reference to a parent
and checking for it. A `Bakery` can't have children and trying to call methods related to child
creation throws an error.


#### Decorator Pattern
We use the decorator pattern to decorate `Food` with `Topping` to calculate the new cost. `Food` is an interface which all types of
food implements (`Cake` and `Sandwich`for now) and 
`Topping` is an abstract class which implements Food and is extended by all toppings (`Chocolate` etc).
A `Topping` has a reference to the food it belongs to (which might be another topping) and calculates the `cost` by calling 
`cost` on this object, adding a certain amount and returning it. This a very obvious use case for the decorator pattern and has
the advantage that we can stack as many toppings as we want.


#### Selling Food

As a `NormalBakery` sells both sweets and bread the creation of those has been encapsulated in factories. This allows 
a `Bakery` to have references to multiple factories which leads to less code redundancy. More concretely a `NormalBakery` has 
a reference to a `SweetsFoodFactory` and to a `BreadFoodFactory` while a `BreadBakery` has a reference to a `BreadFoodFactory`only.
Adding a `Topping` is also a responsibility of a factory to avoid mixing wrong toppings. Because of this we could potentially remove
the concrete classes `NormalBakery` etc and only have `Bakery` and create them in this manner:
```
Bakery b = new Bakery(ArrayList<FoodFactory> factories, String name, HashMap<String, String> address);
```

### Exercise 2

#### Strategy Pattern
Whenever an instace of the class `Customer` is created, a respective vehicle is addressed to this instance.
Once the customer calls the `ride()` method, all stats of the vehicle are printed using the strategy pattern.
Each vehicle inherites the instance variables of the behavioral interfaces from the abstract class `Vehicle`.
The instance variables are initialized corresponding to the characteristics of the respective vehicle. Thanks to the strategy pattern
new vehicles can be added easily and additionally the existing vehicles can change their characteristics (e.g. from gasoline
to an electric gear) at runtime. New characteristics can be added without effecting any of the vehicles, the behaviors of a vehicle are
encapsulated.
