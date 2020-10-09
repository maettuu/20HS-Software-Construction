package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.boardobjects.BoardObject;
import SoftCon2020_Assignment_2.battleships.boardobjects.ships.*;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;

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
        board.addToBoard(new Battleship(), "C2", "C5");
        board.addToBoard(new Submarine(), "F7", "D7");
        board.addToBoard(new Submarine(), "C8", "E8");
        System.out.println(board);
    }

    public void askUserForShips() {
        // TODO

    };
}
