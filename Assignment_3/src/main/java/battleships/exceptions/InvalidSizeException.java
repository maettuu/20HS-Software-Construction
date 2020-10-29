package battleships.exceptions;

public class InvalidSizeException extends InvalidInputException {
    String shipName;
    int shipSize;

    public InvalidSizeException(String shipName,  int shipSize){
        this.shipName = shipName;
        this.shipSize = shipSize;
    }

    public String toString(){
        switch (this.shipName) {
            case "C" :
                return("A Carrier must have a size of " + shipSize + ". Please try again!");
            case "B" :
                return("A Battleship must have a size of " + shipSize + ". Please try again!");
            case "S" :
                return("A Submarine must have a size of " + shipSize + ". Please try again!");
            case "P" :
                return("A Patrol boat must have a size of " + shipSize + ". Please try again!");
            default :
                return("Please respect the given lengths for ships");
        }
    }
}
