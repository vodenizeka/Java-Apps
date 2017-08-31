package model;

public abstract class UniformPiece extends Piece {
    private Manoeuvre movementManoeuvre;

    public UniformPiece(Color color) {
        super(color);
        movementManoeuvre = new Manoeuvre();
    }

   public Manoeuvre getMovementManoeuvre() {
        return movementManoeuvre;
    }
}
