package GameSystem;

import Tiles.Empty;
import Tiles.Tile;
import Tiles.Units.Monster;
import Tiles.Units.Players.Player;
import Tiles.Units.Trap;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GameFlow {
    private Level currentLevel;
    private String directoryPath = "\"C:\\OOP3\\OOP3\\levels_dir\\";
    public GameFlow(int playerChosen)
    {
        this.currentLevel = new Level(playerChosen);
    }

    public void ActivateGame() {

        Scanner scanner = new Scanner(System.in);
        int levelNumber = 1;
        while (!currentLevel.gameOver() & currentLevel.hasLevel(directoryPath + "level" + levelNumber + ".txt")) {

            currentLevel.loadLevel(directoryPath + "level" + levelNumber + ".txt");

            while (!currentLevel.gameOver() & !currentLevel.isOver()) {
                System.out.println("Your turn - ");
                String userAction = scanner.nextLine();
                currentLevel.gameTick(userAction);
            }

            levelNumber++;
        }
    }
}

