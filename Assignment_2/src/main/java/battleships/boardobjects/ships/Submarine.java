package main.java.battleships.boardobjects.ships;

public class Submarine extends Ship {

    public Submarine(int id) {
        super(id);
    }

    public int getLength() {
        return 3;
    }

    @Override
    public String toString() {
        return "S";
    }

    public String getName() {
        return "Submarine";
    }
}
