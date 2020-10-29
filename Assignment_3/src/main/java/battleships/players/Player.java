package battleships.players;

import battleships.Board;
import battleships.IO.Input;
import battleships.coordinates.Coordinate;
import battleships.boardobjects.BoardObject;
import battleships.boardobjects.ships.ShipFactory;
import battleships.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public abstract class Player {
    protected String name;
    protected Board board;
    protected Input input;
    protected LinkedHashMap<String, ArrayList<BoardObject>> ships;
    protected LinkedHashMap<String, ArrayList<BoardObject>> sunkShips;


    public abstract void attack(Player player);

    public abstract void isShipDestroyed();

    public boolean takeHit(Coordinate coordinates) throws InvalidInputException {
        return board.hit(coordinates);
    }

    public void setShips(LinkedHashMap<String, Integer> ships) {
        // creating hashmap with concrete ships
        // for key, value in ships = {"Patrol Boat": 4}
        for(HashMap.Entry<String, Integer> ship: ships.entrySet()){
            // for i in range(len(value))
            for(int i = 0; i < ship.getValue(); i++){
                if(!this.ships.containsKey(ship.getKey())){
                    this.ships.put(ship.getKey(), new ArrayList<BoardObject>());
                }
                this.ships.get(ship.getKey()).add(ShipFactory.get(ship.getKey()));
            }
        }
    }

    public int shipsAlive(){
        int size = 0;
        for(ArrayList<BoardObject> shipList: ships.values()){
            size += shipList.size();
        }
        return size;
    }

    public int shipsDestroyed(){
        int size = 0;
        for(ArrayList<BoardObject> shipList: sunkShips.values()){
            size += shipList.size();
        }
        return size;
    }

    public abstract void addShips();
    
    public boolean hasLost(){
        return ships.isEmpty();
    }

    public void printBoard(){
        System.out.println(board.toString(false));
    }

    public void printBoardHidden(){
        System.out.println(board.toString(true));
    }

    public String getName(){
        return this.name;
    }

}
