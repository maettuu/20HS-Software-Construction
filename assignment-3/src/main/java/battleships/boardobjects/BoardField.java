package battleships.boardobjects;

import battleships.exceptions.PositionAlreadyHit;

/**
 * A Board Field
 */
public interface BoardField {

    public BoardObject getShip();

    public boolean isIntact();

    public String toString();

    public boolean isOccupied();

    public boolean destroy() throws PositionAlreadyHit;

    Object toStringHidden();
}
