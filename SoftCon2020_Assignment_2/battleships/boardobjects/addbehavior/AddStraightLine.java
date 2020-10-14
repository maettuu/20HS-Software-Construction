package SoftCon2020_Assignment_2.battleships.boardobjects.addbehavior;

import java.util.List;

import SoftCon2020_Assignment_2.battleships.Board;
import SoftCon2020_Assignment_2.battleships.boardobjects.BoardField;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.exceptions.NotInStraightLineException;
import SoftCon2020_Assignment_2.battleships.exceptions.PositionAlreadyOccupiedException;
import SoftCon2020_Assignment_2.battleships.exceptions.PositionOutOfBoardException;

/**
 * An AddBehavior for adding BoardObjects in a straight line.
 */
public class AddStraightLine implements AddBehavior {

    @Override
    public void addToBoard(Board board, List<BoardField> fields, int[] start, int[] end) throws InvalidInputException {

        int amountShipFields = fields.size();

        // the amount fields we have to move in each direction
        int rowMoves = end[0] - start[0];
        int colMoves = end[1] - start[1];

        // check if it is a straight line
        if (rowMoves != 0 && colMoves != 0) {
            throw new NotInStraightLineException();
        }

        // getting the correct steps in each direction. Values are -1 +1 or 0
        int colStep = colMoves / (amountShipFields - 1); // horizontal steps
        int rowStep = rowMoves / (amountShipFields - 1); // vertical steps

        int row = start[0];
        int col = start[1];

        // check all fields
        for (BoardField field : fields) {
            if (!board.fieldIsEmpty(row, col)) {
                throw new PositionAlreadyOccupiedException();
            }
        }
        // add all fields
        for (BoardField field : fields) {

            board.setField(row, col, field);
            row += rowStep; // add vertical step
            col += colStep; // add horizontal step
        }
    }
}
