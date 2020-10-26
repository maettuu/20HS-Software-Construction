package main.java.battleships.exceptions;

public class PositionAlreadyOccupiedException extends InvalidInputException {

    public String toString(){
        return "Boats are not allowed to overlap, please try again!";
    }
}
