package SoftCon2020_Assignment_2.battleship;

/**
 * An enum which represents the status of a board field. Printing it returns a
 * one letter abbrevation which can be used for displaying the board.
 */
public enum BoardField {
    SUBMARINE("S"), CARRIER("C"), BATTLESHIP("B"), PATROLBOARD("P"), EMPTY(" ");

    private final String fieldStatus;

    BoardField(String aFieldStatus) {
        this.fieldStatus = aFieldStatus;
    }

    @Override
    public String toString() {
        return this.fieldStatus;
    }

}
