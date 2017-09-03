package control;

import model.*;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private TurnManager turn;
    private MoveValidator move;

    public Game() {
        board = new Board();
        whitePlayer = new Player(Color.WHITE);
        blackPlayer = new Player(Color.BLACK);
        turn = new Turn(whitePlayer, blackPlayer);
        move = new MoveValidator(board, turn);
    }

    public void loop() {
        Scanner sc = new Scanner(System.in);
        System.out.println("LET THE GAME BEGIN");

        while (true) {
            showMessage();
            String command = sc.nextLine();
            try {
                Tile[] tiles = getMove(command);
                if (tiles == null)
                    break;
                if (move.isValidMove(tiles[0], tiles[1]))
                    turn.playMove(tiles[0], tiles[1]);
                else
                    System.err.println("INVALID MOVE!");
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        sc.close();
    }

    public Tile[] getMove(String command) throws Exception {
        StringTokenizer st = new StringTokenizer(command);
        if (st.countTokens() != 2)
            throw new Exception("Wrong command format, two arguments are needed.");

        String firstTile = st.nextToken();
        String secondTile = st.nextToken();
        if (firstTile.equalsIgnoreCase("quit") || secondTile.equalsIgnoreCase("quit"))
            return null;

        Tile[] commandTiles = {board.getTile(firstTile), board.getTile(secondTile)};
        return commandTiles;
    }

    public void showMessage() {
        System.out.println(turn.getPlayersTurn() + " to play.");
        System.out.println("Enter move (2 tiles):");
        System.out.println(board);
    }

    public void initGame(String fileName) {

    }

    public void setUpBoard(String[] rows) {
        int dimension = board.getDimension();
        for (int i = dimension - 1, stringRow = 0; i >= 0; i--, stringRow++) {
            for (int j = 0; j < dimension; j++) {
                char tile = rows[stringRow].charAt(j);
                Color color;
                if (Character.isUpperCase(tile))
                    color = Color.WHITE;
                else if (Character.isLowerCase(tile))
                    color = Color.BLACK;
                else
                    continue;
                Piece piece = null;
                switch(Character.toUpperCase(tile)) {
                    case 'P': piece = new Pawn(color); break;
                    case 'H': piece = new Knight(color); break;
                    case 'B': piece = new Bishop(color); break;
                    case 'R': piece = new Rook(color); break;
                    case 'Q': piece = new Queen(color); break;
                    case 'K': piece = new King(color); break;
                }
                board.getTile(i, j).setPiece(piece);
            }
        }
    }

    public static String[] chessGame = {
            "rhbqkbhr",
            "pppppppp",
            "00000000",
            "00000000",
            "00000000",
            "00000000",
            "PPPPPPPP",
            "RHBQKBHR"
    };
}
