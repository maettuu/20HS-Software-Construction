package main.java.battleships.boardobjects.ships;

import main.java.battleships.boardobjects.BoardField;
import main.java.battleships.boardobjects.BoardObject;

public class EmptyField implements BoardField {
    private boolean intact;

    public EmptyField(){
        this.intact = true;
    }

    @Override
    public BoardObject getShip() {
        return null;
    }

    @Override
    public boolean isIntact() {
        return this.intact;
    }

    @Override
    public String toString(){
        if(isIntact()){
            return " ";
        }
        return "O";
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public void destroy() {
        this.intact = false;
    }

    @Override
    public Object toStringHidden() {
        return toString();
    }
}
