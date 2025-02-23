package game;

import game.entities.Entity;
import hex.Hex;

public class Tile {
	//TODO: expand this
	// Transformable, Terrain, Effects?
	private Entity entity;
	private Hex<Tile> hex;
	
	public Tile(Hex<Tile> hex) {
		this.hex = hex;
	}
	
	public Tile() {
		
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public Boolean empty() {
		return entity == null;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public void setHex(Hex<Tile> hex) {
		this.hex = hex;
	}

	public Hex<Tile> getHex() {
		return hex;
	}
}
