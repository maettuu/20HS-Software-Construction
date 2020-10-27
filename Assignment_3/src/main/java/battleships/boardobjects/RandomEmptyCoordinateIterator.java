package battleships.boardobjects;

import battleships.Board;
import battleships.Coordinate;
import battleships.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RandomEmptyCoordinateIterator implements Iterator {
    ArrayList<Coordinate> emptyCoordinates;

    int index;

    public RandomEmptyCoordinateIterator(BoardField[][] boardFields, Board board){
        this.emptyCoordinates = new ArrayList<>();
        index = 0;
        for (int i = 0; i < boardFields.length; i++){
            for (int j = 0; j < boardFields[i].length; j++){
                if (!boardFields[i][j].isOccupied()){
                    try {
                        this.emptyCoordinates.add(new Coordinate(board, i,j));
                    }
                    catch (InvalidInputException e
                    ){
                        throw new Error();
                    }
                }
            }
        }

        Collections.shuffle(emptyCoordinates);
    }

    @Override
    public boolean hasNext() {
        return index <= emptyCoordinates.size();
    }

    @Override
    public Coordinate next() {
        return emptyCoordinates.get(this.index++);
    }
}
