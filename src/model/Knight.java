package model;

public class Knight extends UniformPiece {

    public Knight(Color color) {
        super(color);
        getMovementManoeuvre().setDirection(Direction.IRREGULAR);
        getMovementManoeuvre().setManoeuvre(2,2, true);
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public String toString() {
        if (getColor() == Color.WHITE) return "H"; // horseman --> K is reserved for King
        else return "h";
    }
}
