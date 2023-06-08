package Tiles.Units.Players;
import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Players.SpecialAbility.SpecialAbility;

import Tiles.Units.Unit;

public class Player extends Unit {

    private int level;
    private SpecialAbility specialAB;
    public Player(SpecialAbility specialAB, String name, int attackPoints, int defensePoints, Bar health, Position p)
    {
        super(name,attackPoints,defensePoints,health,p,'@');
        this.level = 1;
        this.specialAB = specialAB;
    }

    public void activateAbility()
    {
        this.specialAB.activateAbility();
    }

    public void gainEXP(int exp)
    {
        while(exp > 0)
        {
            if(this.getExp() + exp > this.level * 50)
            {
                exp = exp - (this.level * 50 - this.getExp());
                levelUP();
            }
            else
            {
                this.setExp(this.getExp()+exp);
                exp = 0;
            }
        }
    }
    public void levelUP()
    {
        this.setExp(0);
        this.level++;
        this.getHealth().setPool(this.getHealth().getPool() + 10 * this.level);
        this.getHealth().setCurrent(this.getHealth().getPool());
        this.setAttackPoints(this.getAttackPoints() + this.level*4);
        this.setDefensePoints(this.getDefensePoints() + this.level);
    }
    
    public String description()
    {
        return super.description() + " Level : " + this.level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public SpecialAbility getSpecialAB() {
        return specialAB;
    }

    public void setSpecialAB(SpecialAbility specialAB) {
        this.specialAB = specialAB;
    }
}
