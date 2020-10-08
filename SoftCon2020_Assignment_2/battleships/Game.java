package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.ships.*;

import java.util.ArrayList;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private Board board;
    private ArrayList<IShip> ships;

    public Game() {
        board = new Board(9,9);
        this.askUserForShips();
    }

    public void start() throws InvalidInputException {
        System.out.println(board);

        board.addShip("A5", "A3", new Submarine());
        board.addShip("C6", "E6", new Carrier());
        board.addShip("H8", "A8", new PatrolBoat());
        board.addShip("I0", "I4", new Battleship());

        System.out.println(board);
    }

    public void askUserForShips() {
        // TODO

    };
}
