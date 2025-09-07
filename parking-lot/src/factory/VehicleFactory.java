package factory;

import factory.vehicle.Bike;
import factory.vehicle.Car;
import factory.vehicle.Truck;
import factory.vehicle.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String licenseNumber) {
        if (vehicleType.equalsIgnoreCase("car")) {
            return new Car(licenseNumber);
        } else if (vehicleType.equalsIgnoreCase("bike")) {
            return new Bike(licenseNumber);
        } else {
            return new Truck(licenseNumber);
        }
    }
}
