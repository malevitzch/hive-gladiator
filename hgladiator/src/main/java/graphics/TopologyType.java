package graphics;

import static org.lwjgl.opengl.GL11.*;

public enum TopologyType {
    Triangles(GL_TRIANGLES),
    TriangleFan(GL_TRIANGLE_FAN),
    Lines(GL_LINES),
    Points(GL_POINTS);

    TopologyType(int pCode){
        glCode = pCode;
    }
    public final int glCode;
}
