package application;
import core.Window;
import core.Dependencies;
import core.event.Event;
import core.event.EventBus;
import graphics.Color;

public class Application implements EventBus.EventCallback {
    private void Init(){
        Dependencies.init();
        EventBus.Init();
        mainWindow = new Window(new Window.WindowContext(1080,720,"hgladiator"));
        EventBus.Subscribe(this);
    }

    private void Run(){
        while(mainWindow.isOpen()) {
            double beginTime = System.currentTimeMillis();
            EventBus.Update();
            Update(deltaTime);
            Render();

            deltaTime = (System.currentTimeMillis() - beginTime) * 0.001;
        }
    }
    public void OnEvent(Event pEvent){
        System.out.println(pEvent.ToString());

        if(pEvent.type == Event.Type.WindowClosed) mainWindow.close();
    }
    private  void Update(double deltaTime){
        mainWindow.update();
    }

    private void Render(){
        mainWindow.clear(new Color(0.0f,0.4f,0.6f,0.0f));
        mainWindow.render();
    }

    private void Shutdown(){
        EventBus.Shutdown();
        Dependencies.shutdown();
    }
    public static void main(String[] args)
    {
       Application App = new Application();
       App.Init();
       App.Run();
       App.Shutdown();
    }

    private  Window mainWindow;
    private  double deltaTime = 0.0;
}
