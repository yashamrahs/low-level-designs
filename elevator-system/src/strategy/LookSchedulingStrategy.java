package strategy;

import command.ElevatorRequest;
import enums.Direction;
import models.Elevator;

import java.util.Queue;

public class LookSchedulingStrategy implements ElevatorSelectionStrategy {
    @Override
    public int getNextStop(Elevator elevator) {
        int currFloor = elevator.getCurrentFloor();
        Queue<ElevatorRequest> requests = elevator.getRequests();

        if (requests == null || requests.isEmpty()) return currFloor;

        ElevatorRequest primaryReq = requests.peek();
        int primaryFloor = primaryReq.getFloor();

        Direction direction;
        if (primaryFloor > currFloor) {
            direction = Direction.UP;
        } else if (primaryFloor < currFloor) {
            direction = Direction.DOWN;
        } else {
            return currFloor;
        }

        Integer candidate = null;
        for (ElevatorRequest request : requests) {
            int reqFloor = request.getFloor();

            if (direction == Direction.UP && reqFloor > currFloor && reqFloor <= primaryFloor) {
                if (candidate == null || reqFloor < candidate) {
                    candidate = reqFloor;
                }
            } else if (direction == Direction.DOWN && reqFloor < currFloor && reqFloor >= primaryFloor)  {
                if (candidate == null || reqFloor > candidate) {
                    candidate = reqFloor;
                }
            }
        }

        return (candidate == null) ? primaryFloor : candidate;
    }
}
