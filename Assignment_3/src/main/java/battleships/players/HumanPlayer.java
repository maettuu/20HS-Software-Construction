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
            Scanner scanner = new Scanner(System.in);
            for(BoardObject ship: ships.getValue()){
                System.out.println("Enter Ship Coordinates for " + ship.getName());
                String c = "";
                int spaceIdx = 0;
                while(!c.matches("[A-Z]\\d{1,3}\\s[A-Z]\\d{1,3}")){
                    c = scanner.nextLine();
                    spaceIdx = c.indexOf(" ");
                    String startStr = c.substring(0, spaceIdx);
                    String endStr = c.substring(spaceIdx+1);
                    try{
                        Coordinate start = new Coordinate(board, startStr);
                        Coordinate end = new Coordinate(board, endStr);
                        ship.addToBoard(board, start, end);
                    }catch(InvalidInputException e){
                        c = "";
                        System.out.println(e);
                    }
                }
            }
        }
    }
}
