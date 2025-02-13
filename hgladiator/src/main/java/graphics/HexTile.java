package graphics;

import core.Transform;

import java.awt.*;


public class HexTile extends Transformable {

    public HexTile(double Radius)
    {
        super();
        m_Radius = Radius;
        GenerateMesh(m_Transform);
    }
    public final void draw(Graphics pContext, Transform pTransform)
    {
        pTransform.Combine(m_Transform);
        GenerateMesh(pTransform);
        pContext.drawPolygon(m_Mesh);
    }

    private void GenerateMesh(Transform pTransform)
    {
        //TODO: Zeby rotacja działała dla odmiany
        m_Mesh = new Polygon();
        for (int i = 0; i < 6; i++) {
            double x = (double) (m_Radius * Math.cos(i * 2 * Math.PI / 6D));
            double y = (double) (m_Radius * Math.sin(i * 2 * Math.PI / 6D));
            double finalX = x * Math.cos(pTransform.rotation) - y * Math.sin(pTransform.rotation);
            double finalY = y * Math.cos(pTransform.rotation) + x * Math.sin(pTransform.rotation);
            finalX += pTransform.position.x;
            finalY += pTransform.position.y;

            m_Mesh.addPoint((int)(finalX * pTransform.scale), (int)(finalY * pTransform.scale));
        }
    }
    private Polygon m_Mesh;
    private final double m_Radius;
}
