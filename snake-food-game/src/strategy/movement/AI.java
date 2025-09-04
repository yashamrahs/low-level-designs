package strategy.movement;

import model.Pair;
import strategy.MovementStrategy;

import java.nio.channels.Pipe;

public class AI implements MovementStrategy {
    @Override
    public Pair getNextPosition(Pair currHead, String direction) {
        int row = currHead.getRow();
        int col = currHead.getCol();

        return switch (direction) {
            case "U" -> new Pair(row - 1, col);
            case "D" -> new Pair(row + 1, col);
            case "L" -> new Pair(col - 1, row);
            case "R" -> new Pair(row, col + 1);
            default -> currHead;
        };
    }
}
