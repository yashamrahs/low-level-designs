package strategy;

import models.Elevator;

public interface ElevatorSelectionStrategy {
    int getNextStop(Elevator elevator);
}
