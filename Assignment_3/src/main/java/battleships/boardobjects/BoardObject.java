package main.java.battleships.boardobjects;

import main.java.battleships.Board;
import main.java.battleships.exceptions.InvalidInputException;

/**
 * A board object consists of BoardFields. An example would be Ship who consists
 * of ShipParts. This Generalization would also allow us to use Duck and
 * DuckParts for example.
 */
public interface BoardObject {
    public int getLength();

    public String toString();

    public void dealDamage();

    public void addToBoard(Board board, int[] start, int[] end) throws InvalidInputException;

    public void addPart(Board board, BoardField field);
}
