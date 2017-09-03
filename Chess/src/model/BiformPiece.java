package model;

public abstract class BiformPiece extends UniformPiece {
    private Manoeuvre attackManoeuvre;

    public BiformPiece(Color color) {
        super(color);
        attackManoeuvre = new Manoeuvre();
    }

   public Manoeuvre getAttackManoeuvre() {
        return attackManoeuvre;
    }
}
