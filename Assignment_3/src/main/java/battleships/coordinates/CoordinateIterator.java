package battleships.coordinates;

import battleships.Board;
import battleships.boardobjects.BoardField;
import battleships.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CoordinateIterator implements Iterator {
    ArrayList<Coordinate> coordinates;

    int index;

    public CoordinateIterator(BoardField[][] boardFields, Board board, boolean random, boolean onlyEmpty){
        this.coordinates = new ArrayList<>();
        index = 0;
        for (int i = 0; i < boardFields.length; i++){
            for (int j = 0; j < boardFields[i].length; j++){
                if (!onlyEmpty || !boardFields[i][j].isOccupied()){
                    try {
                        this.coordinates.add(new Coordinate(board, i,j));
                    }
                    catch (InvalidInputException e
                    ){
                        throw new Error();
                    }
                }
            }
        }

        if (random){
            Collections.shuffle(coordinates);
        }
    }

    @Override
    public boolean hasNext() {
        return index <= coordinates.size();
    }

    @Override
    public Coordinate next() {
        return coordinates.get(this.index++);
    }
}
