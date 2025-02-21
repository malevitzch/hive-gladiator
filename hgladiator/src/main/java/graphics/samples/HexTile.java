package graphics.samples;

import core.Transform;
import graphics.*;
import org.lwjgl.system.MemoryUtil;

import core.Window;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

public class HexTile extends Drawable {

    public HexTile(){

        super();
        renderSettings.type= TopologyType.TriangleFan;
        BufferLayout layout = new BufferLayout();
        layout.add(ShaderDataType.Float3);

        vbo = new VertexBuffer(layout);

        float[] vd= {
                0.0f,    0.0f, 0.0f,     //center
                -0.25f,   0.5f, 0.0f,     // left top
                0.25f,    0.5f, 0.0f,    // right top
                0.5f,    0.0f, 0.0f,    // right
                0.25f,   -0.5f, 0.0f,    // right bottom (notice sign)
                -0.25f,  -0.5f, 0.0f,     // left bottom
                -0.5f,   0.0f, 0.0f,
        };

        int[] ia = {
                0,1,2,3,4,5,6,1

        };
        IntBuffer ib = MemoryUtil.memAllocInt(ia.length);
        ib.put(ia).flip();
        ibo = new IndexBuffer();
        ibo.SetData(ib);

        FloatBuffer fb = MemoryUtil.memAllocFloat(vd.length);
        fb.put(vd).flip();
        vbo.SetData(fb);

        vao = new VertexArray();
        vao.AddIndexBuffer(ibo);
        vao.AddVertexBuffer(vbo);
    }

    @Override
    public void draw(Window pTarget, Transform pTransform) {
        pTarget.Bind(vao);
        glDrawElements(renderSettings.type.glCode,vao.getIndexBufferCount(),GL_UNSIGNED_INT,0);
    }

    private VertexArray vao;
    private IndexBuffer ibo;
    private VertexBuffer vbo;
}
