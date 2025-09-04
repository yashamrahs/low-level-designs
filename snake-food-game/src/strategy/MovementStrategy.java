package strategy;

import model.Pair;

public interface MovementStrategy {
    Pair getNextPosition(Pair currHead, String direction);
}
