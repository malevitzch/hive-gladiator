package core;

import org.lwjgl.glfw.*;
import static org.lwjgl.glfw.GLFW.*;

public class Dependencies {
    static private boolean initialized;
    
    Dependencies() {
        initialized = false;
    }

    public static void init(){
    	
        if(initialized) return;
        GLFWErrorCallback.createPrint(System.err).set();
        if ( !glfwInit() ) {
            glfwSetErrorCallback(null).free();
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        initialized = true;
        System.out.println("Dependencies initialized.");

    }

    public static void shutdown(){
        if(initialized) {
            glfwTerminate();
            glfwSetErrorCallback(null).free();
            System.out.println("Dependencies freed.");
            initialized = false;
        }
    }
}
