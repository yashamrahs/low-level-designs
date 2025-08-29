package piecefactory.pieces;

import enums.Color;
import piecefactory.Piece;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
