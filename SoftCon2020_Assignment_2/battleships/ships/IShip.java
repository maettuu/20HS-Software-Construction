package SoftCon2020_Assignment_2.battleships.ships;

public interface IShip {
    public int getLength();
    public String toString();
    public void dealDamage();
    public void addPart(ShipPart part);
}
