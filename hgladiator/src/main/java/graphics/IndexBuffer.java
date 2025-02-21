package graphics;

import java.nio.IntBuffer;
import java.util.Arrays;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL45.glCreateBuffers;

public class IndexBuffer implements Bindable{
    public IndexBuffer(){
        glId = glCreateBuffers();
    }

    public IndexBuffer(IntBuffer pData){
        this();
        data = pData;
    }

    public void SetData(IntBuffer pData){
        data = pData;
    }
    public int getCount(){
        return data.capacity();
    }
    public void Bind(long context){
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,glId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,data,GL_STATIC_DRAW);
    }

    public void Unbind(long context){
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,0);
    }

    private final int glId;
    private IntBuffer data;
}

