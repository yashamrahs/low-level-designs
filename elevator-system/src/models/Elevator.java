package models;

import command.ElevatorRequest;
import enums.Direction;
import enums.ElevatorState;
import observer.ElevatorObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private List<ElevatorObserver> observers;
    private Queue<ElevatorRequest> requests;


    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.elevatorState = ElevatorState.IDLE;
        this.observers = new ArrayList<>();
        this.requests = new LinkedList<>();
    }

    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ElevatorObserver observer) {
        observers.remove(observer);
    }

    private void notifyStateChange(ElevatorState state) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorStateChange(this, state);
        }
    }

    private void notifyFloorChange(int floor) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorFloorChange(this, floor);
        }
    }

    public void addRequests (ElevatorRequest request) {
        if (!requests.contains(request)) requests.add(request);

        int requestedFloor = request.getFloor();

        if (elevatorState == ElevatorState.IDLE) {
            if (requestedFloor > currentFloor) {
                direction = Direction.UP;
            } else if (requestedFloor < currentFloor) {
                direction = Direction.DOWN;
            }

            setElevatorState(ElevatorState.MOVING);
        }
    }

    public void moveToNextFloor(int nextStop) {
        if (elevatorState != ElevatorState.MOVING) return;

        while (currentFloor != nextStop) {
            if (direction == Direction.UP) {
                setCurrentFloor(currentFloor + 1);
            } else {
                setCurrentFloor(currentFloor - 1);
            }

            if (currentFloor == nextStop) {
                completeArrival();
                return;
            }
        }
    }

    public void completeArrival() {
        setElevatorState(ElevatorState.STOPPED);

        requests.removeIf(request -> request.getFloor() == currentFloor);
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            setElevatorState(ElevatorState.IDLE);
        } else {
            setElevatorState(ElevatorState.MOVING);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
        notifyStateChange(elevatorState);
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        notifyFloorChange(currentFloor);
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public Queue<ElevatorRequest> getRequests() {
        return requests;
    }

    public List<ElevatorRequest> getDestinationFloors() {
        return new ArrayList<>(requests);
    }
}
