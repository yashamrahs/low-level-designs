package piecefactory;

import enums.Color;

public abstract class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove();

    public Color getColor() {
        return color;
    }
}
