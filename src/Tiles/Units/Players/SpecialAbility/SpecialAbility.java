package Tiles.Units.Players.SpecialAbility;

public class SpecialAbility {
    private String name;
    private int cost;
    private int damage;

    public SpecialAbility(String name, int cost, int damage) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void activateAbility()
    {
        this.activateAbility();
    }

    public String toString() {
               return  "name = '" + name + ", cost = " + cost + ", damage = " + damage;
    }
}
