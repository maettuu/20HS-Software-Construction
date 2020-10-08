package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.ships.Battleship;
import SoftCon2020_Assignment_2.battleships.ships.Ship;
import SoftCon2020_Assignment_2.battleships.ships.Submarine;

import java.util.ArrayList;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private Board board;
    private ArrayList<Ship> ships;

    public Game() {
        board = new Board(9,9);
        // TODO How to add ships to Game
    }

    public void start() throws InvalidInputException {
        System.out.println(board);
        board.addShip("A5", "A3", new Submarine());
        board.addShip("C5", "C3", new Submarine());
        board.addShip("H5", "A5", new Submarine());
        board.addShip("I0", "I8", new Battleship());
        //board.setField(5, 5, BoardField.CARRIER);
        System.out.println(board);
    }

    public void askUserForShips() {
        // TODO
        // for(Ship ship : ships){
        // board.addShip(startCoordinates, endCoordinates);
        // }
    };

}
