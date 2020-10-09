package SoftCon2020_Assignment_2.battleships.ships;

import java.util.ArrayList;
import java.util.List;

import SoftCon2020_Assignment_2.battleships.Board;
import SoftCon2020_Assignment_2.battleships.BoardObject;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidSizeException;
import SoftCon2020_Assignment_2.battleships.exceptions.NotInStraightLineException;

public abstract class Ship implements BoardObject {
    protected boolean intact;
    protected List<ShipPart> parts;

    Ship() {
        this.intact = true;
        this.parts = new ArrayList<ShipPart>();
    }

    public abstract int getLength();

    public abstract String toString();

    public void dealDamage() {
        this.intact = checkIfIntact();
    };

    public boolean checkIfIntact() {
        for (ShipPart part : this.parts) {
            if (part.isIntact())
                return true;
        }
        return false;
    }

    /**
     * Adds straight ships only. For more flexibility this could be moved out of the
     * class to implement
     */
    public void addToBoard(Board board, int[] start, int[] end) throws InvalidInputException {
        // one should be the positive or negative length and the other should be 0
        int rowDiff = end[0] - start[0];
        int colDiff = end[1] - start[1];
        // subtract one
        int spaces = getLength() - 1;

        // check if diagonal
        if (rowDiff != 0 && colDiff != 0) {
            throw new NotInStraightLineException();
        }
        // check for correct length. -1
        if (Math.abs(rowDiff + colDiff) != spaces) {
            throw new InvalidSizeException();
        }
        // getting the correct steps in each direction. Values are -1 +1 or 0
        int colStep = colDiff / (spaces); // horizontal steps
        int rowStep = rowDiff / (spaces); // vertical steps

        int row = start[0];
        int col = start[1];

        for (int i = 0; i <= spaces; i++) {
            ShipPart shipPart = new ShipPart(this);
            board.setField(row, col, shipPart);
            this.parts.add(shipPart);
            row += rowStep; // add vertical step
            col += colStep; // add horizontal step
        }
    }
}
