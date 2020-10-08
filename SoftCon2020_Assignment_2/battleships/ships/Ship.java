package SoftCon2020_Assignment_2.battleships.ships;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship implements IShip{
    boolean intact;
    List<ShipPart> parts;

    Ship(){
        this.intact = true;
        this.parts = new ArrayList<ShipPart>();
    }
    public abstract int getLength();
    public abstract String toString();

    public void dealDamage(){
        this.intact = checkIfIntact();
    };

    public boolean checkIfIntact(){
        for (ShipPart part : this.parts){
            if (part.intact) return true;
        }
        return false;
    }

    public void addPart(ShipPart part){
        this.parts.add(part);
    };
}
