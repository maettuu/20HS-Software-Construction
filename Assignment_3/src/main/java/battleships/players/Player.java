package main.java.battleships.players;

import main.java.battleships.Board;
import main.java.battleships.Coordinate;
import main.java.battleships.boardobjects.BoardObject;
import main.java.battleships.boardobjects.ships.ShipFactory;
import main.java.battleships.exceptions.InvalidInputException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Player {
    protected String name;
    protected Board board;
    protected LinkedHashMap<String, ArrayList<BoardObject>> ships;


    public void attack(Player player){
        System.out.println("Enter the position you want to attack!");
        try{
            Coordinate c = new Coordinate(board);
            player.takeHit(c);
        }catch(InvalidInputException e){
            System.out.println(e);
            attack(player);
        }
    }

    public void takeHit(Coordinate coordinates) throws InvalidInputException {
        board.hit(coordinates);
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
            for(BoardObject ship: shipList){
                if (ship.isIntact()){
                    size++;
                }
            }
        }
        return size;
    }

    public abstract void addShips();
    
    public boolean hasLost(){
        for(ArrayList<BoardObject> ships: ships.values()){
            for(BoardObject ship: ships){
                if(ship.isIntact()){
                    return false;
                }
            }
        }
        return true;
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
