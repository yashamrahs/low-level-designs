package piecefactory;

import enums.Color;
import piecefactory.pieces.*;

public class PieceFactory {
    public static Piece createPiece(String piece, Color color) {
        return switch (piece.toLowerCase()) {
            case "king" -> new King(color);
            case "queen" -> new Queen(color);
            case "bishop" -> new Bishop(color);
            case "knight" -> new Knight(color);
            case "rook" -> new Rook(color);
            case "pawn" -> new Pawn(color);
            default -> throw new IllegalArgumentException("Unknown piece type: " + piece);
        };
    }
}
