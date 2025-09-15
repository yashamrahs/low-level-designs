package observer;

import enums.ElevatorState;
import models.Elevator;
import models.Floor;

public interface ElevatorObserver {
    void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState);

    void onElevatorFloorChange(Elevator elevator, int floor);
}
