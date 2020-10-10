package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.boardobjects.BoardObject;
import SoftCon2020_Assignment_2.battleships.boardobjects.ships.*;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidSizeException;

import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(board);
    }

    public void askUserForShips() {
        System.out.println("Welcome to Battleship!!");
        System.out.println("To enter the desired coordinates, please follow the following pattern: A5 A0\n");

        //array with all ships to enter
        String[] ships = {"Carrier", "Battleship 1", "Battleship 2", "Submarine 1", "Submarine 2", "Submarine 3",
                "Patrol boat 1", "Patrol boat 2", "Patrol boat 3", "Patrol boat 4"};
        Scanner scanner = new Scanner(System.in);

        //for loop for desired positions
        for (int i = 0; i < ships.length; i++) {
            System.out.println("Please enter the position of your " + ships[i] + ": ");
            String input = scanner.nextLine();
            int spacebar = input.indexOf(" ");
            if (spacebar == -1) {
                System.out.println("Please respect the given pattern!");
                i--;
                continue;
            }
            try {
                if (i == 0) {
                    board.addToBoard(new Carrier(), input.substring(0,spacebar), input.substring(spacebar+1));
                }
                else if (i == 1 || i == 2) {
                    board.addToBoard(new Battleship(), input.substring(0,spacebar), input.substring(spacebar+1));
                }
                else if (i < 6) {
                    board.addToBoard(new Submarine(), input.substring(0,spacebar), input.substring(spacebar+1));
                }
                else {
                    board.addToBoard(new PatrolBoat(), input.substring(0,spacebar), input.substring(spacebar+1));
                }

            } catch (InvalidInputException InvalidInput) {
                i--;
            }
        }

    };
}
