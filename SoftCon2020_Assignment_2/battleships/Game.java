package SoftCon2020_Assignment_2.battleships;

import SoftCon2020_Assignment_2.battleships.boardobjects.BoardObject;
import SoftCon2020_Assignment_2.battleships.boardobjects.ships.*;
import SoftCon2020_Assignment_2.battleships.exceptions.InvalidInputException;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private Board board;
    private ArrayList<BoardObject> ships;

    /**
     * The class ShipData is used to create objects which simplify the user input loops
     */
    private static class ShipData {
        private int shipAmount;
        private Ship shipType;

        private ShipData (int shipAmount, Ship shipType)  {
            this.shipAmount = shipAmount;
            this.shipType = shipType;
        }
    }

    public Game() {
        board = new Board(10, 10);
        this.askUserForShips();
    }

    public void start() {
        System.out.println(board);
    }

    public void askUserForShips() {
        System.out.println("Welcome to Battleship!!");
        System.out.println("To enter the desired coordinates, please follow the following pattern: A5 A0\n");

        // array with all ships and their properties
        ShipData[] ships = {new ShipData(1, new Carrier()),
                new ShipData(2, new Battleship()),
                new ShipData(3, new Submarine()),
                new ShipData(4, new PatrolBoat())};

        Scanner scanner = new Scanner(System.in);

        //user is asked for desired coordinates of all boats
        for (ShipData currentShip : ships) {
            for (int j = 1; j <= currentShip.shipAmount; j++) {
                if (currentShip.shipAmount == 1) {// to ask for "Carrier" instead of "Carrier 1" when only 1 is needed
                    System.out.println("Please enter the position of your " + currentShip.shipType.getName() + ": ");
                } else {// if more than 1 boat of same type are needed
                    System.out.println("Please enter the position of your " + currentShip.shipType.getName() + " " + j + ": ");
                }

                String input = scanner.nextLine();
                int spacebar = input.indexOf(" ");
                if (spacebar == -1) {
                    System.out.println("Please respect the given pattern!");
                    j--;
                    continue;
                }

                try {
                    board.addToBoard(getShipType(currentShip.shipType), input.substring(0, spacebar), input.substring(spacebar + 1));
                } catch (InvalidInputException InvalidInput) {
                    j--;
                }
            }
        }
        scanner.close();
    }

    private Ship getShipType(Ship shipType) {
        return switch (shipType.toString()) {
            case "C" -> new Carrier();
            case "B" -> new Battleship();
            case "S" -> new Submarine();
            case "P" -> new PatrolBoat();
            default -> null;
        };
    }
}
