package main.java.battleships.boardobjects;

/**
 * A Board Field
 */
public interface BoardField {

    public BoardObject getShip();

    public boolean isIntact();
}
