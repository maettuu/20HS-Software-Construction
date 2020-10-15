package battleships.boardobjects.ships;

import battleships.boardobjects.BoardField;
import battleships.boardobjects.BoardObject;

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
