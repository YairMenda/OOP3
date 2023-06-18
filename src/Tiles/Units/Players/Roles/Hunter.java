package Tiles.Units.Players.Roles;

import Messages.MessegeCallBack;
import Tiles.Position;
import Tiles.Tile;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Enemies.Enemy;
import Tiles.Units.Players.Player;

import java.util.List;
import java.util.Random;

public class Hunter extends Player {

    private int range;
    private int arrowsCount;
    private int ticksCount;
    private MessegeCallBack callBack;

    public Hunter(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                int range)
    {
        super(name,attackPoints,defensePoints,new Bar(health),new Position(x,y));
        this.range = range;
        this.arrowsCount = 10;
        this.ticksCount = 0;
        callBack = new MessegeCallBack();
    }

    public void LevelUP()
    {
        super.levelUP();
        this.arrowsCount += this.getLevel()*10;
        this.setAttackPoints(this.getAttackPoints() + (2*this.getLevel()));
        this.setDefensePoints(this.getDefensePoints() + this.getLevel());
    }

    public void activateAbility(List<Enemy> enemies)
    {
        if(this.arrowsCount > 0)
        {
            List<Enemy> enemiesInRange = enemies.stream().filter(e -> this.getP().Distance(e.getP()) <= this.range).toList();
            Enemy closest = enemies.get(1);
            for(Enemy e : enemies)
            {
                if(this.getP().Distance(e.getP()) < this.getP().Distance(closest.getP()))
                    closest = e;
            }
            this.attackWithAbility(closest,this.getAttackPoints());
            this.arrowsCount--;
            callBack.onMessageRecieved("Hunter " + this.getName() + " Just activated special ability Shoot!");
        }
    }
    public void move(Tile t)
    {
        this.interact(t);
        if(this.ticksCount == 10)
        {
            this.arrowsCount += this.getLevel();
            this.ticksCount = 0;
        }
        else
            this.ticksCount++;
    }
    public String description()
    {
        return super.description() + "  Range : " + this.range + " Arrows Count : " + this.arrowsCount + " TicksCount : " + this.ticksCount;
    }
    public void info()
    {
        this.callBack.onMessageRecieved("Mage " + this.getName() + " Stats : " + this.description());
    }
}
