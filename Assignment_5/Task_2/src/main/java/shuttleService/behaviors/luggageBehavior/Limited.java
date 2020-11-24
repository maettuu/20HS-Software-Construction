package shuttleService.behaviors.luggageBehavior;

public class Limited implements LuggageBehavior {
    private int smallBags;
    private int largeBags;

    public Limited(int smallBags, int largeBags) {
        this.smallBags = smallBags;
        this.largeBags = largeBags;
    }

    @Override
    public String getLuggage() {
        if (largeBags == 0) {
            return smallBags + " small bag(s)";
        }
        if (smallBags == 0) {
            return largeBags + " large bag(s)";
        }
        return smallBags + " small bag(s) and " + largeBags + " large bag(s)";
    }
}
