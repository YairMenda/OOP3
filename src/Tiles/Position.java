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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "Position( " + x + " , " + y + "' )'";
    }
    //up and right is bigger
    public int Equals(Position p)
    {
        if ( (this.y < p.y) | (this.y == p.y & this.x < p.x) )
            return -1;
        if ( (this.y > p.y) | (this.y == p.y & this.x > p.x) )
            return 1;
        return 0;
    }
}
