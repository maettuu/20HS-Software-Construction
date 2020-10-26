package main.java.battleships;

import main.java.battleships.Board;
import main.java.battleships.exceptions.InvalidInputException;
import main.java.battleships.exceptions.PositionOutOfBoardException;

import java.util.Scanner;

public class Coordinate {
    private int row;
    private int col;
    private String strCoord;
    private Board board;

    // Asks user for coordinate input until valid coordinates have been provided
    public Coordinate(Board board){
        this.strCoord = strCoord;
        this.board = board;
        Scanner scanner = new Scanner(System.in);
        int[] coords;

        boolean valid = false;
        while (!valid){
            String strCoord = scanner.nextLine();

            if(!strCoord.matches("[A-Z]\\d{1,3}")){
                System.out.println("Invalid coordinate pattern. Try again.");
                continue;
            }

            try{
                coords = stringToCoordinates(strCoord);
                this.row = coords[0];
                this.col = coords[1];
            }
            catch(InvalidInputException e){
                System.out.println(e);
                continue;
            }

            valid = true;

        }
//        scanner.close();

    }

    public Coordinate(Board board, String coordinates) throws InvalidInputException {
        this.board = board;
        int[] coords;

        strCoord = coordinates;

        if(!strCoord.matches("[A-Z]\\d{1,3}")){
            System.out.println("Invalid coordinate pattern. Try again.");
        }

        try{
            coords = stringToCoordinates(strCoord);
            this.row = coords[0];
            this.col = coords[1];
        }
        catch(InvalidInputException e){
            System.out.println(e);
        }
    }

    public Coordinate(Board board, int row, int col) throws InvalidInputException {
        if(row < 0 || row >= board.getRowLen() || col < 0 || col >= board.getColLen()){
            throw new PositionOutOfBoardException();
        }
        this.board = board;
        this.row = row;
        this.col = col;

    }




    int[] stringToCoordinates(String string) throws InvalidInputException {


        int col = (int) string.charAt(0) - 64; // 64 is the start of uppercase letters in the ASCI alphabet
        col -= 1; // subtract 1 because our arrays start at 0 not 1
        if (col < 0 || col >= this.board.getColLen()) {
            throw new PositionOutOfBoardException();
        }
        int row = Integer.parseInt(string.substring(1));
        if (row < 0 || row >= this.board.getRowLen()) {
            throw new PositionOutOfBoardException();
        }

        return new int[] { row, col };
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

}
