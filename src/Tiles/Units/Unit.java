package Tiles.Units;
import Tiles.Tile;
import Tiles.Units.Bars.Bar;
import jdk.jshell.spi.ExecutionControl;

public class Unit extends Tile {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private Bar health;
    private int exp;

    public Unit(String name,int attackPoints,int defensePoints,Bar health,int x,int y,char symbol)
    {
        super(symbol,new Position(x,y));
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.health = health;
        this.exp = 0;
    }

    public void attack()
    {

    }

    public void defense(int damage)
    {

    }

    public void move()
    {

    }

    public String description()
    {
        System.out.println("Player name: " + this.name + "  AttackPoints: " +
                this.attackPoints + "  DefensePoints: " + this.defensePoints + "  " +
                this.health.toString() + "  exp: " + this.exp);
    }

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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
