package piecefactory.pieces;

import enums.Color;
import piecefactory.Piece;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
