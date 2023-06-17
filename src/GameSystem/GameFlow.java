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
    private List<Path> PathLevels;
    public GameFlow()
    {
        this.player = player;
        this.gameOver = false;
        this.board = new Board();
    }

}
