package main.java.battleships.boardobjects.ships;

import java.util.ArrayList;
import java.util.List;

import main.java.battleships.Board;
import main.java.battleships.Coordinate;
import main.java.battleships.boardobjects.BoardField;
import main.java.battleships.boardobjects.BoardObject;
import main.java.battleships.boardobjects.addbehavior.AddBehavior;
import main.java.battleships.boardobjects.addbehavior.AddStraightLine;
import main.java.battleships.exceptions.InvalidInputException;
import main.java.battleships.exceptions.InvalidSizeException;

/**
 * Abstract class ship
 *
 * Defines behaviour which is identical on all ships
 */
public abstract class Ship implements BoardObject {
    protected boolean intact;
    protected List<BoardField> fields;
    protected AddBehavior addBehavior;

    Ship() {
        this.intact = true;
        this.fields = new ArrayList<BoardField>();
        this.addBehavior = new AddStraightLine();
    }


    public abstract int getLength();

    public abstract String toString();

    public abstract String getName();

    public void dealDamage() {
        this.intact = isIntact();
    };

    public boolean isIntact() {
        for (BoardField field : this.fields) {
            if (field.isIntact())
                return true;
        }
        return false;
    }

    public void setAddBehavior(AddBehavior addBehavior) {
        this.addBehavior = addBehavior;
    }

    public void addToBoard(Board board, Coordinate start, Coordinate end) throws InvalidInputException {
        List<BoardField> fields = new ArrayList<BoardField>();
        for (int i = 0; i < this.getLength(); i++) {
            fields.add(new ShipPart(this));
        }
        // check for length
        if (Math.abs(start.getRow() - end.getRow()) + Math.abs(start.getCol() - end.getCol()) != this.getLength() - 1) {
            throw new InvalidSizeException(this.toString(), this.getLength());
        }
        addBehavior.addToBoard(board, fields, start, end);
    }
}
