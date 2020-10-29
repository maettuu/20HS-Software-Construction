package battleships.exceptions;

public class PositionAlreadyHit extends InvalidInputException{
    @Override
    public String toString() {
        return "This position has already been hit before, please try again!";
    }
}
