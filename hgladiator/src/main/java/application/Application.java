package application;
import core.Window;
import core.Dependencies;
import core.event.Event;
import core.event.EventBus;
import core.event.Events;
import core.event.KeyCode;
import core.input.Input;
import graphics.*;
import graphics.samples.HexTile;
import org.joml.*;

import java.lang.Math;

public class Application implements EventBus.EventCallback {
    public void init(){
        Dependencies.init();
        EventBus.Init();
        mainWindow = new Window(new Window.WindowContext(1080,720,"hgladiator"));
        Input.init(mainWindow.getNative());
        EventBus.subscribe(this);
        try{
            testShader = new Shader("./shaders/default.vert","./shaders/default.pixel");
        } catch (java.io.IOException e){
            System.out.println("Shader wybuchl! Boom!");
        }

        testTile = new HexTile();
        targetColor = new Vector4f(0.0f,0.0f,0.0f,1.0f);
        accumulatedTime = 0.0f;
        mainWindow.setPolygonMode(PolygonMode.Fill);
        renderMode = true;

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
        if(pEvent.type == Event.Type.KeyPressed){
            if(((Events.KeyPressedEvent)pEvent).code == KeyCode.Space){
                renderMode = !renderMode;
                if(renderMode)mainWindow.setPolygonMode(PolygonMode.Fill);
                else mainWindow.setPolygonMode(PolygonMode.Wireframe);
            }
        }
        if(pEvent.type == Event.Type.WindowClosed) mainWindow.close();
    }
    private void update(double deltaTime){
        accumulatedTime += 2 * Math.PI * 0.1 * deltaTime;
        targetColor.x = Math.abs((float)Math.sin(accumulatedTime)) * 0.9f;
        targetColor.y = Math.abs((float)Math.sin(accumulatedTime));
        mainWindow.update();
    }

    private void render(){
        Vector4f pcol = new Vector4f(0.0f,0.7f,0.9f,1.0f);
        mainWindow.clear(new Color(0.2f, 0.3f, 0.3f, 1.0f));
        mainWindow.Bind(testShader);
        testShader.setUniform("passedColor",targetColor);
        mainWindow.draw(testTile);
        mainWindow.render();
    }

    public void shutdown(){
        EventBus.shutdown();
        Input.shutdown();
        Dependencies.shutdown();
    }

    private Window mainWindow;
    private double deltaTime = 0.0;
    private Shader testShader;
    private Vector4f targetColor;
    private float accumulatedTime;
    private HexTile testTile;
    private boolean renderMode;

}
