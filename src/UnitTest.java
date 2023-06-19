import Tiles.Position;
import org.junit.Assert;
import Tiles.Empty;
import Tiles.Tile;
import Tiles.Units.Enemies.Enemy;
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Enemies.Trap;
import Tiles.Units.Players.Player;
import Tiles.Units.Players.Roles.Mage;
import Tiles.Wall;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

class UnitTest {
    private Player player;
    private Tile wall;
    private Tile empty;
    private Enemy monster;
    private Enemy trap;
    @Before
    public void initTest()
    {
        this.player = new Mage("Tal van goh",10,10,100,2,2,50,20,10,5,5);
        this.wall = new Wall(2,5);
        this.empty = new Empty(2,6);
        this.monster = new Monster(25,"azam",13,0,50,12,7,'$',2);
        this.trap = new Trap(100,"Exam",56,1,100,3,3,'%',10,3);
    }

    @Test
    void interactWall() {

        Position p = wall.getP();
        player.move(wall);
        Assert.assertEquals("should print true if not moved ",true ,player.getP().compareTo(p) != 0);
    }

    @Test
    void interactEmpty() {
        Position p = empty.getP();
        player.move(empty);
        Assert.assertEquals("should print true if moved ",true ,player.getP().compareTo(p) == 0);
    }

    @Test
    void isDead() {
        Assert.assertEquals("should print false if player is alive",false ,player.isDead());

    }

    @Test
    void onDeath() {
        player.getHealth().decreasBarPoints(player.getHealth().getPool());
        player.onDeath(monster,false);
        Assert.assertEquals("should print true if symbol changed to X ",true ,player.getSymbol()== 'X');
        //increase health for upcoming tests
        player.getHealth().increaseBarPoints(player.getHealth().getPool());
    }

    @Test
    void gainEXP() {
        player.gainEXP(150);
        Assert.assertEquals("should print true if level is 3 ",true ,player.getLevel() == 3);

    }

    @Test
    void combat() {
        player.move(monster);
        Assert.assertEquals("should print true if monster's health decreased",true
                ,monster.getHealth().getCurrent() < monster.getHealth().getPool());
        //recharge health for upcoming tests
        monster.getHealth().increaseBarPoints(monster.getHealth().getPool());


    }

    @Test
    void activateAbility() {
        List<Enemy> enemies = new LinkedList<Enemy>();
        enemies.add(trap);
        enemies.add(monster);
        player.activateAbility(enemies);

        Assert.assertEquals("should print true if enemies health decreased ",true
                ,monster.getHealth().getCurrent() < monster.getHealth().getPool()
                        || trap.getHealth().getCurrent() < trap.getHealth().getPool());

    }

}