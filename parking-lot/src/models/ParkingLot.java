package models;

import enums.VehicleSize;
import factory.vehicle.Vehicle;
import parkingspots.ParkingSpot;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findAvailableSpot(VehicleSize vehicleSize) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getSpotType().equals(vehicleSize)) return spot;
        }

        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getSize());

        if (spot != null) {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully in spot: " + spot.getSpotNumber());
            return spot;
        }

        System.out.println("No parking spots available for this vehicle!");
        return null;
    }

    public void vacateSpot(ParkingSpot spot, Vehicle vehicle) {
        if (spot != null && spot.isOccupied() && spot.getSpotType() == vehicle.getSize()) {
            spot.vacate();
            System.out.println("Vacated the spot: " + spot.getSpotNumber());
        } else {
            System.out.println(" Invalid Operation!");
        }
    }

    public ParkingSpot getSpotByNumber(int spotNumber) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                return spot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
