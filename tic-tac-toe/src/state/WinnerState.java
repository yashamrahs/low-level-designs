package state;

import exceptions.InvalidMoveException;
import models.Player;
import Game.Game;

public class WinnerState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. " + game.getWinner().getName() + " has won.");
    }
}
