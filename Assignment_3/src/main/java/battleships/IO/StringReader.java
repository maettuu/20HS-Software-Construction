package main.java.battleships.IO;

import main.java.battleships.Board;
import main.java.battleships.Coordinate;
import main.java.battleships.exceptions.InvalidInputException;

import java.util.ArrayList;

public class StringReader extends InputObserver {

    public StringReader(Input input){
        super(input);
    }

    public String getString(){
        return this.inputs.get(this.inputs.size()-1);
    }
}
