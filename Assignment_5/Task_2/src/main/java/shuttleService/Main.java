package shuttleService;

import shuttleService.vehicles.Bus;
import shuttleService.vehicles.FamilyCar;
import shuttleService.vehicles.MicroCar;
import shuttleService.vehicles.SuperCar;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Customer customerBus = new Customer(new Bus(), Calendar.getInstance());
        customerBus.ride();

        Customer customerMicro = new Customer(new MicroCar(), Calendar.getInstance());
        customerMicro.ride();

        Customer customerFamily = new Customer(new FamilyCar(), Calendar.getInstance());
        customerFamily.ride();

        Customer customerSuper = new Customer(new SuperCar(), Calendar.getInstance());
        customerSuper.ride();
    }
}
