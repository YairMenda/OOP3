package Tiles.Units;

import Tiles.Units.Bars.Bar;

public class Trap extends Unit{
    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;

    public Trap(String name, int attackPoints, int defensePoints, Bar health, int x, int y, char symbol, int visibilityTime, int invisibilityTime) {
        super(name, attackPoints, defensePoints, health, x, y, symbol);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
    }
    public String toString()
    {
        if (visible)
            return super.toString();
        return ".";
    }
    @Override
    public String description()
    {
        return super.description() + "visibilityTime = " + this.visibilityTime + "InVisibilityTime = "
                + this.invisibilityTime + "visible = " + this.visible + " ticksCount = " + this.ticksCount;
    }
}
