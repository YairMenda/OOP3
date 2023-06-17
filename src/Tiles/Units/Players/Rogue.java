package Tiles.Units.Players;
import java.util.List;
import Tiles.Units.Enemy;
import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Unit;


public class Rogue extends Player{

    private Bar energy;
    private int abilityCost;
    public Rogue(String name ,  int attackPoints, int defensePoints, int health, int x, int y , int abilityCost)
    {
        super(name, attackPoints, defensePoints, new Bar(health), new Position(x, y));
        this.energy = new Bar(100);
        this.abilityCost = abilityCost;
    }

    public void levelUP()
    {
        super.levelUP();
        this.energy.setCurrent(100);
        this.setAttackPoints(this.getAttackPoints() + this.getLevel() * 3);
    }

    public void activateAbility(List<Enemy> enemies)
    {
        if(this.energy.getCurrent() >= this.abilityCost)
        {
            List<Enemy> enemiesInRange = enemies.stream().filter(e -> this.getP().Distance(e.getP()) < 2).toList();
            for(Enemy e : enemiesInRange)
            {
                this.attackWithAbility(e,this.getAttackPoints());
            }
            this.energy.decreasBarPoints(this.abilityCost);
        }
    }

    public String description()
    {
        return super.description() + " Energy : " + this.energy.toString();
    }
}
