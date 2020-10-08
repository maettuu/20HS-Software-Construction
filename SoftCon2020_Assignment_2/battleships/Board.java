package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.ships.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * A Board has a matrix for the fields and can be printed.
 */
public class Board {
    //private List<List<Character>> board;
    private String[][] board;
    private int columnLength;
    private int rowLength;

    public Board(int rowLength, int columnLength) {

        /**
         * In the assignment they once have the same columnLength as rowLength and once
         * not, so don't ask me what they want.
         */
        this.rowLength = rowLength;
        this.columnLength = columnLength;

        //board = new ArrayList<List<Character>>();
        board = new String[rowLength][columnLength];


        /**
         * Initializing empty board
         */
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                board[i][j] = " ";
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
        for (int row = 0; row < rowLength; row++) {
            // Adding row name
            boardString += String.format("[%d] | ", row);
            // Adding row values
            for (int col = 0; col < columnLength; col++) {
                boardString += String.format("[%s]", board[row][col]);
            }
            boardString += "\n";
        }
        return boardString;
    };

    public void addShip(String startCoordinates, String endCoordinates, Ship ship) throws InvalidInputException {
        // TODO
        int[] start = stringToCoordinates(startCoordinates);
        int startCol = start[0];
        int startRow = start[1];

        int[] end = stringToCoordinates(endCoordinates);
        int endCol = end[0];
        int endRow = end[1];



        // Row oriented
        if (startCol != endCol && startRow == endRow){
            int i = startCol;
            do {
                this.board[i][startRow] = ship.toString();
                i += Math.signum(endCol-startCol);
                System.out.println(i);
            } while (i != endRow);
        }
        // Col oriented
        else  if (startCol == endCol && startRow != endRow){
            int i = startRow;
            do {
                this.board[startCol][i] = ship.toString();
                i += Math.signum(endRow-startRow);
                System.out.println(i);
            } while (i != endRow);
        }
        // No diagonals allowed
        else {
            throw new InvalidInputException();
        }

    }

    int[] stringToCoordinates(String string) throws InvalidInputException {
        int col = (int) string.charAt(0) - 64;
        if (col < 0 || col > columnLength){
            throw new InvalidInputException();
        }
        int row = Integer.parseInt(string.substring(1));
        if (row < 0 || row > columnLength){
            throw new InvalidInputException();
        }

        return new int[]{col, row};
    }

    // TODO
    // set private once addShips is implemented
    // (at the moment public for testing purposes)
    /*public void setField(int aBoardRow, int aBoardColumn, BoardField aBoardField) {
        board.get(aBoardRow).set(aBoardColumn, aBoardField);
    }*/
}
