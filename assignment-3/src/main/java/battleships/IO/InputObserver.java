package battleships.IO;

import java.util.ArrayList;

/**
 * All InputObservers will get notified by Input when there is a new input
 */
public abstract class InputObserver {

    Input input;

    public InputObserver(Input input){
        this.input = input;
        this.input.subscribe(this);
    }

    ArrayList<String> inputs = new ArrayList<>();

    /**
     * Update this observer and its data
     */
    public void update(String input){
        this.inputs.add(input);
    }

    /**
     * Request new input from Input
     */
    public void readInput(){
        this.input.readInput();
    }

    /**
     * Destroy this observer and remove it from the subject
     */
    public void destroy(){
        this.input.unsubscribe(this);
    }
}
