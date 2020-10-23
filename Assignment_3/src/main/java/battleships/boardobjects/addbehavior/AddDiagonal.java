package main.java.battleships.boardobjects.addbehavior;

import java.util.List;

import main.java.battleships.Board;
import main.java.battleships.boardobjects.BoardField;
import main.java.battleships.exceptions.InvalidInputException;

/**
 * An AddBehavior for adding BoardObjects diagonally.
 */
public class AddDiagonal implements AddBehavior {

    @Override
    public void addToBoard(Board board, List<BoardField> fields, int[] start, int[] end) throws InvalidInputException {
        // We don't need this yet

    }

}
