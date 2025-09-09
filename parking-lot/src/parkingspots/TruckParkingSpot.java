package parkingspots;

import enums.VehicleSize;
import factory.vehicle.Vehicle;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getSize() == VehicleSize.LARGE;
    }
}
