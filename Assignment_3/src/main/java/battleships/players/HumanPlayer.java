package main.java.battleships.players;

import main.java.battleships.Board;
import main.java.battleships.Coordinate;
import main.java.battleships.boardobjects.BoardObject;
import main.java.battleships.boardobjects.ships.Ship;
import main.java.battleships.boardobjects.ships.ShipFactory;
import main.java.battleships.exceptions.InvalidInputException;

import java.util.*;

public class HumanPlayer extends Player {


    public HumanPlayer(Board board, LinkedHashMap<String, Integer> ships){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name.");
        this.name = scanner.nextLine();
        this.ships = new LinkedHashMap<String, ArrayList<BoardObject>>();
        this.board = board;
        this.setShips(ships);
        this.addShips();
    }

    public void addShips(){
        System.out.println("Player " + this.name + ". Place your ships.");
        for(Map.Entry<String, ArrayList<BoardObject>> ships: this.ships.entrySet()){
            for(BoardObject ship: ships.getValue()){
                System.out.println("Enter Ship Coordinates for " + ship.getName());

                boolean valid = false;
                while(!valid){
                    try{
                        Coordinate start = new Coordinate(board);
                        Coordinate end = new Coordinate(board);
                        ship.addToBoard(board, start, end);
                        valid = true;
                    }catch(InvalidInputException e){
                        System.out.println(e);
                    }
                }
                System.out.println(board);
            }
        }
    }
}
