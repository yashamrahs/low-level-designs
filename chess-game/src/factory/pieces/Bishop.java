package piecefactory.pieces;

import enums.Color;
import piecefactory.Piece;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
