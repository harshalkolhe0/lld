import models.Piece;
import models.PieceType;
import models.Player;
import models.TicTacToeGame;

public class App {
    public static void main(String[] args) throws Exception {
        TicTacToeGame game=new TicTacToeGame(3);
        game.addPlayer(new Player(new Piece(PieceType.O), 0));
        game.addPlayer(new Player(new Piece(PieceType.X), 1));
        System.out.println("Result: "+game.startGame());
    }
}