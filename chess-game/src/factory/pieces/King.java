package factory.pieces;

import enums.Color;
import strategy.movementstrategies.KingMovementStrategy;

public class King extends Piece {
    public King(Color color) {
        super(color, new KingMovementStrategy());
    }
}
