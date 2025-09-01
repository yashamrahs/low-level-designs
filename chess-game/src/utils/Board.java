package utils;

import enums.Color;
import factory.PieceFactory;
import factory.pieces.Piece;

public class Board {
    private static Board instance;
    private Cell[][] board = new Cell[8][8];

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private Board() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Cell(row, col);
            }
        }

        setupPieces();
    }

    private void setupPieces() {
        // Add pawns to both sides
        for (int j = 0; j < 8; j++) {
            board[1][j].setPiece(PieceFactory.createPiece("pawn", Color.WHITE));
            board[6][j].setPiece(PieceFactory.createPiece("pawn", Color.BLACK));
        }

        // Initialize white pieces
        board[0][0].setPiece(PieceFactory.createPiece("rook", Color.WHITE));
        board[0][1].setPiece(PieceFactory.createPiece("knight", Color.WHITE));
        board[0][2].setPiece(PieceFactory.createPiece("bishop", Color.WHITE));
        board[0][3].setPiece(PieceFactory.createPiece("queen", Color.WHITE));
        board[0][4].setPiece(PieceFactory.createPiece("king", Color.WHITE));
        board[0][5].setPiece(PieceFactory.createPiece("bishop", Color.WHITE));
        board[0][6].setPiece(PieceFactory.createPiece("knight", Color.WHITE));
        board[0][7].setPiece(PieceFactory.createPiece("rook", Color.WHITE));

        // Initialize black pieces
        board[7][0].setPiece(PieceFactory.createPiece("rook", Color.BLACK));
        board[7][1].setPiece(PieceFactory.createPiece("knight", Color.BLACK));
        board[7][2].setPiece(PieceFactory.createPiece("bishop", Color.BLACK));
        board[7][3].setPiece(PieceFactory.createPiece("queen", Color.BLACK));
        board[7][4].setPiece(PieceFactory.createPiece("king", Color.BLACK));
        board[7][5].setPiece(PieceFactory.createPiece("bishop", Color.BLACK));
        board[7][6].setPiece(PieceFactory.createPiece("knight", Color.BLACK));
        board[7][7].setPiece(PieceFactory.createPiece("rook", Color.BLACK));
    }

    public synchronized boolean movePiece(Move move) {
        Cell from = move.getStart(), to = move.getEnd();
        Piece piece = from.getPiece();

        if (piece != null || !piece.canMove(this, from, to)) return false;

        to.setPiece(piece);
        from.setPiece(null);

        return true;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public Piece getPiece(int row, int col) {
        return getCell(row, col).getPiece();
    }

    public void setPiece(int row, int col, Piece piece) {
        getCell(row, col).setPiece(piece);
    }

    public boolean isCheckMate(Color color) {
        // TODO: Implement checkmate logic
        return false;
    }

    public boolean isStaleMate(Color color) {
        // TODO: Implement stalemate logic
        return false;
    }
}
