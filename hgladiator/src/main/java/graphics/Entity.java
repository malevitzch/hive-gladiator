package graphics;

import core.Position;
import core.Transform;

abstract public class Entity implements Drawable{

    public Entity()
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
}
