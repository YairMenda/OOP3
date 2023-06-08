package Tiles.Units;

import Tiles.Units.Bars.Bar;

public class Monster extends Unit{
    private int vision;

    public Monster(String name, int attackPoints, int defensePoints, Bar health, int x, int y, char symbol)
    {
        super(name,attackPoints,defensePoints,health,x,y,symbol);
        this.vision = vision;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    @Override
    public String toString() {
        return super.toString() + " vision = " + vision;
    }
}
