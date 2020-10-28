package battleships.IO;

import battleships.Board;
import battleships.coordinates.Coordinate;
import battleships.exceptions.InvalidInputException;

import java.util.ArrayList;

/**
 * The Coordinate reader can read one or several coordinates from an InputStream
 */
public class CoordinateReader extends InputObserver {

    private ArrayList<Coordinate> coordinates;
    private Board board;
    private int count;

    public CoordinateReader(Board board, Input input,  int count){
        super(input);
        this.coordinates = new ArrayList<>();
        this.board = board;
        this.count = count;
    }

    int[] stringToInts(String string) throws InvalidInputException {
        int col = (int) string.charAt(0) - 64; // 64 is the start of uppercase letters in the ASCI alphabet
        col -= 1; // subtract 1 because our arrays start at 0 not 1

        int row = Integer.parseInt(string.substring(1));

        return new int[] { row, col };
    }

    @Override
    public void readInput() {
        this.coordinates = new ArrayList<>();
        boolean valid = false;
        while (!valid){
            super.readInput();
            String line = this.inputs.remove(this.inputs.size()-1);

            String singleCoordinateRegex = "[A-Z]\\d{1,3}";
            String regex = singleCoordinateRegex;

            for (int i = 1; i < this.count; i++){
                regex += "\\s" + regex;
            }

            if(!line.matches(regex)){
                System.out.println("Invalid coordinate pattern. Try again.");
                continue;
            }

            try{
                String[] coordsString = line.split("\\s");
                for (String coord : coordsString){
                    int[] coordsInt = stringToInts(coord);
                    this.coordinates.add(
                            new Coordinate(this.board,coordsInt[0], coordsInt[1]));
                }
            }
            catch(InvalidInputException e){
                System.out.println(e);
                continue;
            }

            valid = true;
        }
    }

    public Coordinate getCoordinate(int index){
        return coordinates.get(index);
    }
}
