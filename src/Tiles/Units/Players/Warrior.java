package Tiles.Units.Players;
import java.util.List;
import java.util.Random;
import Tiles.Units.Unit;
import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Enemy;


public class Warrior extends Player{

    private int abilityCooldown;
    private int remainingCooldown;

    public Warrior(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                int abilityCooldown)
    {
        super(name,attackPoints,defensePoints,new Bar(health),new Position(x,y));
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

    public void activateAbility(List<Enemy> enemies)
    {
        if(this.remainingCooldown == 0)
        {
            List<Enemy> enemiesInRange = enemies.stream().filter(e -> this.getP().Distance(e.getP()) < 3).toList();
            Enemy randomEnemy = enemiesInRange.get((new Random()).nextInt(0,enemiesInRange.size()));
            this.attackWithAbility(randomEnemy,(int)(this.getHealth().getPool()*0.1));
            this.getHealth().increaseBarPoints(10*this.getDefensePoints());
            this.remainingCooldown = this.abilityCooldown;
        }
    }
    public String description()
    {
        return super.description() + "  Ability Cooldown : " + this.abilityCooldown + "  Remaining Cooldown : " + this.remainingCooldown;
    }
}
