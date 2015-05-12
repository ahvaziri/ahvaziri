import java.util.ArrayList;

/**
 * Created by E540 on 5/7/2015.
 */
public class Section
{
    private int type;
    private int wall;
    private int x;
    private int y;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Fan> fans = new ArrayList<Fan>();

    public void setType(int type) {
        this.type = type;
    }

    public void setWall(int wall) {
        this.wall = wall;
    }

    public int getWall() {
        return wall;
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Fan> getFans() {
        return fans;
    }


    public void xunexali()
    {
        type = 0;
    }

    public void removeplayer(Player p)
    {
        players.remove(p);
    }

    public void removefan(Fan fan)
    {
        fans.remove(fan);
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addFans(Fan fans) {
        this.fans.add(fans);
    }

}
