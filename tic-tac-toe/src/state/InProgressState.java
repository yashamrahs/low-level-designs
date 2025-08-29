package state;

import enums.GameStatus;
import enums.Symbol;
import exceptions.InvalidMoveException;
import models.Player;
import Game.Game;

public class InProgressState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        if (game.getCurrentPlayer() != player) {
            throw new InvalidMoveException("Not your turn");
        }

        // place your symbol on the board
        game.getBoard().placeSymbol(row, col, player.getSymbol());

        // check for win or draw
        if (game.checkWinner(player)) {
            game.setWinner(player);
            game.setStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
            game.setState(new WinnerState());
        } else if (game.getBoard().isFull()) {
            game.setStatus(GameStatus.DRAW);
            game.setState(new DrawState());
        } else {
            game.switchPlayer();
        }
    }
}
