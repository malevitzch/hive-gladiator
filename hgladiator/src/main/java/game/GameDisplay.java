package game;

import java.awt.*;

public class GameDisplay {
	private Game game;
	public GameDisplay(Game game) {
		this.game = game;
	}
	public void run() {
		Frame frame = new Frame("GameWindow");
		
		// Create the window
		frame.setSize(1000, 1000);
		frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent we) {
                System.exit(0);
            }
        });
		
		while(!game.isOver()) {
			// Display the game here
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException error) {
				error.printStackTrace();
			}
			System.out.println("Turn");
			game.nextTurn();
		}
		frame.setVisible(false);
	}
}
