package main.java.battleships;

import main.java.battleships.boardobjects.BoardField;
import main.java.battleships.boardobjects.BoardObject;
import main.java.battleships.boardobjects.ships.EmptyField;
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

        for(int i = 0; i<rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                board[i][j] = new EmptyField();
            }
        }
    }

    public String toString(boolean shipsHidden) {
        StringBuilder boardString = new StringBuilder();

        // Adding First row for column names
        boardString.append("    | ");
        for (int i = 0; i < columnLength; i++) {
            boardString.append(" ").append(String.valueOf((char) (65 + i))).append(" ");
        }
        boardString.append("\n");

        // Adding dashed line
        boardString.append("----|-");
        for (int i = 0; i < rowLength; i++) {
            boardString.append("---");
        }
        boardString.append("\n");

        // Adding Rows
        for (int row = 0; row < rowLength; row++) {
            // Adding row name
            boardString.append(String.format("[%d] | ", row));
            // Adding row values
            for (int col = 0; col < columnLength; col++) {
                if(shipsHidden){
                    boardString.append(String.format("[%s]", board[row][col].toStringHidden()));
                }else{
                    boardString.append(String.format("[%s]", board[row][col].toString()));
                }

            }
            boardString.append("\n");
        }
        return boardString.toString();
    };


    public void setField(int row, int col, BoardField boardField) throws InvalidInputException {
        if (row < 0 || row > this.rowLength || col < 0 || col > this.columnLength)
            throw new PositionAlreadyOccupiedException();
        this.board[row][col] = boardField;
    }

    public boolean isOccupied(int row, int column) {
        return board[row][column].isOccupied();
    }


    public void hit(Coordinate c) throws InvalidInputException {
        board[c.getRow()][c.getCol()].destroy();
    }

    public int getColLen(){
        return this.columnLength;
    }

    public int getRowLen(){
        return this.rowLength;
    }
}
