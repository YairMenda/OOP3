package Tiles;
import Tiles.Units.Unit;

public class Empty extends Tile{
    public Empty(int x,int y)
    {
        super('.',new Position(x,y));
    }
    public void accept(Unit u)
    {
        u.visit(this);
    }
}
