package battleships.exceptions;

public class NotInStraightLineException extends InvalidInputException {
    public String toString() {
        return "All boats must be either horizontal or vertical, please try again!";
    }
}
