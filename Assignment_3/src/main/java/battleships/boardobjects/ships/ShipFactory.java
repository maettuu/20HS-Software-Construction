package main.java.battleships.boardobjects.ships;

public class ShipFactory {
    public static Ship get(String ship) {
        return switch (ship) {
            case "Carrier" -> new Carrier();
            case "Battleship" -> new Battleship();
            case "Submarine" -> new Submarine();
            case "Patrol Boat" -> new PatrolBoat();
            default -> null;
        };
    }
}
