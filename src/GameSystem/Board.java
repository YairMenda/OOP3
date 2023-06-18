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

    public void addTile(Tile t)
    {
        this.board.put(t.getP(),t);
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

        String boardString =  "";

        for (int y= 0; y <= this.boardCurrentY; y++) {
            for (int x = 0; x <= this.boardCurrentX; x++) {
                boardString += getTileInPosition(new Position(x, y));
            }
        }

        return boardString;
    }
}
