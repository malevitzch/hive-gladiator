package game.entities;
import game.Tile;

public interface Entity {
	public void die();
	public int getActionPriority();
	public void act();
	public int getId();
	public Tile getTile();
	public void setTile(Tile tile);
}
