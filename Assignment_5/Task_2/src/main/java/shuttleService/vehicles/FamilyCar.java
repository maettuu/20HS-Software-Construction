package shuttleService.vehicles;

import shuttleService.behaviors.combustionBehavior.Gasoline;
import shuttleService.behaviors.luggageBehavior.Limited;
import shuttleService.behaviors.priceBehavior.PerHour;
import shuttleService.behaviors.speedBehavior.NormalSpeed;

public class FamilyCar extends Vehicle {

    public FamilyCar() {
        combustionBehavior = new Gasoline();
        speedBehavior = new NormalSpeed();
        priceBehavior = new PerHour(15);
        luggageBehavior = new Limited(2, 2);
        name = "Family Car";
    }
}
