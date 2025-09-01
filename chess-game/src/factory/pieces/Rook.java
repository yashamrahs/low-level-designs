package factory.pieces;

import enums.Color;
import strategy.movementstrategies.RookMovementStrategy;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, new RookMovementStrategy());
    }
}
