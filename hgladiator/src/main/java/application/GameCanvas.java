package application;

import java.awt.*;
import game.GameState;

public class GameCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	private GameState state;
	
	public GameCanvas(GameState state) {
		this.state = state;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(Color.RED);
		
        g.drawString("Score: " + state.getScore(), 50, 50);
        g.drawString("Player Health: " + state.getPlayerHealth(), 50, 80);
	}
}
