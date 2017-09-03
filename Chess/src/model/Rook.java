package model;

public class Rook extends UniformPiece {
    public Rook(Color color) {
        super(color);
        getMovementManoeuvre().setDirections(Direction.getOrthogonalDirections());
        getMovementManoeuvre().setManoeuvre(1, Integer.MAX_VALUE, false);
    }

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public String toString() {
        if (getColor() == Color.WHITE) return "R";
        else return "r";
    }
}
