package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.boardobjects.BoardObject;
import SoftCon2020_Assignment_2.battleships.boardobjects.ships.*;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private Board board;
    private ArrayList<BoardObject> ships;

    /**
     * The class UserShipCreatorHelper is used to create objects which simplify the user input loops
     */
    private class UserShipCreatorHelper {
        private String shipName;
        private int shipAmount;
        private Ship shipType;
    }

    public Game() {
        board = new Board(10, 10);
        this.askUserForShips();
    }

    public void start() throws InvalidInputException {
        System.out.println(board);
    }

    public void askUserForShips() {
        System.out.println("Welcome to Battleship!!");
        System.out.println("To enter the desired coordinates, please follow the following pattern: A5 A0\n");

        // array with all ships and their properties
        UserShipCreatorHelper[] ships = {newShip("Carrier", 1, new Carrier()),
                newShip("Battleship", 2, new Battleship()),
                newShip("Submarine", 3, new Submarine()),
                newShip("Patrol boat", 4, new PatrolBoat())};

        Scanner scanner = new Scanner(System.in);

        //user is asked for desired coordinates of all boats
        for (UserShipCreatorHelper currentShip : ships) {
            for (int j = 1; j <= currentShip.shipAmount; j++) {
                if (currentShip.shipAmount == 1) {// to ask for "Carrier" instead of "Carrier 1" when only 1 is needed
                    System.out.println("Please enter the position of your " + currentShip.shipName + ": ");
                } else {// if more than 1 boat of same type are needed
                    System.out.println("Please enter the position of your " + currentShip.shipName + " " + j + ": ");
                }

                String input = scanner.nextLine();
                int spacebar = input.indexOf(" ");
                if (spacebar == -1) {
                    System.out.println("Please respect the given pattern!");
                    j--;
                    continue;
                }
                try {
                    board.addToBoard(currentShip.shipType, input.substring(0, spacebar), input.substring(spacebar + 1));
                } catch (InvalidInputException InvalidInput) {
                    j--;
                }
            }
        }
    }

    private UserShipCreatorHelper newShip(String shipName, int shipAmount, Ship shipType)  {
        UserShipCreatorHelper current = new UserShipCreatorHelper();
        current.shipName = shipName;
        current.shipAmount = shipAmount;
        current.shipType = shipType;
        return current;
    }
}
