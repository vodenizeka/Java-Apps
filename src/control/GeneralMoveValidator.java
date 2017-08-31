package control;

import model.Tile;

public class GeneralMoveValidator {

    private TurnManager turn;

    public GeneralMoveValidator(TurnManager turn) {
        this.turn = turn;
    }

    public boolean isValidMove(Tile start, Tile end) {
        if (!start.isOccupied()) {
            System.err.println("Tile has no piece on it.");
            return false;
        } else if (start.getPiece().getColor() != turn.getPlayersTurn()) {
            System.err.println("You can't move your opponents pieces.");
            return false;
        } else if (start.equals(end)) {
            System.err.println("You should move your piece.");
            return false;
        } else if (end.isOccupied() &&
                start.getPiece().getColor() == end.getPiece().getColor()) {
            System.err.println("You can't attack your pieces.");
            return false;
        }
        return true;
    }
}
