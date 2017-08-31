package model;

public class Queen extends UniformPiece {
    public Queen(Color color) {
        super(color);
        getMovementManoeuvre().setDirections(Direction.getAllDirections());
        getMovementManoeuvre().setManoeuvre(1, Integer.MAX_VALUE, false);
    }

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public String toString() {
        if (getColor() == Color.WHITE) return "Q";
        else return "q";
    }
}
