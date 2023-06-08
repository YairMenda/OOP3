package Tiles.Units.Players;
import Tiles.Position;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Players.SpecialAbility.Blizzard;
import Tiles.Units.Players.SpecialAbility.SpecialAbility;

public class Mage extends Player{

    private Bar mana;
    private int spellPower;

    public Mage(String name ,  int attackPoints, int defensePoints, int health, int x, int y ,
                int manaPool , int spellPower , int saCost , int hitsCount , int range)
    {
        super(new Blizzard("Blizzard", saCost, spellPower , hitsCount , range)
                ,name,attackPoints,defensePoints,new Bar(health),new Position(x,y));
        this.mana = new Bar(manaPool);
        this.spellPower = spellPower;
    }

    public void LevelUP()
    {
        super.levelUP();
        this.mana.setPool(mana.getPool() + this.getLevel()*25);
        this.spellPower = this.spellPower + this.getLevel() * 10;
    }

    public void activateAbility()
    {
        if(this.mana.getCurrent() >= this.getSpecialAB().getCost())
        {
            super.activateAbility();
            this.mana.setCurrent(this.mana.getCurrent() - this.getSpecialAB().getCost());
        }
    }
    public String description()
    {
        return super.description() + "  Mana : " + mana.toString() + "  Spell Power : " + this.spellPower;
    }
}
