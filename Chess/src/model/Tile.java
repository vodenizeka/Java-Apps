package model;

public class Tile {
    private final int row, col;
    private Piece piece;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    public boolean isOccupied() {
        if (piece == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (isOccupied())
            return getPiece().toString();
        else
            return "0";
    }

    public void removePiece() {
        piece = null;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
