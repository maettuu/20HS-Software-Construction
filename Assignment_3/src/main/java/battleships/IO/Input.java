package main.java.battleships.IO;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Multiple observers, one subject
 * This is the observer subject which handles I/O
 */
public class Input extends Thread {

    ArrayList<InputObserver> observers;
    InputStream input;
    Scanner scanner;

    public Input(){
        this.input = System.in;
        this.scanner = new Scanner(this.input);
        observers = new ArrayList<>();
    }

    public Input(InputStream in){
        this.input = in;
        this.scanner = new Scanner(this.input);
        observers = new ArrayList<>();
    }

    public void subscribe(InputObserver observer){
        this.observers.add(observer);
    }

    public void unsubscribe(InputObserver observer){
        this.observers.remove(observer);
    }

    public void readInput(){
        String line = this.scanner.nextLine();
        this.notifyObservers(line);
    }

    private void notifyObservers(String line){
        for (InputObserver observer: this.observers){
            observer.update(line);
        }
    }
}
