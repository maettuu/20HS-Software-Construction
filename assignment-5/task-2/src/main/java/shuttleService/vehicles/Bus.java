package shuttleService.vehicles;

import shuttleService.behaviors.combustionBehavior.Diesel;
import shuttleService.behaviors.luggageBehavior.Unlimited;
import shuttleService.behaviors.priceBehavior.Constant;
import shuttleService.behaviors.speedBehavior.SlowSpeed;

/**
 * Bus entity
 */
public class Bus extends Vehicle {

    /**
     * Bus constructor with specific parameters
     */
    public Bus() {
        combustionBehavior = new Diesel();
        speedBehavior = new SlowSpeed();
        priceBehavior = new Constant(5);
        luggageBehavior = new Unlimited();
        name = "Bus";
    }
}
