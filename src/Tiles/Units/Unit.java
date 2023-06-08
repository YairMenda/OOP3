package Tiles.Units;
import Tiles.Tile;
import Tiles.Units.Bars.Bar;
import Tiles.Position;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Unit extends Tile {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private Bar health;
    private int exp;

    public Unit(String name,int attackPoints,int defensePoints,Bar health,Position p,char symbol)
    {
        super(symbol,p);
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

    public List<Unit> getUnitsInRange(int range)
    {
        return null;
    }

    public String description()
    {
        return "Player name: " + this.name + "  AttackPoints: " +
                this.attackPoints + "  DefensePoints: " + this.defensePoints + "  " +
                this.health.toString() + "  exp: " + this.exp;
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
