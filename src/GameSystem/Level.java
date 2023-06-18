package GameSystem;
import Tiles.Empty;
import Tiles.Position;
import Tiles.Tile;
import Tiles.Units.Enemies.Enemy;
import Tiles.Units.Players.Player;
import Tiles.Units.Unit;
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Players.Player;
import Tiles.Units.Enemies.Trap;
import Tiles.Wall;

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

    public Level() {
        this.monsters = new LinkedList<>();
        this.traps = new LinkedList<>();
    }

    public void setBoard(int x, int y)
    {
        this.board = new Board(x,y);
    }
    public void choosePlayer(int playerChosen)
    {
        this.player = factory.getPlayer(playerChosen);
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

        int sizex = 0;
        int sizey = 0;
        boolean stopx = false;
        String line = null;
        File file = new File(filePath);

        try(Scanner scannerPre = new Scanner(file)) {
            while (scannerPre.hasNextLine()) {
                line = scannerPre.nextLine();
                sizey++;

                for (int i = 0; i < line.length() && !stopx ; i++) {
                    sizex++;
                }
                stopx = true;
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("File doesnt exist");
        }

        setBoard(sizex,sizey);

        try (Scanner scanner = new Scanner(file)) {
            String Line = null;
            while (scanner.hasNextLine()) {
                Line = scanner.nextLine();
                for (int i = 0; i < Line.length(); i++) {
                    char currentTileSymbol = Line.charAt(i);
                    if (currentTileSymbol == '@') {
                        this.player.setP(new Position(i, this.board.getBoardCurrentY()));
                        this.board.addTile(this.player);
                    }

                    else {
                        Tile temp = factory.getTile(currentTileSymbol,i,this.board.getBoardCurrentY());
                        this.board.addTile(temp);
                        addEnemy(temp,currentTileSymbol);
                    }
                }
                this.board.increaseHeight();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesnt exist");
        }
    }

    public void addEnemy(Tile t, char c)
    {
        if (c != '#' && c != '.')
            if (c == 'B' | c == 'Q' | c =='D')
                traps.add((Trap) t);
            else
                monsters.add((Monster)t);
    }
    public void gameTick(String action)
    {
        Position prev = player.getP();
        if (action.equals("e")) {
            List<Enemy> castAbilityOn = new LinkedList<Enemy>();
            castAbilityOn.addAll(monsters);
            castAbilityOn.addAll(traps);
            this.player.activateAbility(castAbilityOn);
        }
        else
            unitMove(this.player,action);

        this.board.swapPosition(this.player.getP(),prev);
        betweenGameTicks();

        for (Monster m : monsters)
        {
            prev = m.getP();
            // 0 - left , 1 - UP ....
            unitMove(m,m.chooseDirection(this.player));
            this.board.swapPosition(m.getP(),prev);
            betweenGameTicks();
        }

        for (Trap t : traps) {
            t.gameTick(this.player);
            betweenGameTicks();
        }

    }

    public void unitMove(Unit u, String action)
    {
        if (action.equals("w") & u.getP().getY() != 0) {
            u.move(this.board.getTileInPosition(new Position(u.getP().getX(),u.getP().getY() - 1 )));
        }
        if (action.equals("s") & u.getP().getY() != this.board.getBoardCurrentY()) {
            u.move(this.board.getTileInPosition(new Position(u.getP().getX(),u.getP().getY() + 1 )));
        }
        if (action.equals("a") & u.getP().getX() != 0)
            u.move(this.board.getTileInPosition(new Position(u.getP().getX() - 1 ,u.getP().getY() )));

        if (action.equals("d") & u.getP().getX() != this.board.getBoard()[0].length)
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


    public void levelInfo()
    {
        this.player.info();
        System.out.println();
        System.out.println(this.board.toString());
    }
    public String showPlayers()
    {
        String s = "";
        int index = 0;
        for (Player p : factory.listPlayers()) {
            s += index + p.description() + "\n";
            index++;
        }

        return s;
    }
}
