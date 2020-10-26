package main.java.battleships.exceptions;

public class InvalidInputFormatException extends InvalidInputException {
    public String toString() {
        return "Please respect the given Format:\n" +
                "<uppercase letter><number> <uppercase letter><number>\n" +
                "Make sure there is only one space between the two coordinates and the letters are uppercase";
    }
}
