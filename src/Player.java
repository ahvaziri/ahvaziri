import java.util.ArrayList;

/**
 * Created by E540 on 5/7/2015.
 */
public class Player
{
    private String name = new String();
    private int power;
    private int fannum;
    private int vision;
    private int speed;
    private boolean alive = true;
    private Section sec;
    private ArrayList<Fan> fans = new ArrayList<Fan>();
    private ArrayList<Section> meydandid = new ArrayList<Section>();
    private int speednum;
    private int radarnum;
    private int stonenum;
    private int jumpnum;
    private int win = 0;
    private GameObjectID id;
    private Map map;
    private Section Start;

    Player(String name, int power, int fans, int vision, int speed)
    {
        this.name = name;
        this.power = power;
        this.fannum = fans;
        this.vision = vision;
        this.speed = speed;
    }

    public int getJumpnum() {
        return jumpnum;
    }

    public int getRadarnum() {
        return radarnum;
    }

    public int getSpeednum() {
        return speednum;
    }

    public int getStonenum() {
        return stonenum;
    }

    public Section getSec() {
        return sec;
    }

    public int getFannum() {
        return fannum;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getVision() {
        return vision;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getWin()
    {
        return win;
    }

    public ArrayList<Fan> getFans() {
        return fans;
    }

    public ArrayList<Section> getMeydandid() {
        return meydandid;
    }

    public GameObjectID getId() {
        return id;
    }

    public Map getMap() {
        return map;
    }


    public void setsec(Section x)
    {
        sec = x;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public void setFannum(int fannum) {
        this.fannum = fannum;
    }

    public void setJumpnum(int jumpnum) {
        this.jumpnum = jumpnum;
    }

    public void setRadarnum(int radarnum) {
        this.radarnum = radarnum;
    }

    public void setSec(Section sec) {
        this.sec = sec;
    }

    public void setSpeednum(int speednum) {
        this.speednum = speednum;
    }

    public void setStonenum(int stonenum) {
        this.stonenum = stonenum;
    }

    public void setMeydandid(ArrayList<Section> meydandid)
    {
        int i, j;
        for( i = 0; i < fans.size(); i++)
            for(j = 0; j < meydandid.size(); j++)
            {
                if (fans.get(i).getSec().equals(meydandid.get(j)))
                    break;
                if (j == meydandid.size() - 1)
                    meydandid.add(fans.get(i).getSec());
            }
        meydandid.add(Start);
        this.meydandid = meydandid;
    }

    public void setId(GameObjectID id) {
        this.id = id;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setStart(Section start) {
        Start = start;
    }


    public boolean hit (ArrayList<Player> a, int num) throws Exception// true baraye marge taraf
    {
        if (stonenum == 0 || wallyab(sec.getWall()).charAt(num) == 'F')
        {
            int cnt;
            try
            {
                for (cnt = 0; cnt < a.size(); cnt++)
                {
                    Player temp = a.get(cnt);
                    temp.setPower(Math.max(0, temp.getPower() - this.power));
                    sec.removeplayer(this);
                    this.setSec(temp.getSec());
                    sec.addPlayer(this);
                    if (temp.getPower() == 0)
                    {
                        sec.removeplayer(temp);
                        temp.removeplayer();
                        return true;
                    }
                }
                return false;
            }
            catch (Exception e)
            {
                throw new Exception();
            }
        }
        else
            throw new Exception();
    }

    private String wallyab(int wall)
    {
        if(wall == 0)
            return "FFFF";
        else if(wall == 1)
            return "FFFT";
        else if (wall == 2)
            return "FFTF";
        else if(wall == 3)
            return "FFTT";
        else if(wall == 4)
            return "FTFF";
        else if(wall == 5)
            return "FTFT";
        else if(wall == 6)
            return "FTTF";
        else if(wall == 7)
            return "FTTT";
        else if(wall == 8)
            return "TFFF";
        else if(wall == 9)
            return "TFFT";
        else if(wall == 10)
            return "TFTF";
        else if(wall == 11)
            return "TFTT";
        else if(wall == 12)
            return "TTFF";
        else if(wall == 13)
            return "TTFT";
        else if(wall == 14)
            return "TTTF";
        else if(wall == 15)
            return "TTTT";
        else
            return null;
    }

    public Fan dropfan() throws Exception
    {
        if (stonenum == 0)
        {
            if (fannum > 0)
            {
                Fan temp = new Fan(sec, this);
                fans.add(temp);
                fannum--;
                return temp;
            }
            else
                throw new Exception();
        }
        else
            throw new Exception();
    }

    public boolean killfan(ArrayList<Fan> a, int dir) throws Exception
    {
        int counter;
        if (stonenum == 0)
        {
            try
            {
                for (counter = 0; counter < a.size(); counter++)
                {
                    Fan temp = a.get(counter);
                    temp.setIS_ALIVE(false);
                    temp.getOwner().getFans().remove(temp);
                    a.remove(counter);
                    return true;
                }
                throw new Exception();
            }
            catch (Exception e)
            {
                throw new Exception();
            }
        }
        else
            throw new Exception();
    }

    public void removeplayer()
    {
        alive = false;
        fans = null;
    }

    public void move(int num) throws Exception
    {
        if (wallyab(sec.getWall()).charAt(num) == 'F' || stonenum == 0)
        {
            try
            {
                sec.removeplayer(this);
                sec = map.movesec(sec.getX(), sec.getY(), num);
                sec.addPlayer(this);
            }
            catch (Exception e)
            {
                throw new Exception();
            }
        }
        else
            throw new Exception();
    }

    public void pick() throws Exception
    {
        if (stonenum == 0)
        {
            int temp = sec.getType();
            if (temp == 1)
                this.win = 1;
            else if (temp == 8)
                fannum += 3;
            else if (temp == 9)
                this.power = Math.min(this.power + 20, 100);
            else if (temp == 7)
                this.jumpnum += 40;
            else if (temp == 6)
                this.stonenum += 60;
            else if (temp == 5)
                this.radarnum += 60;
            else if (temp == 4)
                this.speednum += 100;
        }
        else
            throw new Exception();
    }

    public void kahesh()
    {
        if(speednum != 0)
            speednum --;
        if(stonenum != 0)
            stonenum--;
        if(radarnum != 0)
            radarnum--;
        if(jumpnum != 0)
            jumpnum--;
    }

}
