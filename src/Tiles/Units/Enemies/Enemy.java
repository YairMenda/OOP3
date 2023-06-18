package Tiles.Units.Enemies;
import Tiles.Units.Bars.Bar;
import Tiles.Position;
import java.util.List;
import Tiles.Units.Players.Player;
import Tiles.Units.Unit;

public abstract class Enemy extends Unit {
    private int expRaise;
    public Enemy(int expRaise ,String name, int attackPoints, int defensePoints, Bar health,Position p, char symbol)
    {
        super(name,attackPoints,defensePoints,health,p,symbol);
        this.expRaise = expRaise;
    }

    public int getExpRaise()
    {
        return this.expRaise;
    }

    public void activateAbility(List<Enemy> enemies) { }
    public abstract void onDeath(Unit killer);
    public abstract void info();
    public abstract void visit(Player p);
    public abstract void visit(Enemy e);
    public abstract void accept(Unit u);




}
