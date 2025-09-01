package strategy;

import utils.Board;
import utils.Cell;

public interface MovementStrategy {
    boolean canMove(Board board, Cell from, Cell to);
}
