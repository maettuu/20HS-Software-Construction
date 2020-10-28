package battleships.players;

import battleships.Board;
import battleships.IO.CoordinateReader;
import battleships.IO.Input;
import battleships.IO.StringReader;
import battleships.boardobjects.BoardObject;
import battleships.exceptions.InvalidInputException;

import java.util.*;

public class HumanPlayer extends Player {

    public HumanPlayer(Board board, LinkedHashMap<String, Integer> ships, Input input){

        this.input = input;

        System.out.println("Please enter your name.");

        StringReader nameReader = new StringReader(input);
        nameReader.readInput();
        this.name = nameReader.getString();
        nameReader.destroy();

        this.ships = new LinkedHashMap<String, ArrayList<BoardObject>>();
        this.board = board;
        this.setShips(ships);
        this.addShips();
    }

    public void addShips(){
        System.out.println("Hello " + this.name + ". To play Battleship you must first create your own board to place your ships.");
        System.out.println("For this you need to enter the desired coordinates (e.g. A5 A0)");
        System.out.println("This is your empty board:\n");
        this.printBoard();

        CoordinateReader coordinateReader = new CoordinateReader(this.board, this.input, 2);
        for(Map.Entry<String, ArrayList<BoardObject>> ships: this.ships.entrySet()){
            int shipAmount = ships.getValue().size();
            int shipCounter = 1;
            for(BoardObject ship: ships.getValue()){
                boolean valid = false;
                while(!valid){
                    if (shipAmount == 1) {
                        System.out.println("Please enter the desired coordinates for your " + ship.getName() + ".");
                    }
                    else {
                        System.out.println("Please enter the desired coordinates for your " + ship.getName() +
                                " " + shipCounter + ".");
                    }
                    coordinateReader.readInput();
                    try {
                        ship.addToBoard(
                                board,
                                coordinateReader.getCoordinate(0),
                                coordinateReader.getCoordinate(1));
                    }
                    catch (InvalidInputException e){
                        System.out.println(e);
                        valid = false;
                        continue;
                    }
                    valid = true;
                }
                shipCounter++;

                System.out.println("Input accepted. This is your current board:\n");
                this.printBoard();
            }
        }
        coordinateReader.destroy();

        System.out.println("Thank you! Your board is now complete.\n");
    }

    public void attack(Player player){
        System.out.println("Please enter the coordinates you would like to hit on the opponent's board (e.g. A0)");
        try{
            CoordinateReader coordinateReader = new CoordinateReader(this.board, this.input, 1);
            coordinateReader.readInput();
            if (player.takeHit(coordinateReader.getCoordinate(0))) {
                System.out.println("Hit!");
            }
            else {
                System.out.println("Miss.");
            }
            coordinateReader.destroy();
        }catch(InvalidInputException e){
            System.out.println(e);
            attack(player);
        }
    }
}
