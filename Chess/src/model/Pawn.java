package model;

public class Pawn extends BiformPiece {

    public Pawn(Color color) {
        super(color);
        if (color == Color.WHITE) {
            getMovementManoeuvre().setDirection(Direction.VERTICAL_UP);
            getAttackManoeuvre().setDirection(Direction.DIAGONAL_UP);
        } else {
            getMovementManoeuvre().setDirection(Direction.VERTICAL_DOWN);
            getAttackManoeuvre().setDirection(Direction.DIAGONAL_DOWN);
        }
        getMovementManoeuvre().setManoeuvre(1,2,false);
        getAttackManoeuvre().setManoeuvre(1,1,false);
    }

    @Override
    public void setMoved() {
        if (!isMoved())
            getMovementManoeuvre().setMaxRange(1);
        super.setMoved();
    }

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public String toString() {
        if (getColor() == Color.WHITE) return "P";
        else return "p";
    }
}
