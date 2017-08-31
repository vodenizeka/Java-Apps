package control;

import model.*;

public class Turn implements TurnManager {

    private Player attacker;
    private Player defender;
    private Color playersTurn;

    public Turn(Player white, Player black) {
        attacker = white;
        defender = black;
        playersTurn = Color.WHITE;
    }

    @Override
    public void playMove(Tile start, Tile end) {
        if (end.isOccupied())
            defender.removePiece(end.getPiece());

        Piece movingPiece = start.getPiece();
        movingPiece.setMoved();
        start.removePiece();
        end.setPiece(movingPiece);

        changePlayersTurn();
    }

    private void changePlayersTurn() {
        Player tmp = attacker;
        attacker = defender;
        defender = tmp;
        playersTurn = playersTurn == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    @Override
    public Color getPlayersTurn() {
        return playersTurn;
    }
}
