package GameSystem;

import Tiles.Empty;
import Tiles.Units.Monster;
import Tiles.Units.Players.Player;
import Tiles.Units.Trap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Level {
    private Board board;
    private List<Monster> monsters;
    private List<Trap> traps;
    private Player player;
    private boolean gameOver;

    public Level(String path,int levelNumber)
    {
        Path p = Paths.get(path+""+levelNumber);
        try {
            String boardString = Files.readString(p);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        this.board = new Board();
        this.monsters = new LinkedList<>();
        this.traps = new LinkedList<>();
        this.gameOver = false;
    }

    public void loadLevel()
    {

    }

    public void betweenGameTicks()
    {
        if(player.isDead())
            this.gameOver = true;
        else
        {
            for (Monster m : this.monsters)
            {
                if (m.isDead()) {
                    this.board.addTile(m.getP(), new Empty(m.getP().getX(), m.getP().getY()));
                    this.monsters.remove(m);
                }
            }
            for (Trap t : this.traps)
            {
                if (t.isDead()) {
                    this.board.addTile(t.getP(), new Empty(t.getP().getX(), t.getP().getY()));
                    this.traps.remove(t);
                }
            }
        }
    }
}
