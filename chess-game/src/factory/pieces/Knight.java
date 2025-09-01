package factory.pieces;

import enums.Color;
import strategy.movementstrategies.KnightMovementStrategy;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color, new KnightMovementStrategy());
    }
}
