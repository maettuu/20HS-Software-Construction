package battleships.IO;

import battleships.IO.InputObserver;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This is the Observer Subject of the Input handling
 *
 * It will notify all subscribed observer objects when there is
 * a new input read.
 */
public class Input extends Thread {

    ArrayList<InputObserver> observers;
    InputStream input;
    Scanner scanner;

    /**
     * Default constructor with the standart sytem in as InputStream
     */
    public Input(){
        this.input = System.in;
        this.scanner = new Scanner(this.input);
        observers = new ArrayList<>();
    }

    /**
     * Constructor with custom InputStream, can be used for example in testing
     * @param in Custom InputStream
     */
    public Input(InputStream in){
        this.input = in;
        this.scanner = new Scanner(this.input);
        observers = new ArrayList<>();
    }

    /**
     * Add observer
     * @param observer
     */
    public void subscribe(InputObserver observer){
        this.observers.add(observer);
    }

    /**
     * Remove observer
     * @param observer
     */
    public void unsubscribe(InputObserver observer){
        this.observers.remove(observer);
    }

    /**
     * Read new input
     */
    public void readInput(){
        String line = this.scanner.nextLine();
        this.notifyObservers(line);
    }

    /**
     * Notify all subscribed observers
     * @param line
     */
    private void notifyObservers(String line){
        for (InputObserver observer: this.observers){
            observer.update(line);
        }
    }
}
