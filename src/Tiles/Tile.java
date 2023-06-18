package Tiles;
import Messages.MessegeCallBack;
import Tiles.Units.Unit;

import java.util.Comparator;

public abstract class Tile implements Comparable<Tile> {
    private char symbol;
    private Position p;
    private MessegeCallBack callBack;

    public Tile(char symbol, Position p)
    {
        this.symbol = symbol;
        this.p = p;
        this.callBack = new MessegeCallBack();
    }

    public void swapPosition(Tile t)
    {
        Position temp = this.p;
        this.p = t.getP();
        t.setP(temp);
    }

    public abstract void accept(Unit u);
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }
    public String ToString()
    {
        return this.symbol + "";
    }

    public int compareTo(Tile t)
    {
        return this.getP().compareTo(t.getP());
    }
}
