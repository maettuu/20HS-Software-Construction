package main.java.battleships.exceptions;

public class InvalidSizeException extends InvalidInputException {
    public InvalidSizeException(String shipName, int shipSize) {
        switch (shipName) {
            case "C" -> System.out.println("A Carrier must have a size of " + shipSize + ". Please try again!");
            case "B" -> System.out.println("A Battleship must have a size of " + shipSize + ". Please try again!");
            case "S" -> System.out.println("A Submarine must have a size of " + shipSize + ". Please try again!");
            case "P" -> System.out.println("A Patrol boat must have a size of " + shipSize + ". Please try again!");
            default -> System.out.println("Please respect the given lengths for ships");
        }
    }
}
