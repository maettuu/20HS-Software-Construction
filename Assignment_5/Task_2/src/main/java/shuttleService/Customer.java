package shuttleService;

import shuttleService.vehicles.Vehicle;

import java.util.Calendar;

/**
 * Customer entity
 */
public class Customer {
    public Vehicle vehicle;
    public Calendar date;

    /**
     * Customer constructor
     * @param vehicle sets the customer's vehicle
     * @param date sets travel date
     */
    public Customer(Vehicle vehicle, Calendar date) {
        this.vehicle = vehicle;
        this.date = date;
    }

    /**
     * Make ride
     */
    public void ride() {
        vehicle.getStats();
    }
}
