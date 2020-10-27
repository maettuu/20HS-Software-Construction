package main.java.battleships.players;

import main.java.battleships.Board;
import main.java.battleships.Coordinate;
import main.java.battleships.IO.CoordinateReader;
import main.java.battleships.IO.Input;
import main.java.battleships.IO.StringReader;
import main.java.battleships.boardobjects.BoardObject;
import main.java.battleships.boardobjects.ships.Ship;
import main.java.battleships.boardobjects.ships.ShipFactory;
import main.java.battleships.exceptions.InvalidInputException;

import java.util.*;

public class HumanPlayer extends Player {

    Input input;
    public HumanPlayer(Board board, LinkedHashMap<String, Integer> ships, Input input){
        this.input = input;
        //Scanner scanner = new Scanner(System.in);

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
}
