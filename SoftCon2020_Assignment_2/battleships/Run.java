package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;

public class Run {
    public static void main(String args[]) throws InvalidInputException {
        Game game = new Game();
        game.start();
    }
}
