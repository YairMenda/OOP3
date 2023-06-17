package Tiles.Units;
import Tiles.Units.Players.Player;
import Tiles.Position;
import Tiles.Units.Bars.Bar;

public class Trap extends Enemy{
    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;

    public Trap(int expRaise, String name, int attackPoints, int defensePoints, Bar health, int x, int y, char symbol, int visibilityTime, int invisibilityTime) {
        super(expRaise, name, attackPoints, defensePoints, health,new Position(x,y), symbol);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
    }
    public void visit (Player p)
    {
    }

    public void visit(Enemy e)
    {

    }

    public void accept(Unit u)
    {
        u.visit(this);
    }
    public void onDeath(Unit killer)
    {
        killer.gainEXP(this.getExpRaise());
        killer.swapPosition(this);
    }
    public void gainEXP(int exp) { }

    public void gameTick(Player p)
    {
        this.visible = ticksCount < visibilityTime;
        if(ticksCount == visibilityTime+invisibilityTime)
            ticksCount = 0;
        else
            ticksCount ++;
        if(this.getP().Distance(p.getP()) < 2)
            this.combat(p);
    }
    public String toString()
    {
        if (visible)
            return super.toString();
        return ".";
    }
    @Override
    public String description()
    {
        return super.description() + "visibilityTime = " + this.visibilityTime + "InVisibilityTime = "
                + this.invisibilityTime + "visible = " + this.visible + " ticksCount = " + this.ticksCount;
    }
}
