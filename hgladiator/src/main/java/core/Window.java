package core;
import core.event.Events;
import core.event.EventBus;
import core.event.KeyCode;
import graphics.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLUtil;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.system.MemoryUtil.*;

public class Window {

    public static class WindowContext{
        public int width;
        public int height;
        public String name;
        public boolean vsync;

        public WindowContext(){
            width = 420;
            height = 420;
            name = "Ciastko bylo klamstwem";
            vsync = false;
        }

        public WindowContext(int pWidth, int pHeight, String pName){
            this();
            width = pWidth;
            height = pHeight;
            name = pName;
        }
    }

    public Window (WindowContext pContext) {
        context = pContext;
        init();
    }

    public void Bind(Bindable pBindable){
        pBindable.Bind(glfwWindow);
    }

    public void close(){
        open = false;
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);
    }

    public void clear(Color pColor){
        glClearColor(pColor.r, pColor.g, pColor.b, pColor.a);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void render(){
        glfwSwapBuffers(glfwWindow);
    }

    public void update(){
        glfwPollEvents();
    }

    public boolean isOpen(){
        return open;
    }

    private void init() {
        Dependencies.init();

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GLFW_TRUE);

        glfwWindow = glfwCreateWindow(context.width, context.height,context.name,NULL,NULL);
        if(glfwWindow == NULL){
            throw new RuntimeException("Failed to create the GLFW window");
        }
        SetCallbacks();
        glfwMakeContextCurrent(glfwWindow);
        if(context.vsync){
            glfwSwapInterval(1);
        }

        glfwShowWindow(glfwWindow);
        GL.createCapabilities();
        GLUtil.setupDebugMessageCallback();
        glViewport(0, 0,context.width, context.height);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        glEnable(GL_DEPTH_TEST);
        glEnable(GL_LINE_SMOOTH);

        open = true;

    }

    private void SetCallbacks(){

        glfwSetKeyCallback(glfwWindow, (window, key, scancode, action, mods) -> {

            if (action == GLFW_RELEASE ) {
                EventBus.broadcast(new Events.KeyReleasedEvent(KeyCode.FromInt(key)));
            }

            if(action == GLFW_PRESS) {
                EventBus.broadcast(new Events.KeyPressedEvent(KeyCode.FromInt(key)));
            }
        });

        glfwSetMouseButtonCallback(glfwWindow,(window,button,action,mods) -> {
            if(action == GLFW_PRESS){
                EventBus.broadcast(new Events.MouseButtonPressedEvent(KeyCode.FromInt(button)));
            }

            if(action == GLFW_RELEASE){
                EventBus.broadcast(new Events.MouseButtonReleasedEvent(KeyCode.FromInt(button)));
            }
        });

        glfwSetWindowCloseCallback(glfwWindow,(window) ->{
            EventBus.broadcast(new Events.WindowClosedEvent());
        });

        glfwSetFramebufferSizeCallback(glfwWindow,(long window, int width,int height) ->{

            context.width = width;
            context.height = height;
            glViewport(0, 0,context.width, context.height);
        });
    }
    public long getNative(){return glfwWindow;}

    public void setPolygonMode(PolygonMode pMode){
        glPolygonMode(GL_FRONT_AND_BACK,pMode.glCode);
    }

    public void draw(Drawable pDrawable){
        pDrawable.draw(this,new Transform());
    }
    private final WindowContext context;
    private long glfwWindow;
    private boolean open;

}
