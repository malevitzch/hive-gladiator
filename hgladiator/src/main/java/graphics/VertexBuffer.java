package graphics;
import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL45.*;

public class VertexBuffer implements Bindable{
    public VertexBuffer(BufferLayout pLayout){
        glId = glCreateBuffers();
        layout = pLayout;
    }

    public VertexBuffer(BufferLayout pLayout,FloatBuffer pData){
        this(pLayout);
        data = pData;
    }

    public void SetData(FloatBuffer pData){
        data = pData;
        glBindBuffer(GL_ARRAY_BUFFER,glId);
        glBufferData(GL_ARRAY_BUFFER,data,GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER,0);
    }

    public BufferLayout getLayout(){
        return layout;
    }
    public void Bind(long context){
        glBindBuffer(GL_ARRAY_BUFFER,glId);
    }

    public void Unbind(long context){
        glBindBuffer(GL_ARRAY_BUFFER,0);
    }

    private final int glId;
    private FloatBuffer data;
    private BufferLayout layout;
}
