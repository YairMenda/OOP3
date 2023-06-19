package Tiles.Units.Players;
import java.util.List;

import Messages.MessegeCallBack;
import Tiles.Tile;
import Tiles.Units.Enemies.Enemy;
import Tiles.Position;
import Tiles.Units.Bars.Bar;

import Tiles.Units.Unit;

public abstract class Player extends Unit {

    private int level;
    private int exp;
    private MessegeCallBack callBack;

    public Player(String name, int attackPoints, int defensePoints, Bar health, Position p)
    {
        super(name,attackPoints,defensePoints,health,p,'@');
        this.level = 1;
        this.exp = 0;
        callBack = new MessegeCallBack();
    }

    public void visit(Enemy e)
    {
        this.combat(e);
    }
    public void accept(Unit u)
    {
        u.visit(this);
    }
    public void visit(Player p)
    {

    }
    public abstract void activateAbility(List<Enemy> enemies);

    public void attackWithAbility(Enemy e,  int attackPoints)
    {
        if(attackPoints > e.getDefensePoints())
        {
            e.getHealth().decreasBarPoints(attackPoints - e.getDefensePoints());
            callBack.onMessageRecieved(this.getName() + " attacked " + e.getName() +
                    " with " + (attackPoints - e.getDefensePoints()) + " attack points!");
            e.info();
            if (e.isDead())
                e.onDeath(this,true);
        }
        else
            callBack.onMessageRecieved("Attack was too low to break " + e.getName() + " defense");

    }
    public void gainEXP(int exp)
    {
        callBack.onMessageRecieved("Player " + this.getName() + " just Gained " + exp + " EXP");
        while(exp > 0)
        {
            if(this.getExp() + exp > this.level * 50)
            {
                exp = exp - (this.level * 50 - this.getExp());
                levelUP();
            }
            else
            {
                this.setExp(this.getExp()+exp);
                exp = 0;
            }
        }
        this.info();
    }

    public abstract void move(Tile t);
    public void onDeath(Unit killer,boolean fromAbility)
    {
        this.setSymbol('X');
        killer.swapPosition(this);
        callBack.onMessageRecieved("Player " + this.getName() + " died.");
    }
    public void levelUP()
    {
        this.setExp(0);
        this.level++;
        this.getHealth().setPool(this.getHealth().getPool() + 10 * this.level);
        this.getHealth().setCurrent(this.getHealth().getPool());
        this.setAttackPoints(this.getAttackPoints() + this.level*4);
        this.setDefensePoints(this.getDefensePoints() + this.level);
        callBack.onMessageRecieved("Player " + this.getName() + " just leveled up to level: " + this.getLevel());
    }

    public String description()
    {
        return super.description() + " Level : " + this.level + " exp : " + this.exp;
    }
    public abstract void info();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
