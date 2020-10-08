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
    private Ship[][] board;
    private int columnLength;
    private int rowLength;

    public Board(int rowLength, int columnLength) {

        /**
         * In the assignment they once have the same columnLength as rowLength and once
         * not, so don't ask me what they want.
         */
        this.rowLength = rowLength;
        this.columnLength = columnLength;

        // Row Major
        board = new Ship[rowLength][columnLength];

        for (int row = 0; row < rowLength; row++){
            for (int col = 0; col < columnLength; col++){
                board[row][col] = null;
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
                if (this.board[row][col] == null){
                    boardString += "[ ]";
                }
                else {
                    boardString += String.format("[%s]", board[row][col]);
                }
            }
            boardString += "\n";
        }
        return boardString;
    };

    public void addShip(String startCoordinates, String endCoordinates, Ship ship) throws InvalidInputException {
        // TODO check if field is already occupied
        int[] start = stringToCoordinates(startCoordinates);
        int startCol = start[0];
        int startRow = start[1];

        int[] end = stringToCoordinates(endCoordinates);
        int endCol = end[0];
        int endRow = end[1];


        // Row oriented
        if (startCol != endCol && startRow == endRow){
            int diff = endCol - startCol;
            int sign = (int) Math.signum(diff);
            int i = startCol;
            // we need to add the sign because the last entry also needs to be filled
            while (i != startCol + diff + sign) {
                this.board[startRow][i] = ship;
                // Depending on the input we need to iterate in different directions
                i += sign;
            }
        }
        // Col oriented
        else  if (startCol == endCol && startRow != endRow){
            int diff = endRow - startRow;
            int sign = (int) Math.signum(diff);
            int i = startRow;
            // we need to add the sign because the last entry also needs to be filled
            while (i != startRow + diff + sign) {
                this.board[i][startCol] = ship;
                // Depending on the input we need to iterate in different directions
                i += sign;
            }
        }
        // No diagonals allowed
        else {
            throw new InvalidInputException();
        }

    }

    int[] stringToCoordinates(String string) throws InvalidInputException {
        int col = (int) string.charAt(0) - 64; // 64 - 1 because of array index 0 offset
        col -= 1;
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
