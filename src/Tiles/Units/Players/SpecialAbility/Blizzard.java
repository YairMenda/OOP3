package Tiles.Units.Players.SpecialAbility;

public class Blizzard extends SpecialAbility{

    private int hitsCount;

    private int abilityRange;

    public Blizzard(String name,int cost ,int damage , int hitsCount, int abilityRange)
    {
        super(name, cost, damage);
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
    }

    public int getHitsCount() {
        return hitsCount;
    }

    public void setHitsCount(int hitsCount) {
        this.hitsCount = hitsCount;
    }

    public int getAbilityRange() {
        return abilityRange;
    }

    public void setAbilityRange(int abilityRange) {
        this.abilityRange = abilityRange;
    }

    public void activateAbility()
    {

    }

    @Override
    public String toString() {
        return super.toString() + " Hits Counts = " + hitsCount + "Ability Range = " + abilityRange;
    }
}
