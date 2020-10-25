package main.java.battleships;

import main.java.battleships.boardobjects.ships.*;
import main.java.battleships.exceptions.InvalidInputException;
import main.java.battleships.exceptions.InvalidInputFormatException;

import java.util.Scanner;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private Board board;
    private static Game uniqueGameInstance;

    /**
     * The class ShipData is used to create objects which simplify the user input loops
     */
    private static class ShipData {
        private int shipAmount;
        private Ship shipType;

        private ShipData(int shipAmount, Ship shipType) {
            this.shipAmount = shipAmount;
            this.shipType = shipType;
        }
    }

    // Default setup
    private Game() {
        board = new Board(10, 10);
        this.askUserForShips();
    }

    // example setup
    public Game(String e) throws InvalidInputException {
        System.out.println("This is an example of how the board can look like:\n");
        board = new Board(10,10);
        board.addToBoard(new Carrier(), "E9", "J9");
        board.addToBoard(new Battleship(), "G0", "J0");
        board.addToBoard(new Battleship(), "A2", "A5");
        board.addToBoard(new Submarine(), "D0", "D2");
        board.addToBoard(new Submarine(), "F2", "H2");
        board.addToBoard(new Submarine(), "J5", "J7");
        board.addToBoard(new PatrolBoat(), "A0", "B0");
        board.addToBoard(new PatrolBoat(), "J2", "J3");
        board.addToBoard(new PatrolBoat(), "F5", "F6");
        board.addToBoard(new PatrolBoat(), "A7", "B7");
        System.out.println(board);
    }

    public static Game getInstance() {
        if (uniqueGameInstance == null) {
            uniqueGameInstance = new Game();
        }
        return uniqueGameInstance;
    }

    public void askUserForShips() {

        ShipData[] ships = {new ShipData(1, new Carrier()),
                new ShipData(2, new Battleship()),
                new ShipData(3, new Submarine()),
                new ShipData(4, new PatrolBoat())};

        System.out.println("To enter the desired coordinates, please follow the following pattern: A5 A0");
        System.out.println("This is your board:\n");


        System.out.println(board);// print board to give user an idea

        Scanner scanner = new Scanner(System.in);

        //user is asked for desired coordinates of all ships
        for (ShipData currentShip : ships) {
            for (int j = 1; j <= currentShip.shipAmount; j++) {

                if (currentShip.shipAmount == 1) {// to ask for "Carrier" instead of "Carrier 1" when only 1 ship is needed
                    System.out.println("Please enter the position of your " + currentShip.shipType.getName() + ": ");
                }
                else {// if more than 1 ship of same type are needed
                    System.out.println("Please enter the position of your " + currentShip.shipType.getName() + " " + j + ": ");
                }

                String input = scanner.nextLine();// scanner for reading user input

                try {
                    if (!input.matches("[A-Z]\\d\\s[A-Z]\\d")) {// check for right format (eg. A0 A5)
                        throw new InvalidInputFormatException();
                    }
                } catch (InvalidInputException InvalidInput) {
                    j--;
                    continue;
                }

                int spacebar = input.indexOf(" ");// used for correct split of coordinates

                try {// add ship to board
                    board.addToBoard(getShipType(currentShip.shipType), input.substring(0, spacebar), input.substring(spacebar + 1));
                } catch (InvalidInputException InvalidInput) {
                    j--;
                }
            }  // repeats "do" loop if there was an invalid input

            System.out.println("Input accepted. This is your board:\n");// feedback
            System.out.println(board);// show user changes made
        }
        System.out.println("Input process finished.");

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
