package factory.vehicle;

import enums.VehicleSize;

public class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleSize.MEDIUM);
    }
}
