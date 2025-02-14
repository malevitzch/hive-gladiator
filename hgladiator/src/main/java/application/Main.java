
package application;
import graphics.Color;
import core.Window;
import core.Dependencies;

public class Main {

	public static void main(String[] args) {
		core.Dependencies.init();
		Window testWindow = new Window(new Window.WindowContext(1000,720,"hgladiator"));
		Color clearColor = new Color(0.1f,0.5f,0.0f,0.0f);
		while(testWindow.isOpen())
		{
			testWindow.update();
			testWindow.clear(clearColor);
			testWindow.render();
		}

		core.Dependencies.shutdown();
	}

};

