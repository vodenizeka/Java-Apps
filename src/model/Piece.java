package model;

public abstract class Piece {
    private Color color;
    private boolean isMoved;

    public Piece(Color color) {
        this.color = color;
        isMoved = false;
    }

    public abstract String getName();

    public Piece getPiece() {
        return this;
    }

    public Color getColor() {
        return color;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved() {
        isMoved = true;
    }
}
