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
    }
}