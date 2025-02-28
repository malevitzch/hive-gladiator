package game.entities;
import game.Tile;

import hex.HexCoord;

public interface Entity {
	
	public void die();
	public int getActionPriority();
	public void act();
	public int getId();
	public int getHealth();
	public boolean isDead();
	public Tile getTile();
	public void setTile(Tile tile);
	public default HexCoord getCoords() {
		return getTile().getHex().getCoords();
	}
}
