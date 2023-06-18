package Tiles.Units.Enemies;
import Messages.MessegeCallBack;
import Tiles.Units.Players.Player;
import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Tile;
import Tiles.Units.Unit;

import java.util.Random;

public class Monster extends Enemy {
    private int vision;
    private MessegeCallBack callBack;

    public Monster(int expRaise, String name, int attackPoints, int defensePoints, Bar health, int x, int y, char symbol, int vision)
    {
        super(expRaise, name,attackPoints,defensePoints,health,new Position(x,y),symbol);
        this.vision = vision;
        callBack = new MessegeCallBack();
    }

    public void visit (Player p)
    {
        this.combat(p);
    }

    public void visit (Trap t)
    {

    }

    public void  visit(Monster m)
    {
        this.swapPosition(m);
    }

    public void visit(Enemy e)
    {
        e.visit(this);
    }
    public void accept(Unit u)
    {
        u.visit(this);
    }
    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }
    public void onDeath(Unit killer)
    {
        killer.gainEXP(this.getExpRaise());
        killer.swapPosition(this);
        callBack.onMessageRecieved("Monster " + this.getName() + " died.");
    }

    public void gainEXP(int exp)
    {

    }
    public void move(Tile t)
    {
        this.interact(t);
    }
    public int chooseDirection(Player p)
    {
        if(this.getP().Distance(p.getP()) < this.vision)
        {
            int dx = this.getP().getX() - p.getP().getX();
            int dy = this.getP().getY() - p.getP().getY();
            if(Math.abs(dx) > Math.abs(dy))
            {
                if(dx > 0)
                    return 0;
                else
                    return 2;
            }
            else
            {
                if(dy > 0)
                    return 1;
                else
                    return 3;
            }
        }
        else
            return ((new Random()).nextInt(0,4));
    }
    @Override
    public String description() {
        return super.description() + " vision = " + vision;
    }
    public void info()
    {
        this.callBack.onMessageRecieved(this.getName() + " Stats : " + this.description());
    }
}
