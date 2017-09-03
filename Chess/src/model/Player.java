package model;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private Color color;
    private List<Piece> pieces;

    public Player(Color color) {
        this.color = color;
        pieces = new LinkedList<>();
    }

    public void removePiece(Piece piece) {
        if (piece == null) return;
        if (pieces.remove((Piece)piece))
            System.err.println(piece.getName() + " was removed from " + piece.getColor() + " player.");
        else
            System.err.println("Failed to remove " + piece.getColor() + " " + piece.getName() + ".");
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}
