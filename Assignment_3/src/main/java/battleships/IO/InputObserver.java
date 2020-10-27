package main.java.battleships.IO;

import java.util.ArrayList;

public abstract class InputObserver {

    Input input;

    public InputObserver(Input input){
        this.input = input;
        this.input.subscribe(this);
    }

    ArrayList<String> inputs = new ArrayList<>();

    public void update(String input){
        this.inputs.add(input);
    }

    public void readInput(){
        this.input.readInput();
    }

    public void destroy(){
        this.input.unsubscribe(this);
    }
}
