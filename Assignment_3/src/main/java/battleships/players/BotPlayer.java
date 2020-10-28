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

        System.out.println("Give your opponent a name.");

        StringReader nameReader = new StringReader(input);
        nameReader.readInput();
        this.name = nameReader.getString();
        nameReader.destroy();

        this.ships = new LinkedHashMap<String, ArrayList<BoardObject>>();
        this.board = board;
        this.setShips(ships);
        this.addShips();
    }

    public void attack(Player player) {
        try{
            CoordinateIterator itr = this.board.generateCoordinateIterator(true, true);
            Coordinate c = itr.next();
            //Coordinate c = new Coordinate(board, (int) (Math.random() * 10), (int) (Math.random() * 10));
            player.takeHit(c);
        }catch(InvalidInputException e){
            // try again
            attack(player);
        }
    }

    public void addShips() {
        System.out.println("Player " + this.name + " is placing his ships...");
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
}
