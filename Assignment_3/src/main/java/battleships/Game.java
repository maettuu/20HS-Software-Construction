package battleships;

import battleships.IO.Input;
import battleships.players.BotPlayer;
import battleships.players.HumanPlayer;
import battleships.players.Player;

import java.util.LinkedHashMap;


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
        System.out.println("\nWelcome to Battleship!!");

        Input input = new Input();
        p1 = new HumanPlayer(new Board(10, 10), shipList, input);
        bot = new BotPlayer(new Board(10, 10), shipList, input);
        gameHasStarted = true;

        System.out.println("The game now starts. Both of you take turns to attack the other player's board.\n" +
                "Hits are marked with an \"X\" and misses with an \"O\" on the board. The first one to sink all the" +
                " opponent's ships wins! For this you will be shown the empty board of your opponent where you are able to" +
                " see your own progress as well as your own board on which the opponent attacks.");

        while(true){
            p1.attack(bot);
            if(bot.hasLost()){break;}
            System.out.println("Your opponent's board now is:\n");
            bot.printBoardHidden();

            bot.attack(p1);
            if(p1.hasLost()){break;}
            System.out.println("Your board now is:\n");
            p1.printBoard();

            System.out.println("Your scoreboard:\nPlayer remaining boats: " + p1.shipsAlive() +
                    "\nEnemy boats alive: " + bot.shipsAlive());


        }
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
        System.out.println("How " + winner.getName() + " sees his board.");
        bot.printBoard();
        System.out.println("How " + winner.getName() + " sees his  opponent's board.");
        bot.printBoardHidden();
        System.out.println("Game over!");

    }
}
