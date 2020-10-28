package battleships.boardobjects;

import battleships.Board;
import battleships.coordinates.Coordinate;
import battleships.exceptions.InvalidInputException;

/**
 * A board object consists of BoardFields. An example would be Ship who consists
 * of ShipParts. This Generalization would also allow us to use Duck and
 * DuckParts for example.
 */
public interface BoardObject {
    public int getLength();

    public String toString();

    public void dealDamage();

    public void addToBoard(Board board, Coordinate start, Coordinate end) throws InvalidInputException;

    String getName();

    boolean isIntact();
}
