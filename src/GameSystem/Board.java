package GameSystem;
import Tiles.Position;
import java.util.HashMap;
import Tiles.Tile;

public class Board {

    private Tile[][] board;
    private int boardCurrentY;

    public Board(int sizeX,int sizeY)
    {
        this.board = new Tile[sizeX][sizeY];
        this.boardCurrentY= 0;

    }
    public void addTile(Tile t)
    {
        this.board[t.getP().getX()][t.getP().getY()] = t;
    }
    public Tile getTileInPosition(Position p)
    {
      return this.board[p.getX()][p.getY()];
    }

    public void increaseHeight()
    {
        this.boardCurrentY++;
    }

    public void swapPosition(Position p1,Position p2)
    {
        Tile temp = this.board[p2.getX()][p2.getY()];
        this.board[p2.getX()][p2.getY()] = this.board[p1.getX()][p1.getY()];
        this.board[p1.getX()][p1.getY()] = temp;
    }
    public int getBoardCurrentY() {
        return boardCurrentY;
    }

    public void setBoardCurrentY(int boardCurrentY) {
        this.boardCurrentY = boardCurrentY;
    }

    // we need implement this
    @Override
    public String toString() {

        String boardString =  "";

        for (int y= 0; y < this.board[0].length; y++) {
            for (int x = 0; x < this.board.length; x++) {
                boardString += getTileInPosition(new Position(x, y)).toString();
            }
            boardString += "\n";
        }

        return boardString;
    }

    public Tile[][] getBoard() {
        return board;
    }
}
