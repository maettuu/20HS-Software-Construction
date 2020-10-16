package main.java.battleships;

import main.java.battleships.boardobjects.ships.*;
import main.java.battleships.exceptions.InvalidInputException;
import main.java.battleships.exceptions.InvalidInputFormatException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private Board board;
    private int nBattleships;
    private int nCarriers;
    private int nPatrolBoats;
    private int nSubmarines;

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
    public Game() {
        this.nCarriers = 1;
        this.nBattleships = 2;
        this.nSubmarines = 3;
        this.nPatrolBoats = 4;

        board = new Board(10, 10);
        this.askUserForShips();
    }

    // Custom setup
    public Game(int nBattleships, int nCarriers, int nPatrolBoats, int nSubmarines) {
        this.nBattleships = nBattleships;
        this.nCarriers = nCarriers;
        this.nPatrolBoats = nPatrolBoats;
        this.nSubmarines = nSubmarines;

        board = new Board(10, 10);
        this.askUserForShips();
    }

    // example setup
    public Game(String e) throws InvalidInputException {
        System.out.println("This is an example of how the board can look like:\n");
        board = new Board(10,10);
        board.addToBoard(new Carrier(1), "E9", "J9");
        board.addToBoard(new Battleship(1), "G0", "J0");
        board.addToBoard(new Battleship(2), "A2", "A5");
        board.addToBoard(new Submarine(1), "D0", "D2");
        board.addToBoard(new Submarine(2), "F2", "H2");
        board.addToBoard(new Submarine(3), "J5", "J7");
        board.addToBoard(new PatrolBoat(1), "A0", "B0");
        board.addToBoard(new PatrolBoat(2), "J2", "J3");
        board.addToBoard(new PatrolBoat(3), "F5", "F6");
        board.addToBoard(new PatrolBoat(4), "A7", "B7");
        System.out.println(board);
    }

    public void askUserForShips() {
        System.out.println("To enter the desired coordinates, please follow the following pattern: A5 A0");
        System.out.println("This is your board:\n");

        ArrayList<Ship> ships = new ArrayList<Ship>(); // array list with all ships

        // add ships to list
        for (int i = 0; i < this.nCarriers; i++)
            ships.add(new Carrier(i+1));

        for (int i = 0; i < this.nBattleships; i++)
            ships.add(new Battleship(i+1));

        for (int i = 0; i < this.nSubmarines; i++)
            ships.add(new Submarine(i+1));

        for (int i = 0; i < this.nPatrolBoats; i++)
            ships.add(new PatrolBoat(i+1));

        System.out.println(board);// print board to give user an idea

        Scanner scanner = new Scanner(System.in);

        //user is asked for desired coordinates of all ships
        for (Ship currentShip : ships) {
            boolean invalidInput = false;

            do {
                invalidInput = false;
                System.out.println("Please enter the position of your " + currentShip.getName() + " " + currentShip.getId() +
                        " of length " + currentShip.getLength() + ":");

                String input = scanner.nextLine();// scanner for reading user input

                try {
                    if (!input.matches("[A-Z]\\d\\s[A-Z]\\d")) {// check for right format (eg. A0 A5)
                        throw new InvalidInputFormatException();
                    }
                } catch (InvalidInputException InvalidInput) {
                    invalidInput = true;
                    continue;
                }

                int spacebar = input.indexOf(" ");// used for correct split of coordinates

                try {// add ship to board
                    board.addToBoard(currentShip, input.substring(0, spacebar), input.substring(spacebar + 1));
                } catch (InvalidInputException InvalidInput) {
                    invalidInput = true;
                }
            } while (invalidInput); // repeats "do" loop if there was an invalid input

            System.out.println("Input accepted. This is your board:\n");// feedback
            System.out.println(board);// show user changes made
        }
        System.out.println("Input process finished.");

        scanner.close();
    }
}
