package graphics;

import static org.lwjgl.opengl.GL11.*;

public enum PolygonMode {

    Fill(GL_FILL),
    Wireframe(GL_LINE);

    PolygonMode(int pMode){
        glCode = pMode;
    }
    public final int glCode;
}
