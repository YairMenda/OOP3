package GameSystem;

import Tiles.Empty;
import Tiles.Tile;
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Players.Player;
import Tiles.Units.Enemies.Trap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Level {
    private Board board;
    private List<Monster> monsters;
    private List<Trap> traps;
    private Player player;

    private TileFactory factory = new TileFactory();
    public Level(Player p)
    {
        this.board = new Board();
        this.player = p;
        this.monsters = new LinkedList<>();
        this.traps = new LinkedList<>();
    }

    public boolean hasLevel(String filePath) {

        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
    }
    public void loadLevel(String filePath) {

        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            String Line = null;
            while (scanner.hasNextLine()) {
                this.board.increaseHeight();
                Line = scanner.nextLine();
                this.board.xToZero();

                for (int i = 0; i < Line.length(); i++) {
                    char currentTile = Line.charAt(i);
                    this.board.increaseX();
                    Tile temp = factory.getTile(currentTile,this.board.getBoardCurrentX(),this.board.getBoardCurrentY());
                    //checks the char and intitalize the relevant tile
                    //position = (board.currentX,boardCurrentY)
                    //board.Add(tile(c,position))
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesnt exist");
        }
    }

    public void gameTick()
    {

    }
    public boolean isOver()
    {
        return monsters.size() == 0;
    }
    public void betweenGameTicks()
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
