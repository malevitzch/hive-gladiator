package game.entities;
import game.GameState;
import game.Tile;


public interface Entity {
	public void die();
	public int getActionPriority();
	public void act(GameState state);
	public int getId();
	public Tile getTile();
	public void setTile(Tile tile);
}
