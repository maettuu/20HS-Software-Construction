package main.java.battleships.exceptions;

public class PositionOutOfBoardException extends InvalidInputException {
    public String toString(){
        return "All boats must lie inside the board, please try again!";
    }
}
