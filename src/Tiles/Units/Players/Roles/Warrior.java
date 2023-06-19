package Tiles.Units.Players.Roles;
import java.util.List;
import java.util.Random;

import Messages.MessegeCallBack;
import Tiles.Position;
import Tiles.Tile;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Enemies.Enemy;
import Tiles.Units.Players.Player;


public class Warrior extends Player {

    private int abilityCooldown;
    private int remainingCooldown;
    private MessegeCallBack callBack;

    public Warrior(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                int abilityCooldown)
    {
        super(name,attackPoints,defensePoints,new Bar(health),new Position(x,y));
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
        callBack = new MessegeCallBack();
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
            callBack.onMessageRecieved("Warrior " + this.getName() + " Just activated special ability Avengers Shield!");
            this.attackWithAbility(randomEnemy,(int)(this.getHealth().getPool()*0.1));
            this.getHealth().increaseBarPoints(10*this.getDefensePoints());
            this.remainingCooldown = this.abilityCooldown;
        }
        else
            this.callBack.onMessageRecieved("Still have cooldown remaining to use special ability");

    }
    public void move(Tile t)
    {
        this.interact(t);
        if(this.remainingCooldown > 0)
            this.remainingCooldown--;
    }
    public String description()
    {
        return super.description() + "  Ability Cooldown : " + this.abilityCooldown + "  Remaining Cooldown : " + this.remainingCooldown;
    }
    public void info()
    {
        this.callBack.onMessageRecieved("Warrior " +this.getName() + " Stats : " + this.description());
    }
}
