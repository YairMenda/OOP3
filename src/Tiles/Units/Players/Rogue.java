package Tiles.Units.Players;

import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Players.SpecialAbility.FanOfKnives;

public class Rogue extends Player{

    private Bar energy;
    public Rogue(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                   int cost) {
        super(new FanOfKnives("Fan Of Knives", cost, attackPoints)
                , name, attackPoints, defensePoints, new Bar(health), new Position(x, y));
        this.energy = new Bar(100);
    }

    public void levelUP()
    {
        super.levelUP();
        this.energy.setCurrent(100);
        this.setAttackPoints(this.getAttackPoints() + this.getLevel() * 3);
    }

    public void activateAbility()
    {
        if(this.energy.getCurrent() >= this.getSpecialAB().getCost())
        {
            super.activateAbility();
            this.energy.setCurrent(this.energy.getCurrent() - this.getSpecialAB().getCost());
        }
    }

    public String description()
    {
        return super.description() + " Energy : " + this.energy.toString();
    }
}
