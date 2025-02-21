package graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.GL_BOOL;

public enum ShaderDataType {

    Float(GL_FLOAT,4,1),
    Float2(GL_FLOAT,8,2),
    Float3(GL_FLOAT,12,3),
    Float4(GL_FLOAT,16,4),
    Mat3(GL_FLOAT,36,3),
    Mat4(GL_FLOAT,64,4),
    Int(GL_INT,4,1),
    Int2(GL_INT,8,2),
    Int3(GL_INT,12,3),
    Int4(GL_INT,16,4),
    Bool(GL_BOOL,1,1);


    ShaderDataType(int pValue,int pSize,int pElementCount){
        glType = pValue;
        size = pSize;
        elementCount = pElementCount;
    }

    public final int glType;
    public final int size;
    public final int elementCount;
}
