package parkingspots;

import enums.VehicleSize;
import factory.vehicle.Vehicle;

public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    private VehicleSize spotType;

    public ParkingSpot(int spotNumber, VehicleSize spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle) {
        if (isOccupied) throw new IllegalStateException("Spot is already occupied");

        if (!canParkVehicle(vehicle)) throw new IllegalArgumentException(
                "This spot is not suitable for " + vehicle.getLicenseNumber()
        );

        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void vacate() {
        if (!isOccupied) throw new IllegalStateException("Spot is already vacant");
        this.vehicle = null;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleSize getSpotType() {
        return spotType;
    }
}
