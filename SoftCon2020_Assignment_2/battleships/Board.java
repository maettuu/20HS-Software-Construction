package SoftCon2020_Assignment_2.battleships;

import java.util.ArrayList;
import java.util.List;

/**
 * A Board has a matrix for the fields and can be printed.
 */
public class Board {
    private List<List<BoardField>> board;
    private int columnLength;
    private int rowLength;

    public Board(int rowLength, int columnLength) {

        /**
         * In the assignment they once have the same columnLength as rowLength and once
         * not, so don't ask me what they want.
         */
        this.rowLength = rowLength;
        this.columnLength = columnLength;

        board = new ArrayList<List<BoardField>>();


        /**
         * Initializing empty board
         */
        for (int i = 0; i < columnLength; i++) {
            board.add(new ArrayList<BoardField>());
            for (int j = 0; j < rowLength; j++) {
                board.get(i).add(BoardField.EMPTY);
            }
        }
    }

    /** If you use System.out.println(board) this method gets called */
    public String toString() {
        String boardString = "Your board is:\n\n";

        // Adding First row for column names
        boardString += "    | ";
        for (int i = 0; i < columnLength; i++) {
            boardString += " " + String.valueOf((char)(65 + i)) + " ";
        }
        boardString += "\n";

        // Adding dashed line
        boardString += "----|-";
        for (int i = 0; i < rowLength; i++) {
            boardString += "---";
        }
        boardString += "\n";

        // Adding Rows
        int counter = 0;
        for (List<BoardField> row : board) {
            // Adding row name
            boardString += String.format("[%d] | ", counter);
            // Adding row values
            for (BoardField field : row) {
                boardString += String.format("[%s]", field);
            }
            counter++;
            boardString += "\n";
        }
        return boardString;
    };

    public void addShip(String startCoordinates, String endCoordinates) {
        // TODO
    }

    // TODO
    // set private once addShips is implemented
    // (at the moment public for testing purposes)
    public void setField(int aBoardRow, int aBoardColumn, BoardField aBoardField) {
        board.get(aBoardRow).set(aBoardColumn, aBoardField);
    }
}
