package Tiles;

public class Position {
    private int x;
    private int y;

    public Position(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public Double Range(Position p)
    {
        return Math.sqrt( ((this.x - p.x) ^ 2) + ((this.y - p.y) ^ 2));
    }

}
