package battleships.IO;

/**
 * The string reader can read a single string input
 */
public class StringReader extends InputObserver {

    public StringReader(Input input){
        super(input);
    }

    public String getString(){
        return this.inputs.remove(this.inputs.size()-1);
    }
}
