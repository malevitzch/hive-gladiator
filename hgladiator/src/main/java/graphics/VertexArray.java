package graphics;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class VertexArray implements Bindable{
    public VertexArray(){
        glId = glGenVertexArrays();
    }

    public void Bind(long context){
        glBindVertexArray(glId);
    }
    public void AddIndexBuffer(IndexBuffer pIndexBuffer){
        glBindVertexArray(glId);
        pIndexBuffer.Bind(0);
        indexBuffer = pIndexBuffer;

    }

    public int getIndexBufferCount(){
        return indexBuffer.getCount();
    }

    public void AddVertexBuffer(VertexBuffer pBuffer){
        glBindVertexArray(glId);
        pBuffer.Bind(0);
        BufferLayout layout = pBuffer.getLayout();

        int attribIdx = 0;
        for(BufferLayout.BufferLayoutElement i : layout.getElements())
        {
            glEnableVertexAttribArray(attribIdx);
            glVertexAttribPointer(attribIdx,i.type.elementCount,i.type.glType,false,layout.getStride(),i.offset);
            attribIdx++;
        }
    }

    public void Unbind(long context){
        glBindVertexArray(0);
    }

    private IndexBuffer indexBuffer;
    private int glId;
}
