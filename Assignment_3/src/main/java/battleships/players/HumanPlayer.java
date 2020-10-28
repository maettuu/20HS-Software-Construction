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
        System.out.println("Hello " + this.name + ". To play Battleship you must first create your own board and place your ships.");

        CoordinateReader coordinateReader = new CoordinateReader(this.board, this.input, 2);
        for(Map.Entry<String, ArrayList<BoardObject>> ships: this.ships.entrySet()){
            int shipAmount = ships.getValue().size();
            int shipCounter = 1;
            for(BoardObject ship: ships.getValue()){
                boolean valid = false;
                while(!valid){
                    if (shipAmount == 1) {
                        System.out.println("Please enter the desired ship coordinates for your " + ship.getName() + ".");
                    }
                    else {
                        System.out.println("Please enter the desired ship coordinates for your " + ship.getName() +
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
            }
        }
        coordinateReader.destroy();
    }

    public void attack(Player player){
        System.out.println("Enter the position you want to attack!");
        try{
            CoordinateReader coordinateReader = new CoordinateReader(this.board, this.input, 1);
            coordinateReader.readInput();
            player.takeHit(coordinateReader.getCoordinate(0));
            coordinateReader.destroy();
        }catch(InvalidInputException e){
            System.out.println(e);
            attack(player);
        }
    }
}
