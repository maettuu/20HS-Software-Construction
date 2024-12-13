package shuttleService.behaviors.luggageBehavior;

/**
 * A customer can only bring a limited amount of luggage
 */
public class Limited implements LuggageBehavior {
    private int smallBags;
    private int largeBags;

    /**
     * Set the number of small and large bags
     * @param smallBags set number of small bags as int
     * @param largeBags set number of large bags as int
     */
    public Limited(int smallBags, int largeBags) {
        this.smallBags = smallBags;
        this.largeBags = largeBags;

        if (smallBags < 0 || largeBags < 0){
            throw new IllegalArgumentException("Number of bags must be greater or equal to 0");
        }
    }

    /**
     * Get the amount of allowed luggage as a string
     */
    @Override
    public String getLuggage() {
        if (smallBags == 0 && largeBags == 0) {
            return "no bags allowed";
        }
        if (largeBags == 0) {
            return smallBags + " small bag(s)";
        }
        if (smallBags == 0) {
            return largeBags + " large bag(s)";
        }
        return smallBags + " small bag(s) and " + largeBags + " large bag(s)";
    }
}
