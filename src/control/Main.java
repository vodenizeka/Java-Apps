package control;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.setUpBoard(Game.chessGame);
        game.loop();
    }
}
