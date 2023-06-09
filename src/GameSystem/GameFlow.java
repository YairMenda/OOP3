package GameSystem;
import Tiles.Empty;
import Tiles.Tile;
import Tiles.Units.Players.Player;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import Tiles.Units.Players.Player;

public class GameFlow {
    private Level currentLevel;
    private String directoryPath;
    //private String directoryPath = "\\C:\\OOP3\\OOP3\\levels_dir\\";
    public GameFlow(String directoryPath)
    {
        System.out.println();
        System.out.println("Game Keys - w = up  - d = right  - s = down - a = left - e = ability");
        System.out.println();
        this.currentLevel = new Level();
        System.out.println(currentLevel.showPlayers());
        this.directoryPath = directoryPath;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your player from the list");
        int playerChosen = scanner.nextInt();
        currentLevel.choosePlayer(playerChosen);

    }

    public void ActivateGame() {


        Scanner scanner = new Scanner(System.in);
        int levelNumber = 1;
        while (!currentLevel.gameOver() & currentLevel.hasLevel(directoryPath + "\\level" + levelNumber + ".txt")) {

            currentLevel.loadLevel(directoryPath + "\\level" + levelNumber + ".txt");

            while (!currentLevel.gameOver() & !currentLevel.isOver()) {
                System.out.println();
                currentLevel.levelInfo();
                System.out.println("Your turn - ");
                String userAction = scanner.nextLine();
                currentLevel.gameTick(userAction);

            }

            levelNumber++;
        }

        System.out.println("\n GAME OVER!!!");
    }

}

