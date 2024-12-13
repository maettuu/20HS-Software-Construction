package battleships.boardobjects.addbehavior;

import java.util.List;

import battleships.Board;
import battleships.coordinates.Coordinate;
import battleships.boardobjects.BoardField;
import battleships.exceptions.InvalidInputException;
import battleships.exceptions.NotInStraightLineException;
import battleships.exceptions.PositionAlreadyOccupiedException;

/**
 * An AddBehavior for adding BoardObjects in a straight line.
 */
public class AddStraightLine implements AddBehavior {

    @Override
    public void addToBoard(Board board, List<BoardField> fields, Coordinate start, Coordinate end) throws InvalidInputException {

        int amountShipFields = fields.size();

        // the amount fields we have to move in each direction
        int rowMoves = end.getRow() - start.getRow();
        int colMoves = end.getCol() - start.getCol();

        // check if it is a straight line
        if (rowMoves != 0 && colMoves != 0) {
            throw new NotInStraightLineException();
        }

        // getting the correct steps in each direction. Values are -1 +1 or 0
        int colStep = colMoves / (amountShipFields - 1); // horizontal steps
        int rowStep = rowMoves / (amountShipFields - 1); // vertical steps

        int row = start.getRow();
        int col = start.getCol();

        // check all fields
        for (BoardField field : fields) {
            if (board.isOccupied(row, col)) {
                throw new PositionAlreadyOccupiedException();
            }
            row += rowStep;
            col += colStep;
        }

        row = start.getRow();
        col = start.getCol();

        // add all fields
        for (BoardField field : fields) {

            board.setField(row, col, field);
            row += rowStep; // add vertical step
            col += colStep; // add horizontal step
        }
    }
}
