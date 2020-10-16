package main.java.battleships.exceptions;

public class PositionOutOfBoardException extends InvalidInputException {
    public PositionOutOfBoardException() {
        System.out.println("All boats must lie inside the board, please try again!");
    }
}
