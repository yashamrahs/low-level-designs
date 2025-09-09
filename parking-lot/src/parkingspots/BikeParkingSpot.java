package parkingspots;

import enums.VehicleSize;
import factory.vehicle.Vehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getSize() == VehicleSize.SMALL;
    }
}
