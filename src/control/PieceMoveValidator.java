package control;

import model.*;

public class PieceMoveValidator {
    private Board board;

    public PieceMoveValidator(Board board) {
        this.board = board;
    }

    public boolean isValidMove(Tile start, Tile end) {
        Direction direction = findPathDirection(start, end);
        int distance = board.getDistance(start, end);
        boolean clearPath = isClearPath(start, end, direction);

        Piece movePiece = start.getPiece();
        Manoeuvre manoeuvre;
        if (end.isOccupied() && movePiece instanceof BiformPiece)
            manoeuvre = ((BiformPiece) movePiece).getAttackManoeuvre();
        else
            manoeuvre = ((UniformPiece)movePiece).getMovementManoeuvre();

        return isValidManoeuvre(manoeuvre, direction, distance, clearPath);
    }

    private boolean isValidManoeuvre(Manoeuvre manoeuvre, Direction direction, int distance, boolean clearPath) {
        boolean result = manoeuvre.containsDirection(direction) && manoeuvre.isInRange(distance);
        if (manoeuvre.isJump())
            return result;
        else
            return result && clearPath;
    }

    private Direction findPathDirection(Tile start, Tile end) {
        int rowDistance = board.getRowDistance(start, end);
        int colDistance = board.getColDistance(start, end);

        if (rowDistance == 0) {
            if (colDistance > 0)
                return Direction.HORIZONTAL_RIGHT;
            else if (colDistance < 0)
                return Direction.HORIZONTAL_LEFT;
            else
                return Direction.IRREGULAR;
        } else if (colDistance == 0) {
            if (rowDistance > 0)
                return Direction.VERTICAL_UP;
            else if (rowDistance < 0)
                return Direction.VERTICAL_DOWN;
            else
                return Direction.IRREGULAR;
        } else if (Math.abs(rowDistance) == Math.abs(colDistance)) {
            if (rowDistance > 0)
                return Direction.DIAGONAL_UP;
            else
                return Direction.DIAGONAL_DOWN;
        } else
            return Direction.IRREGULAR;
    }

    private boolean isClearPath(Tile start, Tile end, Direction direction) {
        int rowStep = 0, colStep = 0;
        switch (direction) {
            case HORIZONTAL_RIGHT: colStep = 1; break;
            case HORIZONTAL_LEFT: colStep = -1; break;
            case VERTICAL_UP: rowStep = 1; break;
            case VERTICAL_DOWN: rowStep = -1; break;
            case DIAGONAL_UP:
            case DIAGONAL_DOWN:
                rowStep = end.getRow() > start.getRow() ? 1 : -1;
                colStep = end.getCol() > start.getCol() ? 1 : -1;
                break;
            case IRREGULAR: return false;
        }
        while (true) {
            int nextRow = start.getRow() + rowStep;
            int nextCol = start.getCol() + colStep;
            start = board.getTile(nextRow, nextCol);
            if (start == end)
                return true;
            else if (start.isOccupied()) {
                System.err.println("Path is blocked.");
                return false;
            }
        }
    }
}
