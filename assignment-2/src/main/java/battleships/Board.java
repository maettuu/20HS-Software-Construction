package main.java.battleships;

import main.java.battleships.boardobjects.BoardField;
import main.java.battleships.boardobjects.BoardObject;
import main.java.battleships.exceptions.InvalidInputException;
import main.java.battleships.exceptions.PositionAlreadyOccupiedException;
import main.java.battleships.exceptions.PositionOutOfBoardException;

/**
 * A Board has a matrix for the fields and can be printed.
 */
public class Board {
    private BoardField[][] board;
    private int columnLength;
    private int rowLength;

    public Board(int rowLength, int columnLength) {
        this.rowLength = rowLength;
        this.columnLength = columnLength;

        // Row Major
        board = new BoardField[rowLength][columnLength];

    }

    /** If you use System.out.println(board) this method gets called */
    public String toString() {
        String boardString = "";

        // Adding First row for column names
        boardString += "    | ";
        for (int i = 0; i < columnLength; i++) {
            boardString += " " + String.valueOf((char) (65 + i)) + " ";
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
                boardString += this.board[row][col] == null ? "[ ]" : String.format("[%s]", board[row][col].getShip());
            }
            boardString += "\n";
        }
        return boardString;
    };

    public void addToBoard(BoardObject boardObject, String start, String end) throws InvalidInputException {
        boardObject.addToBoard(this, stringToCoordinates(start), stringToCoordinates(end));
    }

    public void setField(int row, int column, BoardField boardField) throws InvalidInputException {
        if (this.board[row][column] != null)
            throw new PositionAlreadyOccupiedException();
        this.board[row][column] = boardField;
    }

    public boolean fieldIsEmpty(int row, int column) {
        if (board[row][column] != null) {
            return false;
        }
        return true;
    }

    /**
     * Converts a string of shape i.e. B5 into seperate coordinates
     */
    int[] stringToCoordinates(String string) throws InvalidInputException {


        int col = (int) string.charAt(0) - 64; // 64 is the start of uppercase letters in the ASCI alphabet
        col -= 1; // subtract 1 because our arrays start at 0 not 1
        if (col < 0 || col >= columnLength) {
            throw new PositionOutOfBoardException();
        }
        int row = Integer.parseInt(string.substring(1));
        if (row < 0 || row >= rowLength) {
            throw new PositionOutOfBoardException();
        }

        return new int[] { row, col };
    }
}
