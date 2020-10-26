package main.java.battleships;

import main.java.battleships.exceptions.InvalidInputException;
import main.java.battleships.players.BotPlayer;
import main.java.battleships.players.HumanPlayer;
import main.java.battleships.players.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Run {
    public static void main(String args[]) throws InvalidInputException {
        Game g = Game.getInstance();
        g.start();
        // g.startBotFight(); // if you just want to see a game between bots.
    }
}
