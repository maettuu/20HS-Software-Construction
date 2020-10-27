package battleships.players;

import battleships.Board;
import battleships.IO.CoordinateReader;
import battleships.IO.Input;
import battleships.IO.StringReader;
import battleships.boardobjects.BoardObject;
import battleships.exceptions.InvalidInputException;

import java.util.*;

public class HumanPlayer extends Player {

    Input input;
    public HumanPlayer(Board board, LinkedHashMap<String, Integer> ships){

        this.input = new Input();

        System.out.println("Enter your name.");

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
        System.out.println("Player " + this.name + ". Place your ships.");

        for(Map.Entry<String, ArrayList<BoardObject>> ships: this.ships.entrySet()){
            for(BoardObject ship: ships.getValue()){
                boolean valid = false;
                while(!valid){
                    System.out.println("Enter Ship Coordinates for " + ship.getName());
                    CoordinateReader coordinateReader = new CoordinateReader(this.board, this.input, 2);
                    coordinateReader.readInput();
                    try {
                        ship.addToBoard(
                                board,
                                coordinateReader.getCoordinate(0),
                                coordinateReader.getCoordinate(1));
                        coordinateReader.destroy();
                    }
                    catch (InvalidInputException e){
                        System.out.println(e);
                        valid = false;
                        continue;
                    }
                    valid = true;
                }
            }
        }
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
