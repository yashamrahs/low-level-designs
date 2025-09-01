package factory.pieces;

import enums.Color;
import strategy.movementstrategies.BishopMovementStrategy;
import utils.Board;
import utils.Cell;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, new BishopMovementStrategy());
    }
}
