package main.java.battleships.boardobjects.ships;

public class Battleship extends Ship {

    public int getLength() {
        return 4;
    }

    @Override
    public String toString() {
        return "B";
    }

    public String getName() {
        return "Battleship";
    }
}
