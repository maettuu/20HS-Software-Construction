package main.java.battleships.boardobjects.ships;

public class Carrier extends Ship {

    public Carrier(int id) {
        super(id);
    }

    public int getLength() {
        return 6;
    }

    @Override
    public String toString() {
        return "C";
    }

    public String getName() {
        return "Carrier";
    }
}
