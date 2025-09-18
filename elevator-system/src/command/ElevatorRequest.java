package command;

import controller.ElevatorController;
import enums.Direction;

public class ElevatorRequest implements ElevatorCommand {
    private int elevatorId;
    private int floor;
    private Direction direction;
    private ElevatorController controller;
    private boolean isInternalRequest;

    public ElevatorRequest(int elevatorId, int floor, boolean isInternalRequest, Direction direction) {
        this.elevatorId = elevatorId;
        this.floor = floor;
        this.isInternalRequest = isInternalRequest;
        this.direction = direction;
        this.controller = new ElevatorController();
    }

    @Override
    public void execute() {
        if (isInternalRequest) {

        } else {

        }
    }

    public Direction getDirection() {
        return direction;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isInternalRequest() {
        return isInternalRequest;
    }
}
