package GameSystem;
import Tiles.Position;
import java.util.HashMap;
import Tiles.Tile;

public class Board {

    private HashMap<Position,Tile> board;

    public Board()
    {
        this.board = new HashMap<>();
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


}
