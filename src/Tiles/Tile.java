package Tiles;

public class Tile{
    private char c;
    private Position p;

    public Tile(char c, Position p)
    {
        this.c = c;
        this.p = p;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }
    public String ToString()
    {
        return this.c + "";
    }
}
