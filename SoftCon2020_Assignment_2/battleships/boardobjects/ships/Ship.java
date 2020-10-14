package SoftCon2020_Assignment_2.battleships.boardobjects.ships;

import java.util.ArrayList;
import java.util.List;

import SoftCon2020_Assignment_2.battleships.Board;
import SoftCon2020_Assignment_2.battleships.boardobjects.BoardField;
import SoftCon2020_Assignment_2.battleships.boardobjects.BoardObject;
import SoftCon2020_Assignment_2.battleships.boardobjects.addbehavior.AddBehavior;
import SoftCon2020_Assignment_2.battleships.boardobjects.addbehavior.AddStraightLine;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidSizeException;

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

    public void addToBoard(Board board, int[] start, int[] end) throws InvalidInputException {
        List<BoardField> fields = new ArrayList<BoardField>();
        for (int i = 0; i < this.getLength(); i++) {
            fields.add(new ShipPart(this));
        }
        // check for length
        if (Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]) != this.getLength() - 1) {
            throw new InvalidSizeException(this.toString(), this.getLength());
        }
        addBehavior.addToBoard(board, fields, start, end);
    }

    public void addPart(Board board, BoardField field) {
        this.fields.add(field);
    }
}
