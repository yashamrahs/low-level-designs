package piecefactory.pieces;

import enums.Color;
import piecefactory.Piece;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
