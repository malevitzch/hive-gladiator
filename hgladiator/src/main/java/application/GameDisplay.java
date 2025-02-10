package application;

import game.Game;
import java.awt.*;

public class GameDisplay {
	private Game game;
	private Frame gameFrame;
	Canvas canvas;
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
        
        // Create the canvas
        canvas = new GameCanvas(game.getState());
        gameFrame.add(canvas);
	}
	private void drawGame() {
		canvas.repaint();
	}
	public void run() {
		while(!game.isOver()) {
			// Display the game
			drawGame();
			
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
