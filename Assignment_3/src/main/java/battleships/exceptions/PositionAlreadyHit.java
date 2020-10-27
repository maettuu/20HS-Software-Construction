package battleships.exceptions;

public class PositionAlreadyHit extends InvalidInputException{
    @Override
    public String toString() {
        return "Position has already been hit before!";
    }
}
