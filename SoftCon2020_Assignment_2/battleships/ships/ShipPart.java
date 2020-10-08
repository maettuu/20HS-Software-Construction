package SoftCon2020_Assignment_2.battleships.ships;

public class ShipPart {
    public boolean intact;
    public IShip ship;

    public ShipPart(IShip ship){
        this.intact = true;
        this.ship = ship;
        this.ship.addPart(this);
    }

    public void destroy(){
        this.intact = false;
        this.ship.dealDamage();
    }
}

