package control;

import model.Color;
import model.Tile;

public interface TurnManager {
    void playMove(Tile start, Tile end);
    Color getPlayersTurn();
}
