import factory.VehicleFactory;
import factory.vehicle.Vehicle;
import models.ParkingLot;
import parkingspots.BikeParkingSpot;
import parkingspots.CarParkingSpot;
import parkingspots.ParkingSpot;
import strategy.PaymentStrategy;
import strategy.paymentstrategies.CashPayment;
import strategy.paymentstrategies.CreditCardPayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1, "Car"));
        parkingSpots.add(new CarParkingSpot(2,"Car"));
        parkingSpots.add(new BikeParkingSpot(3, "Bike"));
        parkingSpots.add(new BikeParkingSpot(4, "Bike"));

        ParkingLot parkingLot = new ParkingLot(parkingSpots);
        Vehicle car1 = VehicleFactory.createVehicle("Car", "CAR123");
        Vehicle car2 = VehicleFactory.createVehicle("Car", "CAR345");
        Vehicle bike1 = VehicleFactory.createVehicle("Bike", "BIKE456");
        Vehicle bike2 = VehicleFactory.createVehicle("Bike", "BIKE123");

        ParkingSpot carSpot = parkingLot.parkVehicle(car1);
        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike1);

        ParkingSpot carSpot2 = parkingLot.parkVehicle(car2);
        ParkingSpot bikeSpot2 = parkingLot.parkVehicle(bike2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int paymentMethod = scanner.nextInt();

        if (carSpot != null) {

        }
        if (bikeSpot != null) {

        }
        scanner.close();
    }
}