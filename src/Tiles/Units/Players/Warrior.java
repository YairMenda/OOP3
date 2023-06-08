package Tiles.Units.Players;

import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Players.SpecialAbility.AvengersShield;


public class Warrior extends Player{

    private int abilityCooldown;
    private int remainingCooldown;

    public Warrior(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                int abilityCooldown)
    {
        super(new AvengersShield("Avengers Shield",0,((Double)(health * 0.1)).intValue(),defensePoints*10 )
                ,name,attackPoints,defensePoints,new Bar(health),new Position(x,y));
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
    }

    public void LevelUP()
    {
        super.levelUP();
        this.remainingCooldown = 0;
        this.getHealth().setPool(this.getHealth().getPool() + this.getLevel()*5);
        this.setAttackPoints(this.getAttackPoints() + 2 * this.getLevel());
        this.setDefensePoints(this.getDefensePoints() + this.getLevel());
    }

    public void activateAbility()
    {
        if(this.remainingCooldown == 0)
        {
            super.activateAbility();
            this.remainingCooldown = this.abilityCooldown;
        }
    }
    public String description()
    {
        return super.description() + "  Ability Cooldown : " + this.abilityCooldown + "  Remaining Cooldown : " + this.remainingCooldown;
    }
}
