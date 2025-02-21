package graphics;

import core.Position;
import core.Transform;
import core.Window;

abstract public class Transformable extends Drawable{

    public Transformable()
    {
        m_Transform = new Transform();
    }

    public void SetPosition(Position pPos)
    {
        m_Transform.position = pPos;
    }

    public Transform GetTransform()
    {
        return this.m_Transform;
    }
    protected Transform m_Transform;

    public void draw(Window window, Transform pTransform) {
    }
}
