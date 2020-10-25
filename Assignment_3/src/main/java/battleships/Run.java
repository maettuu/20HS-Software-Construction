package main.java.battleships;

import main.java.battleships.exceptions.InvalidInputException;
import java.util.Scanner;

public class Run {
    public static void main(String args[]) throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Battleship!!");
        System.out.println("Would you like to see a suggestion for a board? (Y/N)");
        String exampleY = scanner.nextLine();
        if (exampleY.equals("Y")) {
            Game game = new Game("example");
            System.out.println("Now you can create your own board.");
        }
        Game game = Game.getInstance();
    }
}
