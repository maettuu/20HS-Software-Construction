package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.ships.*;

import java.util.ArrayList;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private Board board;
    private ArrayList<BoardObject> ships;

    public Game() {
        board = new Board(9, 9);
        this.askUserForShips();
    }

    public void start() throws InvalidInputException {
        board.addToBoard(new Carrier(), "A5", "A0");
        board.addToBoard(new Battleship(), "C5", "C2");
        board.addToBoard(new Submarine(), "F7", "D7");
        System.out.println(board);
    }

    public void askUserForShips() {
        // TODO

    };
}
