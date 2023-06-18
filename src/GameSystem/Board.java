package GameSystem;
import Tiles.Position;
import java.util.HashMap;
import Tiles.Tile;

public class Board {

    private HashMap<Position,Tile> board;
    private int boardCurrentY;
    private int boardCurrentX;

    public Board()
    {
        this.board = new HashMap<>();
        this.boardCurrentY= -1;
        this.boardCurrentX = -1;

    }

    public void addTile(Position p, Tile t)
    {
        this.board.put(p,t);
    }
    public HashMap<Position,Tile> getBoard()
    {
        return this.board;
    }

    public Tile getTileInPosition(Position p)
    {
        return this.board.get(p);
    }

    public void increaseHeight()
    {
        this.boardCurrentY++;
    }
    public void increaseX()
    {
        this.boardCurrentX++;
    }
    public void xToZero()
    {
        this.boardCurrentX = 0;
    }
    public int getBoardCurrentY() {
        return boardCurrentY;
    }

    public void setBoardCurrentY(int boardCurrentY) {
        this.boardCurrentY = boardCurrentY;
    }

    public int getBoardCurrentX() {
        return boardCurrentX;
    }

    public void setBoardCurrentX(int boardCurrentX) {
        this.boardCurrentX = boardCurrentX;
    }

    // we need implement this
    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                '}';

        //for x , y till max
        //(0,0) -> (x,y)
        // concat to the string
    }
}
