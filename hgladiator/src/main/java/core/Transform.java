package core;

public class Transform {
    public Position position;
    public double rotation;
    public double scale;
    public Transform()
    {
        this.position = new Position();
        this.rotation = 0;
        this.scale = 1.0;

    }
    public Transform Combine(Transform Rhs)
    {
        this.position.Add(Rhs.position);
        this.rotation += Rhs.rotation;
        this.rotation %= 2 * Math.PI;
        this.scale *= Rhs.scale;
        return this;
    };

}
