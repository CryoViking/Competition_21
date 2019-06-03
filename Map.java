public class Map
{
    public static final char FLOOR = '.';
    public static final char WALL = '#';
    public static final char START = 'S';
    public static final char FINISH = 'F';

    private char [][] map;
    private int pos_x;
    private int pos_y;
    private int fin_x;
    private int fin_y;

    public Map(int x, int y)
    {
        map = new char[x][y];
        for(int ii = 0; ii<map.length;ii++)
        {
            for(int jj = 0;jj<map[0].length;jj++)
            {
                map[ii][jj] = ' ';
            }//END FOR
        }//END FOR
    }//END DEFAULT CONSTRUCTOR

    public void addNextTile(char tile)
    {
        for(int ii = 0; ii<map.length;ii++)
        {
            for(int jj = 0;jj<map[0].length;jj++)
            {
                if(map[ii][jj] == ' ')
                {
                    map[ii][jj] = tile;
                    if(tile == START)
                        setStart(ii, jj);
                    if(tile == FINISH)
                        setFinish(ii, jj);
                    return;
                }//ENDIF
            }//END FOR
        }//END FOR
        return;
    }//END addNextTile

    //x = 1 OR x = 0 OR x = -1 || y = 1 OR y = 0 OR y = -1
    public void move(int x, int y)
    {
        switch(x)
        {
            case -1:
                if(validXMove(this.pos_x - 1))
                    this.pos_x--;
                break;
            case 0:
                break;
            case 1:
                if(validXMove(this.pos_x + 1))
                    this.pos_x++;
                break;
        }//END SWITCH
        switch(y)
        {
            case -1:
                if(validYMove(this.pos_y - 1))
                    this.pos_y--;
                break;
            case 0:
                break;
            case 1:
                if(validYMove(this.pos_y + 1))
                    this.pos_y++;
                break;
        }//END SWITCH
        System.out.println(pos_x + " " +pos_y);
    }//END move

    public boolean isEnd()
    {
        if(this.pos_x == this.fin_x && this.pos_y == this.fin_y)
        {
            return true;
        }//ENDIF
        return false;
    }

    private void setStart(int x, int y)
    {
        this.pos_x = x;
        this.pos_y = y;
        System.out.println(pos_x + " " +pos_y);
    }//END setStart

    private void setFinish(int x, int y)
    {
        this.fin_x = x;
        this.fin_y = y;
    }//END setFinish

    private boolean validXMove(int x)
    {
        if(map[x][pos_y] != WALL)
            return true;
        return false;
    }//END validXMove

    private boolean validYMove(int y)
    {
        if(map[pos_x][y] != WALL)
            return true;
        return false;
    }//END validYMove
}//END class Map