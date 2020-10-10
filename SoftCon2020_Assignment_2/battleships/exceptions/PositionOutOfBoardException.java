package SoftCon2020_Assignment_2.battleships.exceptions;

public class PositionOutOfBoardException extends InvalidInputException {
    public PositionOutOfBoardException() {
        System.out.println("All boats must lie inside the board, please try again!");
    }
}
