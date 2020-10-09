package SoftCon2020_Assignment_2.battleships.boardobjects.addbehavior;

import SoftCon2020_Assignment_2.battleships.boardobjects.BoardField;
import SoftCon2020_Assignment_2.battleships.Board;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import java.util.List;

/**
 * Interface for determining how a ship can be added to a board.
 */
public interface AddBehavior {
    public void addToBoard(Board board, List<BoardField> fields, int[] start, int[] end) throws InvalidInputException;
}
