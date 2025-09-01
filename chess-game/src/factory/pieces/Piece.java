package factory.pieces;

import enums.Color;
import strategy.MovementStrategy;
import utils.Board;
import utils.Cell;

public abstract class Piece {
    private Color color;
    protected final MovementStrategy movementStrategy;

    public Piece(Color color, MovementStrategy movementStrategy) {
        this.color = color;
        this.movementStrategy = movementStrategy;
    }

    public boolean canMove(Board board, Cell from, Cell to) {
        return movementStrategy.canMove(board, from, to);
    }

    public Color getColor() {
        return color;
    }
}
