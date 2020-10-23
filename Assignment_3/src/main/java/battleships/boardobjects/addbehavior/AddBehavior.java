package main.java.battleships.boardobjects.addbehavior;

import main.java.battleships.boardobjects.BoardField;
import main.java.battleships.Board;
import main.java.battleships.exceptions.InvalidInputException;
import java.util.List;

/**
 * Interface for determining how a ship can be added to a board.
 */
public interface AddBehavior {
    public void addToBoard(Board board, List<BoardField> fields, int[] start, int[] end) throws InvalidInputException;
}
