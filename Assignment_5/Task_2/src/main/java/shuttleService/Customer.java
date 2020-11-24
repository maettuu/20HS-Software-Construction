package shuttleService;

import shuttleService.vehicles.Vehicle;

import java.util.Calendar;

public class Customer {
    public Vehicle vehicle;
    public Calendar date;

    public Customer(Vehicle vehicle, Calendar date) {
        this.vehicle = vehicle;
        this.date = date;
    }

    public void ride() {
        vehicle.getStats();
    }
}
