package parkingspots;

import enums.VehicleSize;
import factory.vehicle.Car;
import factory.vehicle.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getSize() == VehicleSize.MEDIUM;
    }
}
