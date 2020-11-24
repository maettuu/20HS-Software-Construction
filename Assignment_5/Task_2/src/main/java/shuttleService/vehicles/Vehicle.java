package shuttleService.vehicles;

import lombok.Getter;
import shuttleService.behaviors.combustionBehavior.CombustionBehavior;
import shuttleService.behaviors.luggageBehavior.LuggageBehavior;
import shuttleService.behaviors.priceBehavior.PriceBehavior;
import shuttleService.behaviors.speedBehavior.SpeedBehavior;

@Getter
public abstract class Vehicle {
    protected SpeedBehavior speedBehavior;
    protected CombustionBehavior combustionBehavior;
    protected PriceBehavior priceBehavior;
    protected LuggageBehavior luggageBehavior;
    protected String name;

    public void getStats() {
        System.out.printf("%s; %s; %s; %s; %s\n", getName(),
                getCombustionBehavior().getCombustion(),
                getLuggageBehavior().getLuggage(),
                getSpeedBehavior().getSpeed(),
                getPriceBehavior().getPrice());
    }
}
