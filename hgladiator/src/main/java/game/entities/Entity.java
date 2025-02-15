package game.entities;
import game.GameState;

public interface Entity {
	public void die();
	public int getActionPriority();
	public void act(GameState state);
}
