package shuttleService.vehicles;

import shuttleService.behaviors.combustionBehavior.Diesel;
import shuttleService.behaviors.luggageBehavior.Unlimited;
import shuttleService.behaviors.priceBehavior.Constant;
import shuttleService.behaviors.speedBehavior.SlowSpeed;

public class Bus extends Vehicle {

    public Bus() {
        combustionBehavior = new Diesel();
        speedBehavior = new SlowSpeed();
        priceBehavior = new Constant(5);
        luggageBehavior = new Unlimited();
        name = "Bus";
    }
}
