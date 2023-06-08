package Tiles.Units.Players.SpecialAbility;

public class AvengersShield extends SpecialAbility{
    int heal;

    public AvengersShield(String name,int cost ,int damage , int heal)
    {
        super(name, cost, damage);
        this.heal = heal;
    }

    public void activateAbility()
    {

    }

    @Override
    public String toString() {
        return super.toString() + " Heal points = " + heal;
    }
}
