package main.java.battleships;

import main.java.battleships.boardobjects.ships.*;
import main.java.battleships.exceptions.InvalidInputException;
import main.java.battleships.exceptions.InvalidInputFormatException;
import main.java.battleships.players.BotPlayer;
import main.java.battleships.players.HumanPlayer;
import main.java.battleships.players.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * The class Game has a Board and Ships. It can be used to initiate a game.
 */
public class Game {
    private static Game uniqueGameInstance;
    private boolean gameHasStarted;
    private Player p1;
    private Player bot;
    private Player bot2;
    private LinkedHashMap<String, Integer> shipList;


    // Default setup
    private Game() {
        shipList = new LinkedHashMap<String, Integer>();

        // setting boat types
        shipList.put("Carrier", 1);
        shipList.put("Battleship", 2);
        shipList.put("Submarine", 3);
        shipList.put("Patrol Boat", 4);
    }

    public static Game getInstance() {
        if (uniqueGameInstance == null) {
            uniqueGameInstance = new Game();
        }
        return uniqueGameInstance;
    }

    public void start(){
        if(gameHasStarted){
            System.out.println("Game is already in progress!");
            return;
        }

        p1 = new HumanPlayer(new Board(10, 10), shipList);
        bot = new HumanPlayer(new Board(10, 10), shipList);

        gameHasStarted = true;
        while(true){
            if(!p1.hasLost()){
                p1.attack(bot);
                p1.printBoard();
                bot.printBoardHidden();
            }
            if(!bot.hasLost()){
                bot.attack(p1);
            }
        }
    }

    // for testing
    public void startBotFight(){
        bot = new BotPlayer(new Board(10, 10), shipList);
        bot2 = new BotPlayer(new Board(10, 10), shipList);


        int i = 0;
        while(i < 100){
//        while(true){
            bot2.attack(bot);
            if(bot.hasLost()){
                break;
            }

            bot.attack(bot2);
            if(bot2.hasLost()){
                break;
            }
            i++;
        }
        bot.printBoard();
        bot.printBoardHidden();
        System.out.println("Game over!");

    }
}
