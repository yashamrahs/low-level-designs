package state;
import models.Player;
import Game.Game;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
