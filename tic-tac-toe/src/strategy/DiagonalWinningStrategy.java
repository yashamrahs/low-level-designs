package strategy;

import models.Board;
import models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player) {
        // main diagonal
        boolean mainDiagWin = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, i).getSymbol() != player.getSymbol()) {
                mainDiagWin = false;
                break;
            }
        }
        if (mainDiagWin) return mainDiagWin;

        // anti diagonal
        boolean antiDiagonal = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, board.getSize() - i - 1).getSymbol() != player.getSymbol()) {
                antiDiagonal = false;
                break;
            }
        }
        return antiDiagonal;
    }
}
