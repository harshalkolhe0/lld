package models;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToeGame{
    Board board;
    Deque<Player> players;

    public TicTacToeGame(int sz){
        board= new Board(sz);
        players=new ArrayDeque<Player>();
    }
    public void addPlayer(Player p){
        players.add(p);
    }
    public boolean noFreeSpace() {
        for(int i=0;i<board.pieces.length;i++){
            for(int j=0;j<board.pieces[0].length;j++){
                if(board.pieces[i][j]==null)return false;
            }
        }
        return true;
    }
    
    public String startGame(){
        boolean inProgress = true;
        while(inProgress){
            Player p= players.poll();
            if(noFreeSpace())break;
            do{
                System.out.println("Enter your location(row col)");
                Scanner sc = new Scanner(System.in);
                int row=sc.nextInt();
                int col=sc.nextInt();
                if(board.isValid(row, col)){
                    board.set(row,col,p.piece);
                    break;
                }
                System.out.println("Wrong location, Enter Again");
            }while(true);
            board.printBoard();
            if(board.AnyWin())return p.playerid.toString();
            players.add(p);
        }
        return "tie";
    }

}