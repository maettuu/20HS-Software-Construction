package main.java.battleships.exceptions;

public class InvalidInputFormatException extends InvalidInputException {
    public InvalidInputFormatException() {

        System.out.println("Please respect the given Format:");
        System.out.println("<uppercase letter><number> <uppercase letter><number>");
        System.out.println("Make sure there is only one space between the two coordinates and the letters are uppercase");
    }
}
