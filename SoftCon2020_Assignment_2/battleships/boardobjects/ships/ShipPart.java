package SoftCon2020_Assignment_2.battleships.boardobjects.ships;

import SoftCon2020_Assignment_2.battleships.boardobjects.BoardField;
import SoftCon2020_Assignment_2.battleships.boardobjects.BoardObject;

public class ShipPart implements BoardField {
    private boolean intact;
    private BoardObject ship;

    public ShipPart(BoardObject ship) {
        this.intact = true;
        this.ship = ship;
    }

    public BoardObject getShip() {
        return this.ship;
    }

    public boolean isIntact() {
        return this.intact;
    }

    public void destroy() {
        this.intact = false;
        this.ship.dealDamage();
    }
}
