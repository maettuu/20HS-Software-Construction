package shuttleService.vehicles;

import shuttleService.behaviors.combustionBehavior.Gasoline;
import shuttleService.behaviors.luggageBehavior.Limited;
import shuttleService.behaviors.priceBehavior.PerHour;
import shuttleService.behaviors.speedBehavior.FastSpeed;

/**
 * Super car entity
 */
public class SuperCar extends Vehicle {

    /**
     * Super car constructor with specific parameters
     */
    public SuperCar() {
        combustionBehavior = new Gasoline();
        speedBehavior = new FastSpeed();
        priceBehavior = new PerHour(30);
        luggageBehavior = new Limited(1, 1);
        name = "Super Car";
    }
}
