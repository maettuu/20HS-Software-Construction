package battleships;

import battleships.IO.Input;
import battleships.players.BotPlayer;
import battleships.players.HumanPlayer;
import battleships.players.Player;

import java.util.LinkedHashMap;
import java.util.HashMap;


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
            System.out.println("The game is already in progress!");
            return;
        }
        welcome();
        playerGeneration();
        play();
    }

    private void welcome() {
        System.out.println("\nWelcome to Battleship!!");
        System.out.println("For this game the selected ships are as follows:");
        for (HashMap.Entry<String, Integer> ship : shipList.entrySet()) {
            if (ship.getValue() == 1) {
                System.out.println(" - " + ship.getValue() + " " + ship.getKey());
            }
            else {
                System.out.println(" - " + ship.getValue() + " " + ship.getKey() + "s");
            }
        }
    }

    private void playerGeneration() {
        Input input = new Input();
        p1 = new HumanPlayer(new Board(10, 10), shipList, input);
        bot = new BotPlayer(new Board(10, 10), shipList, input);
        gameHasStarted = true;

        System.out.println("The game now starts. Both of you take turns to attack the other player's board.\n" +
                "Hits are marked with an \"X\" and misses with an \"O\" on the board. The first one to sink all the" +
                " opponent's ships wins!\nFor this you will be shown the empty board of your opponent where you are able to" +
                " see your own progress\nas well as your own board on which the opponent attacks.\n");
    }

    private void play() {
        while(true) {
            p1.attack(bot);
            bot.isShipDestroyed();
            if (bot.hasLost()) {
                System.out.println("Congratulations, you won! Here's your opponent's board:\n");
                bot.printBoard();
                break;
            }
            System.out.println("Here's what you know about your opponent's board:\n");
            bot.printBoardHidden();

            bot.attack(p1);
            p1.isShipDestroyed();
            if (p1.hasLost()) {
                System.out.println("Your opponent has hit all your ships. You lost :( Here's your board:\n");
                p1.printBoard();
                break;
            }
            System.out.println("Your board now is:\n");
            p1.printBoard();

            System.out.println("Your scoreboard:\n - Player remaining boats: " + p1.shipsAlive() +
                    "\n - Enemy boats destroyed: " + bot.shipsDestroyed() + "\n");
        }
    }

    public void end() {
        uniqueGameInstance = null;
    }

    // for testing
    public void startBotFight(){
        Input input = new Input();
        bot = new BotPlayer(new Board(10, 10), shipList, input);
        bot2 = new BotPlayer(new Board(10, 10), shipList, input);


        int i = 0;
        while(i < 10){
//        while(true){
            bot2.attack(bot);
            if(bot.hasLost()){break;}

            bot.attack(bot2);
            if(bot2.hasLost()){break;}

            i++;
        }
        Player winner = bot2.hasLost() ? bot : bot2;
        System.out.println("The winner is " + winner.getName());
        System.out.println("How " + winner.getName() + " sees the own board.");
        bot.printBoard();
        System.out.println("How " + winner.getName() + " sees the opponent's board.");
        bot.printBoardHidden();
        System.out.println("Game over!");

    }
}
