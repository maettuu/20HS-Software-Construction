package SoftCon2020_Assignment_2.battleships.exceptions;

public class InvalidSizeException extends InvalidInputException {
    public InvalidSizeException() {
        System.out.println("Please respect the given lengths for boats:");
        System.out.println("Carrier: 6\nBattleship: 4\nSubmarine: 3\nPatrol Boats: 2");
    }
}
