package main.java.battleships.exceptions;

public class PositionAlreadyOccupiedException extends InvalidInputException {
    public PositionAlreadyOccupiedException() {
        System.out.println("Boats are not allowed to overlap, please try again!");
    }
}
