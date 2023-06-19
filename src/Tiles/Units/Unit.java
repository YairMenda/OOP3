package Tiles.Units;
import Messages.MessegeCallBack;
import Tiles.Empty;
import Tiles.Tile;
import Tiles.Units.Bars.Bar;
import Tiles.Position;
import Tiles.Wall;
import Tiles.Units.Players.Player;
import Tiles.Units.Enemies.Enemy;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public abstract  class Unit extends Tile {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private Bar health;
    private MessegeCallBack callBack;

    public Unit(String name,int attackPoints,int defensePoints,Bar health,Position p,char symbol)
    {
        super(symbol,p);
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.health = health;
        this.callBack = new MessegeCallBack();
    }

    public void interact(Tile t)
    {
        t.accept(this);
    }
    public void visit(Wall w)
    {

    }
    public void visit(Empty e)
    {
        this.swapPosition(e);
    }
    public abstract void visit(Player p);

    public abstract void visit(Enemy e);
    public boolean isDead()
    {
        return this.getHealth().getCurrent() == 0;
    }

    public abstract void onDeath(Unit killer);
    public abstract void gainEXP(int exp);
    public void combat(Unit u)
    {
        this.callBack.onMessageRecieved(this.getName() + " just started a fight with " + u.getName());
        this.info();
        u.info();
        int randomAttack = (new Random()).nextInt(0,attackPoints+1);
        int randomDefense = (new Random()).nextInt(0,u.getDefensePoints()+1);
        if(randomAttack > randomDefense)
        {
            u.getHealth().decreasBarPoints(randomAttack - randomDefense);
            callBack.onMessageRecieved(this.getName() + " attacked with " + (randomAttack - randomDefense) + " points");
            u.info();
        }
        else
            callBack.onMessageRecieved("Attack was too low to break" + u.getName() + "defense");
        if(u.isDead())
            u.onDeath(this);
    }

    public abstract void activateAbility(List<Enemy> enemies);
    public void move(Tile t)
    {
        this.interact(t);
    }


    public String description()
    {
        return " name: " + this.name + "  AttackPoints: " +
                this.attackPoints + "  DefensePoints: " + this.defensePoints + "  " +
                "Health Points : (" + this.health.toString() + ")";
    }
    public abstract void info();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public Bar getHealth() {
        return health;
    }

    public void setHealth(Bar health) {
        this.health = health;
    }

}
