package piecefactory.pieces;

import enums.Color;
import piecefactory.Piece;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
