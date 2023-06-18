package GameSystem;

import Tiles.Empty;
import Tiles.Units.Monster;
import Tiles.Units.Players.Player;
import Tiles.Units.Trap;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class GameFlow {
    private Player player;
    private Level currentLevel;
    private String directoryPath = "\"C:\\OOP3\\OOP3\\levels_dir\\";
    public GameFlow()
    {
        this.player = player;
        this.currentLevel = new Level(this.player);
    }

    public void ActivateGame()
    {
        int levelNumber = 1;
        while (currentLevel.hasLevel(directoryPath + "level" + levelNumber + ".txt")) {

            currentLevel.loadLevel(directoryPath + "level" + levelNumber + ".txt");

            while (!player.isDead()) {
                while (!currentLevel.isOver()) {
                    // input from the user
                    //enemies turn
                    currentLevel.gameTick();

                }
            }
                levelNumber++;
            }
    }

}
