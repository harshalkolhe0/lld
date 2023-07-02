package models;

public class Board {
    int size;
    Piece pieces[][];
    int d1[],d2[],col[],row[];
    public Board(int n) {
        size = n;
        pieces = new Piece[n][n];
        col= new int[n];
        row= new int[n];
        d1= new int[2*n];
        d2= new int[2*n];
    }
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(pieces[i][j]!=null)
                    System.out.print(" "+pieces[i][j].pieceType+" |");
                else System.out.print("   |");
            }
            System.out.print("\n");
        }
    }
    public void set(int i, int j,Piece p){
        pieces[i][j]=p;
    }
    boolean isValid(int i, int j){
        if(pieces[i][j]==null){
            return true;
        }
        return false;
    }
    public boolean AnyWin(){
        int cnt=1;
        for(int i=1; i<pieces.length; i++){
            for(int j=0; j<pieces.length;j++){
                if(pieces[i][j]!=null&&pieces[i-1][j]!=null&&pieces[i][j].pieceType==pieces[i-1][j].pieceType){
                    cnt++;
                }
            }
        }
        if(cnt==size)return true;
        cnt=1;
        for(int i=0; i<pieces.length; i++){
            for(int j=1; j<pieces.length;j++){
                if(pieces[i][j]!=null&&pieces[i][j-1]!=null&&pieces[i][j].pieceType==pieces[i][j-1].pieceType){
                    cnt++;
                }
            }
        }
        if(cnt==size)return true;
        cnt=1;
        for(int i=1; i<pieces.length; i++){
            for(int j=1; j<pieces.length;j++){
                if(pieces[i][j]!=null&&pieces[i-1][j-1]!=null&&pieces[i][j].pieceType==pieces[i-1][j-1].pieceType){
                    cnt++;
                }
            }
        }
        if(cnt==size)return true;
        cnt=1;
        for(int i=1; i<pieces.length; i++){
            if(pieces[i][size-i-1]!=null&&pieces[i-1][size-i]!=null&&pieces[i][size-i-1].pieceType==pieces[i-1][size-i].pieceType){
                    cnt++;
                }
        }
        if(cnt==size)return true;
        return false;
    }
}
