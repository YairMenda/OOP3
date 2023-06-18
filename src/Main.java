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

        GameFlow game = new GameFlow();
        game.ActivateGame();
/*        Enemy m = new Monster(10,"roi",5,5,100,0,1,'s',3);
        Enemy e = new Monster(10,"menash",2,5,10,0,2,'s',3);
        m.visit(e);*/
    }
}