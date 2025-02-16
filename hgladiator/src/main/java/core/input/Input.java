package core.input;

import core.Position;
import core.event.KeyCode;
import org.lwjgl.BufferUtils;

import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class Input {
    static public void init(long pContext){
        context = pContext;
    }
    static public void shutdown(){

    }

    static public boolean isKeyPressed(KeyCode pKey){
        if(glfwGetKey(context,pKey.Code()) == GLFW_PRESS) return true;
        return false;
    }

    static public boolean isMouseButtonPressed(KeyCode pKey)
    {
        if(glfwGetMouseButton(context,pKey.Code()) == GLFW_PRESS) return true;
        return false;
    }
    static public Position getMousePosition(){
        DoubleBuffer bufferX = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer bufferY = BufferUtils.createDoubleBuffer(1);

        glfwGetCursorPos(context,bufferX,bufferY);

        return new Position((int)bufferX.get(0),(int)bufferY.get(0));
    }

    private static long context;
}
