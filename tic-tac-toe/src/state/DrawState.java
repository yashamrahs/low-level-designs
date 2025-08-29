package state;

import exceptions.InvalidMoveException;
import models.Player;
import Game.Game;

public class DrawState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. It was a draw");
    }
}
