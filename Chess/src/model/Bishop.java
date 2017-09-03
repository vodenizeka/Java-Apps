package model;

public class Bishop extends UniformPiece {

    public Bishop(Color color) {
        super(color);
        getMovementManoeuvre().setDirections(Direction.getDiagonalDirections());
        getMovementManoeuvre().setManoeuvre(1, Integer.MAX_VALUE, false);
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public String toString() {
        if (getColor() == Color.WHITE) return "B";
        else return "b";
    }
}
