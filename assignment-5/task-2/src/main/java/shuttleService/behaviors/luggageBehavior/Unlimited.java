package shuttleService.behaviors.luggageBehavior;

/**
 * Unlimited luggage allowed
 */
public class Unlimited implements LuggageBehavior {

    /**
     * Get the amount of luggage allowed
     * @return always returns the same, unlimited luggage capacity
     */
    @Override
    public String getLuggage() {
        return "unlimited luggage capacity";
    }
}
