package application;
import core.Window;
import core.Dependencies;
import core.event.Event;
import core.event.EventBus;
import core.event.KeyCode;
import core.input.Input;
import graphics.*;
import org.joml.*;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class Application implements EventBus.EventCallback {
    public void init(){
        Dependencies.init();
        EventBus.Init();
        mainWindow = new Window(new Window.WindowContext(1080,720,"hgladiator"));
        Input.init(mainWindow.getNative());
        EventBus.subscribe(this);

        BufferLayout layout = new BufferLayout();
        layout.add(ShaderDataType.Float3);
        layout.add(ShaderDataType.Float3);
        vBuffer = new VertexBuffer(layout);

        float[] vd= {
                -0.5f, -0.5f, 0.0f, 0.1f, 0.2f, 0.3f,
                0.5f, -0.5f, 0.0f, 0.3f, 0.4f, 0.1f,
                0.0f,  0.5f, 0.0f, 0.7f, 0.1f, 0.2f,
                -0.7f,0.5f,0.0f, 0.9f, 0.1f, 0.9f,
        };

        int[] ia = {
                0,1,2,3,1,0
        };
        IntBuffer ib = MemoryUtil.memAllocInt(ia.length);
        ib.put(ia).flip();
        iBuffer = new IndexBuffer();
        iBuffer.SetData(ib);

        FloatBuffer fb = MemoryUtil.memAllocFloat(vd.length);
        fb.put(vd).flip();
        vBuffer.SetData(fb);
        try{
            testShader = new Shader("./shaders/default.vert","./shaders/default.pixel");
        } catch (java.io.IOException e){
            System.out.println("Shader wybuchl! Boom!");
        }
        vBuffer.Bind(0);

        vao = new VertexArray();
        vao.AddIndexBuffer(iBuffer);
        vao.AddVertexBuffer(vBuffer);
        System.out.println(vao.getIndexBufferCount());

    }

    public void run(){
        while(mainWindow.isOpen()) {
            double beginTime = System.currentTimeMillis();
            EventBus.update();
            update(deltaTime);
            render();

            deltaTime = (System.currentTimeMillis() - beginTime) * 0.001;
        }
    }
    public void onEvent(Event pEvent){
        System.out.println(pEvent.ToString());

        if(pEvent.type == Event.Type.WindowClosed) mainWindow.close();
    }
    private void update(double deltaTime){
        mainWindow.update();
        if(Input.isMouseButtonPressed(KeyCode.MouseButtonLeft)){
            System.out.println("LIVE: Pressed");
        }

        System.out.println(Input.getMousePosition().toString());
    }

    private void render(){
        mainWindow.clear(new Color(0.2f, 0.3f, 0.3f, 1.0f));
        mainWindow.Bind(testShader);
        mainWindow.Bind(vao);

        glDrawElements(GL_TRIANGLES, vao.getIndexBufferCount(), GL_UNSIGNED_INT,0);
        mainWindow.render();
    }

    public void shutdown(){
        EventBus.shutdown();
        Input.shutdown();
        Dependencies.shutdown();
    }

    private Window mainWindow;
    private double deltaTime = 0.0;
    private VertexBuffer vBuffer;
    private IndexBuffer iBuffer;
    private Shader testShader;
    private VertexArray vao;

}
