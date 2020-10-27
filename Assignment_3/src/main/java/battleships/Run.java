package battleships;

import battleships.exceptions.InvalidInputException;
import battleships.players.BotPlayer;
import battleships.players.HumanPlayer;
import battleships.players.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Run {
    public static void main(String args[]) throws InvalidInputException {
        Game g = Game.getInstance();
        g.start();
        // g.startBotFight(); // if you just want to see a game between bots.
    }
}
