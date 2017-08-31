package control;

import model.Board;
import model.Tile;

public class MoveValidator {
    private GeneralMoveValidator generalMove;
    private PieceMoveValidator pieceMove;

    public MoveValidator(Board board, TurnManager turn) {
        generalMove = new GeneralMoveValidator(turn);
        pieceMove = new PieceMoveValidator(board);
    }

    public boolean isValidMove(Tile start, Tile end) {
        if (generalMove.isValidMove(start, end))
            return pieceMove.isValidMove(start, end);
        else return false;
    }
}
