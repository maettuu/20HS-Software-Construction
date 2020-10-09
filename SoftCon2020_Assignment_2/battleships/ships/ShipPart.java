package SoftCon2020_Assignment_2.battleships.ships;

import SoftCon2020_Assignment_2.battleships.BoardField;
import SoftCon2020_Assignment_2.battleships.BoardObject;

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
