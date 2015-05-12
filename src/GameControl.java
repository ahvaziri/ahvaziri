import java.util.ArrayList;

/**
 * Created by E540 on 5/10/2015.
 */
public class GameControl
{
    Map map;
    GameControl(int[][] wall, int[][] type,  int[] players)
    {
        map = new Map(wall, type, players);
    }


    public void move(Player p, int direction) throws Exception
    {
        try
        {
            p.move(direction);
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }

    public void attack(Player p, int direction) throws Exception
    {
        try
        {
            map.attack(p, direction);
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }

    public GameObjectID throwFan(Player player) throws Exception
    {
        try
        {
            return player.dropfan().getId();
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }

    public void getGift(Player player) throws Exception
    {
        try
        {
            player.pick();
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }


    public int getMapWallType(int col, int row)
    {
        return map.getSections()[col][row].getWall();
    }

    public int getMapWallType(int col, int row ,Player player)
    {
        int cnt;
        Section sec = map.getSections()[col][row];
        for(cnt = 0; cnt < player.getMeydandid().size(); cnt++)
            if (player.getMeydandid().get(cnt).equals(sec))
                return getMapWallType(col, row);
        return 16;
    }

    public int getMapCellType(int col, int row)
    {
        return map.getSections()[col][row].getType();
    }

    public int getMapCellType(int col, int row, Player player)
    {
        int cnt;
        Section sec = map.getSections()[col][row];
        for(cnt = 0; cnt < player.getMeydandid().size(); cnt++)
            if (player.getMeydandid().get(cnt).equals(sec))
            {
                if(sec.getType() > 3 && sec.getType() < 10)
                    return 10;
                else
                    return sec.getType();
            }
        return 2;
    }

    public ArrayList<String> getVision(Player player) throws Exception
    {
        int cnt;
        try
        {
            map.Meydandid(player);
            ArrayList<String> temp = new ArrayList<String>();
            for (cnt = 0; cnt < player.getMeydandid().size(); cnt++)
                temp.add(player.getMeydandid().get(cnt).getX() + "," + player.getMeydandid().get(cnt).getY());
            return temp;
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }

    public ArrayList<GameObjectID> getPlayersInVision(Player player)
    {
        int cnt1, cnt2;
        ArrayList<GameObjectID> ids = new ArrayList<GameObjectID>();
        try
        {
            map.Meydandid(player);
            for(cnt1 = 0; cnt1 < player.getMeydandid().size(); cnt1++)
                for(cnt2 = 0; cnt2 < player.getMeydandid().get(cnt1).getPlayers().size(); cnt2++)
                    ids.add(player.getMeydandid().get(cnt1).getPlayers().get(cnt2).getId());
            return ids;
        }
        catch (Exception e)
        {
            return null;
        }

    }

    public ArrayList<GameObjectID> getFans(Player player) throws Exception
    {
        int counter;
        try
        {
            ArrayList<GameObjectID> temp = new ArrayList<GameObjectID>();
            for(counter = 0; counter < player.getFans().size(); counter++)
                temp.add(player.getFans().get(counter).getId());
            return temp;
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }



}
