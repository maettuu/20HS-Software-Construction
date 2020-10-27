package battleships.IO;

import battleships.Board;
import battleships.Coordinate;
import battleships.exceptions.InvalidInputException;

import java.util.ArrayList;

/**
 * The string reader can read a single string input
 */
public class StringReader extends InputObserver {

    public StringReader(Input input){
        super(input);
    }

    public String getString(){
        return this.inputs.get(this.inputs.size()-1);
    }
}
