import enums.Color;
import factory.pieces.Piece;
import utils.Board;
import utils.Move;
import utils.Player;

import java.util.Scanner;

public class ChessGame {
    private final Board board;
    private Player whitePlayer, blackPlayer;
    private Player currentPlayer;

    public ChessGame() {
        board = Board.getInstance();
    }

    public void setPlayers(String whitePlayerName, String blackPlayerName) {
        this.whitePlayer = new Player(whitePlayerName, Color.WHITE);
        this.blackPlayer = new Player(blackPlayerName, Color.BLACK);
        this.currentPlayer = whitePlayer;
    }

    public void start() {
        while (!isGameOver()) {
            Player player = currentPlayer;
            System.out.println(player.getName() + "'s turn.");
            // Get move from the player
            Move move = getPlayerMove(player);
            // Make the move on the board
            try {
                board.movePiece(move);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                continue;
            }
            // Switch to the next player
            switchTurn();
        }
        // Display game result
        displayResult();
    }

    private void switchTurn() {
        currentPlayer = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
    }

    private boolean isGameOver() {
        return board.isCheckMate(whitePlayer.getColor()) || board.isCheckMate(blackPlayer.getColor()) ||
                board.isStaleMate(whitePlayer.getColor()) || board.isStaleMate(blackPlayer.getColor());
    }

    private Move getPlayerMove(Player player) {
        // For simplicity, let's assume the player enters the move via console input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();

        Piece piece = board.getPiece(sourceRow, sourceCol);
        if (piece == null || piece.getColor() != player.getColor()) {
            throw new IllegalArgumentException("Invalid piece selection!");
        }

        return new Move(board.getCell(sourceRow, sourceCol), board.getCell(destRow, destCol));
    }

    private void displayResult() {
        if (board.isCheckMate(Color.WHITE)) {
            System.out.println("Black wins by checkmate!");
        } else if (board.isCheckMate(Color.BLACK)) {
            System.out.println("White wins by checkmate!");
        } else if (board.isStaleMate(Color.WHITE) || board.isStaleMate(Color.BLACK)) {
            System.out.println("The game ends in a stalemate!");
        }
    }
}
