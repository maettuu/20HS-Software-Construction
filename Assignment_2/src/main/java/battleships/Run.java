package battleships;

import battleships.exceptions.InvalidInputException;

public class Run {
    public static void main(String args[]) throws InvalidInputException {
        Game game = new Game();
        game.start();
    }
}
