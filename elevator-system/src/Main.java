import controller.ElevatorController;
import enums.Direction;
import models.Building;
import models.Elevator;
import observer.ElevatorDisplay;
import strategy.LookSchedulingStrategy;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Building building = new Building("Office Tower", 10, 3);
        ElevatorController controller = building.getElevatorController();
        ElevatorDisplay display = new ElevatorDisplay();

        for (Elevator elevator : controller.getElevators()) {
            elevator.addObserver(display);
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        // Display simulation details and options
        System.out.println("Elevator System Simulation");
        System.out.println("Building: " + building.getName());
        System.out.println("Floors: " + building.getNumberOfFloors());
        System.out.println("Elevators: " + controller.getElevators().size());
        // Main loop for user interactions
        while (running) {
            System.out.println("nSelect an option:");
            System.out.println("1. Request elevator (external)");
            System.out.println("2. Request floor (internal)");
            System.out.println("3. Simulate next step");
            System.out.println("4. Change scheduling strategy");
            System.out.println("5. Exit simulation");
            int choice = scanner.nextInt(); // Read user's menu choice
            switch (choice) {
                case 1:
                    // Handle external elevator request
                    // Handle internal elevator floor request
                    System.out.print("Enter elevator ID: ");
                    int externalElevatorId = scanner.nextInt();
                    controller.setCurrentElevatorId(externalElevatorId); // Set the selected elevator
                    System.out.print("Enter floor number: ");
                    int floorNum = scanner.nextInt();
                    System.out.print("Direction (1 for UP, 2 for DOWN): ");
                    int dirChoice = scanner.nextInt();
                    Direction dir = dirChoice == 1 ? Direction.UP : Direction.DOWN;
                    controller.requestElevator(externalElevatorId, floorNum, dir);
                    break;
                case 2:
                    // Handle internal elevator floor request
                    System.out.print("Enter elevator ID: ");
                    int elevatorId = scanner.nextInt();
                    controller.setCurrentElevatorId(elevatorId); // Set the selected elevator
                    System.out.print("Enter destination floor: ");
                    int destFloor = scanner.nextInt();
                    controller.requestFloor(elevatorId, destFloor);
                    break;
                case 3:
                    // Simulate the next step in the system
                    System.out.println("Simulating next step...");
                    controller.step(); // Perform the simulation step
                    displayElevatorStatus(controller.getElevators()); // Display elevator statuses
                    break;
                case 4:
                    // Change the scheduling strategy
                    System.out.println("Select strategy:");
                    System.out.println("1. SCAN Algorithm");
                    System.out.println("2. FCFS Algorithm");
                    System.out.println("3. Look Algorithm");
                    int strategyChoice = scanner.nextInt();
                    if (strategyChoice == 1) {
                        controller.setElevatorSelectionStrategy(new LookSchedulingStrategy());
                        System.out.println("Strategy set to SCAN Algorithm");
                    } else {
                        controller.setElevatorSelectionStrategy(new LookSchedulingStrategy());
                        System.out.println("Strategy set to Nearest Elevator First");
                    }
                    break;
                case 5:
                    // Exit the simulation
                    running = false;
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close(); // Close the scanner to release resources
        System.out.println("Simulation ended"); // End of simulation
    }

    // Display the status of all elevators in the system
    private static void displayElevatorStatus(List<Elevator> elevators) {
        System.out.println("nElevator Status:");
        for (Elevator elevator : elevators) {
            // Print details of each elevator, including current floor, direction, and
            // state
            System.out.println("Elevator " + elevator.getId() + ": Floor "
                    + elevator.getCurrentFloor() + ", Direction "
                    + elevator.getDirection() + ", State " + elevator.getElevatorState()
                    + ", Destinations " + elevator.getDestinationFloors());
        }
    }
}