package strategy;

import models.Board;
import models.Player;

public class ColWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player) {
        for (int col = 0; col < board.getSize(); col++) {
            boolean colWin = true;

            for (int row = 0; row < board.getSize(); row++) {
                if (board.getCell(row, col).getSymbol() != player.getSymbol()) {
                    colWin = false;
                    break;
                }
            }

            if (colWin) return colWin;
        }

        return false;
    }
}
