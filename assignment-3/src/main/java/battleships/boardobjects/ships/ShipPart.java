package battleships.boardobjects.ships;

import battleships.boardobjects.BoardField;
import battleships.boardobjects.BoardObject;
import battleships.exceptions.PositionAlreadyHit;

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

    public boolean destroy() throws PositionAlreadyHit {
        if(!this.isIntact()){
            throw new PositionAlreadyHit();
        }
        this.intact = false;
        this.ship.dealDamage();
        return true;
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
        if(getShip().isIntact()){
            if(this.isIntact()){
                return " ";
            }else{
                return "X";
            }
        }else{
            if(this.isIntact()){
                return " ";
            }else{
                return ship.toString();
            }
        }
    }
}
