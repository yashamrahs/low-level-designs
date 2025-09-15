package observer;

import enums.ElevatorState;
import models.Elevator;

public class ElevatorDisplay implements ElevatorObserver {
    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState) {
        System.out.println("Elevator " + elevator.getId() + " state changed to " + elevatorState);
    }

    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        System.out.println("Elevator " + elevator.getId() + " moved to floor " + floor);
    }
}
