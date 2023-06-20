package Tiles.Units.Players.Roles;
import Messages.MessegeCallBack;
import Tiles.Position;
import Tiles.Tile;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Enemies.Enemy;
import Tiles.Units.Players.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Mage extends Player {

    private Bar mana;
    private int spellPower;
    private int abilityRange;
    private int abilityCost;
    private int hitsCount;

    private MessegeCallBack callBack;

    public Mage(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                int manaPool , int spellPower , int abilityCost , int hitsCount , int abilityRange)
    {
        super(name,attackPoints,defensePoints,new Bar(health),new Position(x,y));
        this.mana = new Bar(manaPool);
        this.spellPower = spellPower;
        this.abilityRange = abilityRange;
        this.abilityCost = abilityCost;
        this.hitsCount = hitsCount;
        callBack = new MessegeCallBack();
    }

    public void levelUP()
    {
        super.levelUP();
        this.mana.setPool(mana.getPool() + this.getLevel()*25);
        this.mana.increaseBarPoints(this.mana.getPool()/4);
        this.spellPower = this.spellPower + this.getLevel() * 10;
    }

    public void activateAbility(List<Enemy> enemies)
    {
        callBack.onMessageRecieved("Mage " + this.getName() + " Just activated special ability Blizzard!");
        if(this.mana.getCurrent() >= this.abilityCost)
        {
            List<Enemy> enemiesInRange = new LinkedList<Enemy>();
            enemiesInRange = enemies.stream().filter(e -> this.getP().Distance(e.getP()) <= this.abilityRange).collect(Collectors.toList());
            if (enemiesInRange.size() == 0)
                callBack.onMessageRecieved("No enemies in Blizzard Range");
            else
            {
                this.mana.decreasBarPoints(this.abilityCost);
                for (int i = 1; i <= this.hitsCount && enemiesInRange.size() > 0; i++) {
                    int index = (new Random()).nextInt(0, enemiesInRange.size());
                    Enemy randomEnemy = enemiesInRange.get(index);
                    if (!randomEnemy.isDead()) {
                        this.attackWithAbility(randomEnemy, this.spellPower);
                    }
                    else
                        enemiesInRange.remove(index);
                }
            }
        }
        else
            this.callBack.onMessageRecieved("Not enough mana to use special ability");
    }

    public void move(Tile t)
    {
        this.interact(t);
        this.mana.increaseBarPoints(this.getLevel());
    }
    public String description()
    {
        return super.description() + "  Mana : (" + mana.toString() + ")  Spell Power : " + this.spellPower + " ability range " + this.abilityRange;
    }
    public void info()
    {
        this.callBack.onMessageRecieved("Mage " + this.getName() + "\n Stats : " + this.description() + "\n");
    }
}
