package model;

public class King extends UniformPiece {

    public King(Color color) {
        super(color);
        getMovementManoeuvre().setDirections(Direction.getAllDirections());
        getMovementManoeuvre().setManoeuvre(1,1,false);
    }

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public String toString() {
        if (getColor() == Color.WHITE) return "K";
        else return "k";
    }
}
