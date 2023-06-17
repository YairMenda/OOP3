package Tiles;

import Tiles.Units.Unit;

public class Wall extends Tile{
    public Wall(int x,int y)
    {
        super('#',new Position(x,y));
    }
    public void accept(Unit u)
    {
        u.visit(this);
    }
}
