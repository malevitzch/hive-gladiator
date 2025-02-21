package graphics;

import java.util.Vector;

public class BufferLayout {
    public BufferLayout(){
        stride = 0;
        elements = new Vector<BufferLayoutElement>();
    }

    public void add(ShaderDataType pType){

        BufferLayoutElement newElement = new BufferLayoutElement();
        newElement.type = pType;
        newElement.offset = stride;
        stride += pType.size;

        elements.add(newElement);

    }

    public int getStride(){
        return stride;
    }

    public Vector<BufferLayoutElement> getElements(){
        return elements;
    }

    static public class BufferLayoutElement{

        public int offset;
        public ShaderDataType type;
    }

    private final Vector<BufferLayoutElement> elements;
    private int stride;
}
