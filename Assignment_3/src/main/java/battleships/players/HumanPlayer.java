package battleships.players;

import battleships.Board;
import battleships.IO.CoordinateReader;
import battleships.IO.Input;
import battleships.IO.StringReader;
import battleships.players.BotPlayer;
import battleships.boardobjects.BoardObject;
import battleships.exceptions.InvalidInputException;

import java.util.*;

public class HumanPlayer extends Player {

    public HumanPlayer(Board board, LinkedHashMap<String, Integer> ships, Input input){

        this.input = input;

        System.out.println("\nPlease enter your name.");
        StringReader nameReader = new StringReader(this.input);
        nameReader.readInput();
        this.name = nameReader.getString();
        nameReader.destroy();

        this.ships = new LinkedHashMap<String, ArrayList<BoardObject>>();
        this.sunkShips = new LinkedHashMap<String, ArrayList<BoardObject>>();
        this.board = board;
        this.setShips(ships);
        this.example();
        System.out.println("Please keep in mind that to enter the desired coordinates you must follow a pattern (e.g. A5 A0).");
        this.addShips();
    }

    public void example() {
        System.out.println("Hello " + this.name + ". To play Battleship you must first place all ships on your board.");
        System.out.println("This is your empty board:\n");
        this.printBoard();
        System.out.println("Before you start placing your ships, would you like to see a suggestion for a board? (y/n)");
        StringReader answer = new StringReader(this.input);
        answer.readInput();
        if (answer.getString().equals("y")) {
            System.out.println("This is an example of how the board could look like:\n");
            Player bot = new BotPlayer(new Board(10, 10), this.ships, this.input, "ExampleBot");
            System.out.println("Now you can start placing the ships on your own board.");
        }
        answer.destroy();
    }

    public void addShips(){
        CoordinateReader coordinateReader = new CoordinateReader(this.board, this.input, 2);
        for(Map.Entry<String, ArrayList<BoardObject>> ships: this.ships.entrySet()){
            int shipAmount = ships.getValue().size();
            int shipCounter = 1;
            for(BoardObject ship: ships.getValue()){
                boolean valid = false;
                while(!valid){
                    if (shipAmount == 1) {
                        System.out.println("Please enter the desired coordinates for your " + ship.getName() +
                                " (length: " + ship.getLength() + ").");
                    }
                    else {
                        System.out.println("Please enter the desired coordinates for your " + ship.getName() +
                                " " + shipCounter + " (length: " + ship.getLength() + ").");
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
                if (!player.isShipDestroyed()) {
                    System.out.println("You hit a ship!");
                }
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
                    System.out.println("Your " + currentShip.getName() + " was destroyed.");
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
