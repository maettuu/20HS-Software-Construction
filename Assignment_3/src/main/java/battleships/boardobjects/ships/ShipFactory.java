package main.java.battleships.boardobjects.ships;

public class ShipFactory {
    public static Ship get(String ship) {
        switch (ship) {
            case "Carrier":
                return new Carrier();
            case "Battleship":
                return new Battleship();
            case "Submarine":
                return new Submarine();
            case "Patrol Boat":
                return new PatrolBoat();
            default:
                return null;
        }
    }
}
