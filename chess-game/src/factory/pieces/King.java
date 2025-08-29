package piecefactory.pieces;

import enums.Color;
import piecefactory.Piece;

public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
