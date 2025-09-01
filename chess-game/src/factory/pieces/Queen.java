package factory.pieces;

import enums.Color;
import strategy.movementstrategies.QueenMovementStrategy;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, new QueenMovementStrategy());
    }
}
