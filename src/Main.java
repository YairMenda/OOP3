import GameSystem.GameFlow;
import Tiles.Tile;
import Tiles.Units.Enemies.Enemy;
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Enemies.Trap;
import Tiles.Units.Players.Roles.Mage;
import Tiles.Units.Unit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GameFlow game = new GameFlow(args[0]);
        game.ActivateGame();

/*        UnitTest u = new UnitTest();
        u.initTest();

        u.gainEXP();
        u.activateAbility();
        u.combat();
        u.isDead();
        u.interactEmpty();
        u.interactWall();
        u.onDeath();*/
    }
}