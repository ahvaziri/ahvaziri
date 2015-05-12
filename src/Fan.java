/**
 * Created by E540 on 5/7/2015.
 */
public class Fan
{
    private Player owner;
    private Section sec;
    private int row;
    private int col;
    private boolean IS_ALIVE = true;
    private GameObjectID id;

    Fan(Section sec, Player owner)
    {
        this.owner = owner;
        this.sec = sec;
        this.row = sec.getX();
        this.col = sec.getY();
    }

    public void setIS_ALIVE(boolean IS_ALIVE) {
        this.IS_ALIVE = IS_ALIVE;
    }

    public void setId(GameObjectID id) {
        this.id = id;
    }


    public Section getSec() {
        return sec;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isIS_ALIVE() {
        return IS_ALIVE;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public GameObjectID getId() {
        return id;
    }

}
