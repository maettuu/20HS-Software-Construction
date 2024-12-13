package shuttleService.vehicles;

import shuttleService.behaviors.combustionBehavior.Electric;
import shuttleService.behaviors.luggageBehavior.Limited;
import shuttleService.behaviors.priceBehavior.PerHour;
import shuttleService.behaviors.speedBehavior.NormalSpeed;

/**
 * Micro car entity
 */
public class MicroCar extends Vehicle {

    /**
     * Micro car constructor with specific parameters
     */
    public MicroCar() {
        combustionBehavior = new Electric();
        speedBehavior = new NormalSpeed();
        priceBehavior = new PerHour(12);
        luggageBehavior = new Limited(1, 0);
        name = "Micro Car";
    }
}
