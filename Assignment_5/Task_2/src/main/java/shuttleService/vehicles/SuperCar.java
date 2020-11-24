package shuttleService.vehicles;

import shuttleService.behaviors.combustionBehavior.Gasoline;
import shuttleService.behaviors.luggageBehavior.Limited;
import shuttleService.behaviors.priceBehavior.PerHour;
import shuttleService.behaviors.speedBehavior.FastSpeed;

public class SuperCar extends Vehicle {

    public SuperCar() {
        combustionBehavior = new Gasoline();
        speedBehavior = new FastSpeed();
        priceBehavior = new PerHour(30);
        luggageBehavior = new Limited(1, 1);
        name = "Super Car";
    }
}
