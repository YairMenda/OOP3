<<<<<<< HEAD
import GameSystem.GameFlow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your player from the list");
        int playerChosen = scanner.nextInt();
        GameFlow game = new GameFlow(playerChosen);
        game.ActivateGame();
=======
import Tiles.Tile;
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Enemies.Trap;
import Tiles.Units.Players.Roles.Mage;
import Tiles.Units.Unit;

public class Main {
    public static void main(String[] args)
    {
        Unit player = new Mage("Roy" , 10 , 10 , 100 , 2,2,50,15,20,3,3);
        Unit monster = new Monster(50,"Menash",20,5,40,3,2,'s',3);
        monster.move(player);
        player.info();
>>>>>>> main
    }
}