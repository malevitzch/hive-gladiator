package application;

import java.awt.Canvas;
import java.awt.Frame;
import java.util.Stack;

import game.Game;

public class GameDisplay {
	private Game game;
	private Frame gameFrame;
	private Canvas canvas;
	private Stack<Canvas> layers;
	
	public GameDisplay(Game game) {
		this.game = game;
		
		// Create the window
		gameFrame = new Frame("GameWindow");
		gameFrame.setSize(1000, 1000);
		gameFrame.setVisible(true);
        gameFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent we) {
                System.exit(0);
            }
        });

		layers = new Stack<Canvas>();

        // Create the canvas
        canvas = new GameCanvas(game.getState());
		layers.push(canvas);
        gameFrame.add(canvas);
	}
	
	private void render() {
		for(Canvas i : layers)
		{
			i.repaint();
		}
	}
	
	public void run() {
		while(!game.isOver()) {
			// Display the game

			render();
			
			// Sleep so that the game is not over in an instant when the player is automatic
			// TODO: This should be configurable through DisplayConfig or something like that
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException error) {
				error.printStackTrace();
			}
			System.out.println("Turn");
			game.nextTurn();
		}
		gameFrame.setVisible(false);
	}
}
