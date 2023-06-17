package Tiles.Units.Players;
import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Enemy;
import Tiles.Units.Unit;
import java.util.List;
import java.util.Random;

public class Mage extends Player{

    private Bar mana;
    private int spellPower;
    private int abilityRange;
    private int abilityCost;
    private int hitsCount;

    public Mage(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                int manaPool , int spellPower , int abilityCost , int hitsCount , int abilityRange)
    {
        super(name,attackPoints,defensePoints,new Bar(health),new Position(x,y));
        this.mana = new Bar(manaPool);
        this.spellPower = spellPower;
        this.abilityRange = abilityRange;
        this.abilityCost = abilityCost;
        this.hitsCount = hitsCount;
    }

    public void LevelUP()
    {
        super.levelUP();
        this.mana.setPool(mana.getPool() + this.getLevel()*25);
        this.mana.increaseBarPoints(this.mana.getPool()/4);
        this.spellPower = this.spellPower + this.getLevel() * 10;
    }

    public void activateAbility(List<Enemy> enemies)
    {
        if(this.mana.getCurrent() >= this.abilityCost)
        {
            List<Enemy> enemiesInRange = enemies.stream().filter(e -> this.getP().Distance(e.getP()) <= this.abilityRange).toList();
            for(int i = 1 ; i <= this.hitsCount ; i++)
            {
                Enemy randomEnemy = enemiesInRange.get((new Random()).nextInt(0,enemiesInRange.size()));
                this.attackWithAbility(randomEnemy,this.spellPower);
            }
            this.mana.decreasBarPoints(this.abilityCost);
        }
    }
    public String description()
    {
        return super.description() + "  Mana : " + mana.toString() + "  Spell Power : " + this.spellPower;
    }
}
