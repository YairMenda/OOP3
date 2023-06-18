package Tiles.Units.Bars;

public class Bar {
    private int pool;
    private int current;

    public Bar(int amount)
    {
        this.pool = amount;
        this.current = amount;
    }

    public void increaseBarPoints(int amount)
    {
        if(this.current + amount > this.pool)
            this.current = this.pool;
        else
            this.current += amount;
    }

    public void decreasBarPoints(int amount)
    {
        if(this.current - amount < 0)
            this.current = 0;
        else
            this.current -= amount;
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

    public void setCurrent(int current)
    {
            this.current = current;
    }

    public String toString()
    {
        return " Max Points : " + this.pool + " Current Points : " + this.current;
    }

}
