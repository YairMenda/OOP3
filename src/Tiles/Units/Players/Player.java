package Tiles.Units.Players;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Players.SpecialAbility.SpecialAbility;

import Tiles.Units.Unit;

public class Player extends Unit {

    private int level;
    private SpecialAbility specialAB;
    public Player(SpecialAbility specialAB, String name, int attackPoints, int defensePoints, Bar health, int x, int y, char symbol)
    {
        super(name,attackPoints,defensePoints,health,x,y,'@');
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
                exp = exp - this.level * 50 + this.getExp();
                levelUP();
                gainEXP(exp);
            }
            this.setExp(this.getExp()+exp);
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
}
