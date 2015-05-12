import java.util.ArrayList;

/**
 * Created by E540 on 5/7/2015.
 */
public class Map
{
    private Section[][] sections;
    private Player[] players;

    Map(int[][] wall, int[][] type,  int[] players)
    {
        int cnt1, cnt2;
        for(cnt1 = 0; cnt1 < wall.length; cnt1++)
            for(cnt2 = 0; cnt2 < wall.length; cnt2++)
            {
                sections[cnt1][cnt2] = new Section();
                sections[cnt1][cnt2].setWall(wall[cnt1][cnt2]);
                sections[cnt1][cnt2].setType(type[cnt1][cnt2]);
                sections[cnt1][cnt2].setX(cnt1);
                sections[cnt1][cnt2].setY(cnt2);
            }
        this.players[0] = new Player("SAMAN", 100, 2, 3, 5);
        this.players[1] = new Player("REZA", 0, 2, 6, 4);
        this.players[2] = new Player("HASIN", 10, 2, 3, 5);
        this.players[3] = new Player("JAFAR", 5, 5, 3, 1);
        this.players[0].setSec(sections[0][0]);
        this.players[0].setStart(sections[0][0]);
        sections[0][0].setType(3);
        this.players[1].setSec(sections[0][1]);
        this.players[1].setStart(sections[0][1]);
        sections[0][1].setType(3);
        this.players[2].setSec(sections[0][2]);
        this.players[2].setStart(sections[0][2]);
        sections[0][2].setType(3);
        this.players[3].setSec(sections[0][3]);
        this.players[3].setSec(sections[0][3]);
        sections[0][3].setType(3);
    }

    public Player[] getPlayers() {
        return players;
    }

    public Section[][] getSections() {
        return sections;
    }

    public int getwidth()
    {
        return sections.length;
    }

    public int getheight()
    {
        return sections.length;
    }

    public void Meydandid(Player player)
    {
        Section sectemp = player.getSec();
        int visiontemp = player.getVision(), cnt1, cnt2;
        ArrayList<Section> javab = new ArrayList<Section>();
        for(cnt1 = Math.max(sectemp.getX() - visiontemp , 0); cnt1 < Math.min(sectemp.getX() + visiontemp, getheight()) ; cnt1++)
            for(cnt2 = Math.max(sectemp.getY() - visiontemp, 0); cnt2 < Math.min(sectemp.getY() + visiontemp, getwidth()) ; cnt2++)
                javab.add(sections[cnt1][cnt2]);
        player.setMeydandid(javab);
    }

    public Section movesec(int x, int y, int dir) throws Exception
    {
        if(dir == 0)
            return sections[x][y - 1];
        else if(dir == 1)
            return sections[x + 1][y];
        else if(dir == 2)
            return sections[x][y + 1];
        else if(dir == 3)
            return sections[x - 1][y];
        else if(dir ==4)
            return sections[x][y];
        else
            throw new Exception();
    }

    public void attack (Player p, int dir) throws Exception
    {
        try
        {
            if(p.hit(movesec(p.getSec().getX(), p.getSec().getY(), dir).getPlayers(), dir))
                return;
            else if(p.killfan(movesec(p.getSec().getX(), p.getSec().getY(), dir).getFans(), dir))
                return;
            else
                throw new Exception();
        }
        catch (Exception e)
        {
           throw new Exception();
        }
    }


}
