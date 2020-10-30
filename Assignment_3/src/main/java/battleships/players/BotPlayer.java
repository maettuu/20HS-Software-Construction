package battleships.players;

import battleships.Board;
import battleships.IO.Input;
import battleships.IO.StringReader;
import battleships.coordinates.Coordinate;
import battleships.boardobjects.BoardObject;
import battleships.coordinates.CoordinateIterator;
import battleships.exceptions.InvalidInputException;

import java.util.*;

public class BotPlayer extends Player {

    public BotPlayer(Board board, LinkedHashMap<String, Integer> ships, Input input) {

        this.input = input;

        System.out.println("Please enter the name of your virtual opponent.");

        StringReader nameReader = new StringReader(input);
        nameReader.readInput();
        this.name = nameReader.getString();
        nameReader.destroy();

        this.ships = new LinkedHashMap<String, ArrayList<BoardObject>>();
        this.sunkShips = new LinkedHashMap<String, ArrayList<BoardObject>>();
        this.board = board;
        this.setShips(ships);
        System.out.println(this.name + " is working on his/her board...");
        this.addShips();
        System.out.println(this.name + " has finished.\n");
    }

    public BotPlayer(Board board, LinkedHashMap<String, ArrayList<BoardObject>> ships, Input input, String name) {
        this.input = input;
        this.name = name;
        this.ships = ships;
        this.board = board;
        this.addShips();
        this.printBoard();
    }

    public void addShips() {
        for (Map.Entry<String, ArrayList<BoardObject>> ships : this.ships.entrySet()) {
            for (BoardObject ship : ships.getValue()) {
                boolean valid = false;
                while (!valid) {
                    int[] vals = { 0, 0, 0, 0 };
                    try {
                        if (Math.random() < 0.5) {
                            vals[0] = (int) (Math.random() * 9);
                            vals[1] = (int) (Math.random() * 9);
                            vals[2] = vals[0];
                            vals[3] = vals[1] + ship.getLength() - 1;
                        } else {
                            vals[0] = (int) (Math.random() * 9);
                            vals[1] = (int) (Math.random() * 9);
                            vals[2] = vals[0] + ship.getLength() - 1;
                            vals[3] = vals[1];
                        }
                        Coordinate cStart = new Coordinate(board, vals[0], vals[1]);
                        Coordinate cEnd = new Coordinate(board, vals[2], vals[3]);
                        ship.addToBoard(board, cStart, cEnd);
                        valid = true;
                    } catch (InvalidInputException e) {
                        valid = false;
                    }
                }
            }
        }
    }

    public void attack(Player player) {
        System.out.println(this.name + " is attacking...");
        try{
            CoordinateIterator itr = this.board.generateCoordinateIterator(true, true);
            Coordinate c = itr.next();
            //Coordinate c = new Coordinate(board, (int) (Math.random() * 10), (int) (Math.random() * 10));
            boolean hit = player.takeHit(c);
            System.out.println(this.name + " attacked " + c.toString());
            if (hit) {
                if (!player.isShipDestroyed()) {
                    System.out.println("Your ship was hit.");
                }
            }
            else {
                System.out.println(this.name + " has missed!");
            }
        }catch(InvalidInputException e){
            // try again
            attack(player);
        }
    }

    public boolean isShipDestroyed() {
        boolean shipDestroyed = false;
        for(HashMap.Entry<String, ArrayList<BoardObject>> shipPair: this.ships.entrySet()){
            Iterator<BoardObject> shipIterator = shipPair.getValue().iterator();
            while(shipIterator.hasNext()) {
                BoardObject currentShip = shipIterator.next();
                if (!currentShip.isIntact()){
                    shipDestroyed = true;
                    if(!this.sunkShips.containsKey(shipPair.getKey())) {
                        this.sunkShips.put(shipPair.getKey(), new ArrayList<BoardObject>());
                    }
                    this.sunkShips.get(shipPair.getKey()).add(currentShip);
                    System.out.println("You destroyed a " + currentShip.getName());
                    shipIterator.remove();
                }
            }
            if (shipPair.getKey().isEmpty()) {
                this.ships.remove(shipPair.getKey());
            }
        }
        return shipDestroyed;
    }
}
