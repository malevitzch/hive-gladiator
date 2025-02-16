package application;
import core.Window;
import core.Dependencies;
import core.event.Event;
import core.event.EventBus;
import graphics.Color;

public class Application implements EventBus.EventCallback {
    private void init(){
        Dependencies.init();
        EventBus.Init();
        mainWindow = new Window(new Window.WindowContext(1080,720,"hgladiator"));
        EventBus.subscribe(this);
    }

    private void run(){
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
    }

    private void render(){
        mainWindow.clear(new Color(0.0f,0.4f,0.6f,0.0f));
        mainWindow.render();
    }

    private void shutdown(){
        EventBus.shutdown();
        Dependencies.shutdown();
    }
    public static void main(String[] args)
    {
       Application App = new Application();
       App.init();
       App.run();
       App.shutdown();
    }

    private Window mainWindow;
    private double deltaTime = 0.0;
}
