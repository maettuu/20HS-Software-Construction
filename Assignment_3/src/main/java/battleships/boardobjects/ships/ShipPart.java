package main.java.battleships.boardobjects.ships;

import main.java.battleships.boardobjects.BoardField;
import main.java.battleships.boardobjects.BoardObject;

/**
 * Each Ship consists of ship parts and each ShipPart can get destroyed
 */
public class ShipPart implements BoardField {
    private boolean intact;
    private BoardObject ship;


    public ShipPart(BoardObject ship) {
        this.intact = true;
        this.ship = ship;
    }

    public ShipPart() {
        this.intact = false;
    }

    public BoardObject getShip() {
        return this.ship;
    }

    public boolean isIntact() {
        return this.intact;
    }

    @Override
    public boolean isOccupied(){return true;}

    public void destroy() {
        this.intact = false;
        this.ship.dealDamage();
    }
    @Override
    public String toString(){
        if(this.isIntact()){
            return this.getShip().toString();
        }else{
            return "X";
        }
    }

    public String toStringHidden(){
        // TODO if ship is not intact return this.getShip().toString()
        if(!this.isIntact()){
            return "X";
        }
        return " ";

    }


}
