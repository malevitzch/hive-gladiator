package application;

import java.awt.*;

import core.Position;
import core.Rotation;
import core.Transform;
import game.GameState;
import graphics.HexTile;
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
		HexTile test = new HexTile(25.0);
		Transform skibidi = new Transform();
		skibidi.scale = 1.0;
		skibidi.position = new Position(200,200);

		for(int i = 0; i < 10; i++)
		{
			skibidi.position = new Position(100 + i * 50,200);
			skibidi.rotation = Rotation.Radians(i * 15);
			test.draw(g,skibidi);
		}


        g.drawString("Score: " + state.getScore(), 50, 50);
        g.drawString("Player Health: " + state.getPlayerHealth(), 50, 80);
	}
}
