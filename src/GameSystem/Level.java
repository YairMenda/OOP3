package GameSystem;

import Tiles.Empty;
import Tiles.Position;
import Tiles.Tile;
<<<<<<< HEAD
import Tiles.Units.Enemy;
import Tiles.Units.Monster;
import Tiles.Units.Players.Player;
import Tiles.Units.Trap;
import Tiles.Units.Unit;
=======
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Players.Player;
import Tiles.Units.Enemies.Trap;
>>>>>>> main

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
    public Level(int playerChosen)
    {
        this.board = new Board();
        this.player = factory.getPlayer(playerChosen);
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
                    char currentTileSymbol = Line.charAt(i);
                    this.board.increaseX();
                    if (currentTileSymbol == '@') {
                        this.player.setP(new Position(this.board.getBoardCurrentX(), this.board.getBoardCurrentY()));
                    }
                    else {
                    Tile temp = factory.getTile(currentTileSymbol,this.board.getBoardCurrentX(),this.board.getBoardCurrentY());
                    this.board.addTile(temp);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesnt exist");
        }
    }

    public void gameTick(String action)
    {
        if (action == "e") {
            List<Enemy> castAbilityOn = new LinkedList<Enemy>();
            castAbilityOn.addAll(monsters);
            castAbilityOn.addAll(traps);
            this.player.activateAbility(castAbilityOn);
        }
        else
            unitMove(this.player,action);

        betweenGameTicks();

        for (Monster m : monsters)
        {
            // 0 - left , 1 - UP ....
            unitMove(m,m.chooseDirection(this.player));
            betweenGameTicks();
        }

        for (Trap t : traps) {
            t.gameTick(this.player);
            betweenGameTicks();
        }

    }

    public void unitMove(Unit u, String action)
    {
        if (action == "w" & u.getP().getY() != 0) {
            u.move(this.board.getTileInPosition(new Position(u.getP().getX(),u.getP().getY() - 1 )));
        }
        if (action == "s" & u.getP().getY() != this.board.getBoardCurrentY()) {
            u.move(this.board.getTileInPosition(new Position(u.getP().getX(),u.getP().getY() + 1 )));
        }
        if (action == "a" & u.getP().getX() != 0)
            u.move(this.board.getTileInPosition(new Position(u.getP().getX() - 1 ,u.getP().getY() )));

        if (action == "d" & u.getP().getX() != this.board.getBoardCurrentX())
            u.move(this.board.getTileInPosition(new Position(u.getP().getX() + 1,u.getP().getY())));
    }
    public boolean gameOver()
    {
        return player.isDead();
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
                this.board.addTile(new Empty(m.getP().getX(), m.getP().getY()));
                this.monsters.remove(m);
            }
        }
        for (Trap t : this.traps)
        {
            if (t.isDead()) {
                this.board.addTile(new Empty(t.getP().getX(), t.getP().getY()));
                this.traps.remove(t);
            }
        }

    }
}
