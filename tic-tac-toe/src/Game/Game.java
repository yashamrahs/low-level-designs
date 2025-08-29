package Game;
import enums.GameStatus;
import models.Board;
import models.Player;
import state.GameState;
import state.InProgressState;
import strategy.ColWinningStrategy;
import strategy.DiagonalWinningStrategy;
import strategy.RowWinningStrategy;
import strategy.WinningStrategy;

import java.util.List;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player winner;
    private GameStatus status;
    private GameState state;
    private final List<WinningStrategy> winningStrategies;

    public Game(Player player1, Player player2) {
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.status = GameStatus.IN_PROGRESS;
        this.state = new InProgressState();
        this.winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );
    }

    public void makeMove(Player player, int row, int col) {
        state.handleMove(this, player, row, col);
    }

    public boolean checkWinner(Player player) {
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.checkWinner(board, player)) {
                return true;
            }
        }

        return false;
    }

    public void switchPlayer() {
        if (currentPlayer == player1) setCurrentPlayer(player2);
        else setCurrentPlayer(player1);
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
