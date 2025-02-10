package core;

public class Position {
    public int x;
    public int y;
    public Position()
    {
        this.x = 0;
        this.y = 0;
    }

    public Position(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public Position Add(Position Rhs)
    {
        this.x += Rhs.x;
        this.y += Rhs.y;
        return this;
    };
}
