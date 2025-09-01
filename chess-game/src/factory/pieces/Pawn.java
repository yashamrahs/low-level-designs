package factory.pieces;

import enums.Color;
import strategy.movementstrategies.PawnMovementStrategy;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color, new PawnMovementStrategy());
    }
}