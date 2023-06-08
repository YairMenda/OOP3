package Tiles.Units.Bars;

public class Bar {
    private int pool;
    private int current;

    public Bar(int amount)
    {
        this.pool = amount;
        this.current = amount;
    }
    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String toString()
    {
        return " Pool Points : " + this.pool + " Current Points : " + this.current;
    }

}
