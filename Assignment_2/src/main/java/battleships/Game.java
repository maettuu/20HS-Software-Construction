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
        this.nBattleships = 1;
        this.nCarriers = 2;
        this.nPatrolBoats = 3;
        this.nSubmarines = 4;

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

    public void start() {
        System.out.println(board);
    }

    public void askUserForShips() {
        System.out.println("Welcome to Battleship!!");
        System.out.println("To enter the desired coordinates, please follow the following pattern: A5 A0\n");

        ArrayList<Ship> ships = new ArrayList<Ship>();

        for (int i = 0; i < this.nBattleships; i++)
            ships.add(new Battleship(i+1));

        for (int i = 0; i < this.nCarriers; i++)
            ships.add(new Carrier(i+1));

        for (int i = 0; i < this.nPatrolBoats; i++)
            ships.add(new PatrolBoat(i+1));

        for (int i = 0; i < this.nSubmarines; i++)
            ships.add(new Submarine(i+1));


        Scanner scanner = new Scanner(System.in);

        //user is asked for desired coordinates of all ships
        for (Ship currentShip : ships) {
            boolean invalidInput = false;
            System.out.println(board);

            do {
                invalidInput = false;
                System.out.println("Please enter the position of your " + currentShip.getName() + " " + (currentShip.getId()) +
                        " of length " + currentShip.getLength() + ":") ;

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
            } while (invalidInput);

            System.out.println("Success!");

        }
        scanner.close();
    }
}
