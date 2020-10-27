package battleships;

import battleships.exceptions.InvalidInputException;
import battleships.exceptions.PositionOutOfBoardException;

public class Coordinate {

    private int row;
    private int col;
    private Board board;

    public Coordinate(Board board, int row, int col) throws InvalidInputException {
        if(row < 0 || row >= board.getRowLen() || col < 0 || col >= board.getColLen()){
            throw new PositionOutOfBoardException();
        }
        this.board = board;
        this.row = row;
        this.col = col;

    }


    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }


}
