package controller;

import command.ElevatorRequest;
import enums.Direction;
import models.Elevator;
import models.Floor;
import strategy.ElevatorSelectionStrategy;
import strategy.LookSchedulingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private List<Floor> floors;
    private int currentElevatorId;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ElevatorController() {};

    public ElevatorController(int numberOfElevators, int numberOfFloors) {
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();
        this.elevatorSelectionStrategy = new LookSchedulingStrategy();

        for (int i = 1; i <= numberOfElevators; i++) {
            elevators.add(new Elevator(i));
        }

        for (int i = 1; i <= numberOfFloors; i++) {
            floors.add(new Floor(i));
        }
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy strategy) {
        this.elevatorSelectionStrategy = strategy;
    }

    public void requestElevator(int elevatorId, int floorNumber, Direction direction) {
        System.out.println(
                "External request: Floor " + floorNumber + ", Direction " + direction);

        Elevator selectedElevator = getElevatorById(elevatorId);
        if (selectedElevator != null) {
            selectedElevator.addRequests(
                    new ElevatorRequest(elevatorId, floorNumber, false, direction));
            System.out.println("Assigned elevator " + selectedElevator.getId()
                    + " to floor " + floorNumber);
        } else {
            System.out.println("No elevator available for floor " + floorNumber);
        }
    }

    public void requestFloor(int elevatorId, int floorNumber) {
        Elevator elevator = getElevatorById(elevatorId);
        System.out.println("Internal request: Elevator " + elevator.getId()
                + " to floor " + floorNumber);

        Direction direction = floorNumber > elevator.getCurrentFloor()
                ? Direction.UP
                : Direction.DOWN;

        elevator.addRequests(new ElevatorRequest(elevatorId, floorNumber, true, direction));
    }

    private Elevator getElevatorById(int elevatorId) {
        for (Elevator elevator : elevators) {
            if (elevator.getId() == elevatorId)
                return elevator;
        }
        return null;
    }

    public void step() {
        for (Elevator elevator : elevators) {
            if (!elevator.getRequests().isEmpty()) {
                int nextStop = elevatorSelectionStrategy.getNextStop(elevator);

                if (elevator.getCurrentFloor() != nextStop) {
                    elevator.moveToNextFloor(nextStop);
                }
            }
        }
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setCurrentElevatorId(int currentElevatorId) {
        this.currentElevatorId = currentElevatorId;
    }
}
