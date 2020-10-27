package battleships.boardobjects.ships;

import battleships.boardobjects.BoardField;
import battleships.boardobjects.BoardObject;
import battleships.exceptions.PositionAlreadyHit;

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
    public void destroy() throws PositionAlreadyHit {
        if(!this.isIntact()){
            throw new PositionAlreadyHit();
        }
        this.intact = false;
    }

    @Override
    public Object toStringHidden() {
        return toString();
    }
}
