package GameSystem;
import Tiles.Empty;
import Tiles.Position;
import Tiles.Tile;
import Tiles.Units.Bars.Bar;
import Tiles.Units.Enemies.Enemy;
import Tiles.Units.Players.Roles.Mage;
import Tiles.Units.Players.Player;
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Players.Roles.Rogue;
import Tiles.Units.Players.Roles.Warrior;
import Tiles.Units.Enemies.Trap;
import Tiles.Wall;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class TileFactory {
    private List<Supplier<Player>> playersList;
    private Map<Character, Supplier<Enemy>> enemiesMap;
    private Player selected;

    public TileFactory(){
        playersList = initPlayers();
        enemiesMap = initEnemies();
    }

    private Map<Character, Supplier<Enemy>> initEnemies() {
        List<Supplier<Enemy>> enemies = Arrays.asList(
                () -> new Monster(25, "Lannister Solider", 8, 3, new Bar(80),-1, -1,'s',3),
                () -> new Monster(50,"Lannister Knight",14,8,new Bar(200),-1 , -1 , 'k' , 4),
                () -> new Monster(100,"Queen's Guard",20,15,new Bar(400),-1 , -1 , 'q' , 5),
                () -> new Monster(100,"Wright",30,15,new Bar(600),-1 , -1 , 'z' , 3),
                () -> new Monster(250,"Bear-Wright",75,30,new Bar(1000),-1 , -1 , 'b' , 4),
                () -> new Monster(500,"Giant-Wright",100,40,new Bar(1500),-1 , -1 , 'g' , 5),
                () -> new Monster(1000,"White Walker",150,50,new Bar(2000),-1 , -1 , 'w' , 6),
                () -> new Monster(500,"The Mountain",60,25,new Bar(1000),-1 , -1 , 'M' , 6),
                () -> new Monster(1000,"Queen Cersei",10,10,new Bar(100),-1 , -1 , 'C' , 1),
                () -> new Monster(5000,"Night's King",300,150,new Bar(5000),-1 , -1 , 'K' , 8),
                () -> new Trap(250,"Bonus Trap",1,1,new Bar(1),-1,-1,'B',1,5),
                () -> new Trap(100,"Queen's trap",50,10,new Bar(250),-1,-1,'Q',3,7),
                () -> new Trap(250,"Death Trap",100,20,new Bar(500),-1,-1,'D',1,10)

        );

        return enemies.stream().collect(Collectors.toMap(s -> s.get().getSymbol(), Function.identity()));
    }

    private List<Supplier<Player>> initPlayers() {
        return Arrays.asList(
                () -> new Warrior("Jon Snow", 30, 4, 300, -1,-1,3),
                () -> new Warrior("The Hound", 20, 6, 400, -1,-1,5),
                () -> new Mage("Melisandre", 5, 1, 100, -1, -1, 300, 15,30,5, 6),
                () -> new Mage("Thoros of Myr", 25, 4, 250, -1, -1, 150, 20,20,3, 4),
                () -> new Rogue("Arya Stark", 40, 2, 150, -1,-1,20),
                () -> new Rogue("Bronn", 35, 3, 250, -1,-1,50)
                //() -> new Hunter("Ygritte", 220, 30, 2, 6)
        );
    }

    public Player getPlayer(int index)
    {
        return this.playersList.get(index);
    }
    public Enemy getEnemy(char c)
    {
        return this.enemiesMap.get(c);
    }

    public Tile getTile(char c,int x,int y)
    {
        if (c == '#')
            return new Wall(x,y);
        if (c == '.')
            return new Empty(x,y);

        Enemy e = getEnemy(c);
        e.setP(new Position(x,y));

        return getEnemy(c);
    }


    public List<Player> listPlayers(){
        return playersList.stream().map(Supplier::get).collect(Collectors.toList());
    }

    // TODO: Add additional callbacks of your choice

//    public Enemy produceEnemy(char tile, Position position, ...) {
//        ...
//    }
//
//    public Player producePlayer(int idx, ...){
//		...
//    }
//
//    public Empty produceEmpty(Position position, ...){
//        ...
//    }
//
//    public Wall produceWall(Position position, ...){
//        ...
//    }
}
