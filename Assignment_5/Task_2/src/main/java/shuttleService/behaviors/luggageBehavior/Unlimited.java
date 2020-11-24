package shuttleService.behaviors.luggageBehavior;

public class Unlimited implements LuggageBehavior {

    @Override
    public String getLuggage() {
        return "unlimited luggage capacity";
    }
}
