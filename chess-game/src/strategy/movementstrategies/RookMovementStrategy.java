package strategy.movementstrategies;

import strategy.MovementStrategy;
import utils.Board;
import utils.Cell;

public class RookMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}
