package main.java.battleships.boardobjects.ships;

public class Battleship extends Ship {

    public Battleship(int id) {
        super(id);
    }

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
