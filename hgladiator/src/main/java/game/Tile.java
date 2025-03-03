package game;

import game.entities.Entity;
import hex.Hex;

public class Tile {
	//TODO: expand this
	// Transformable, Terrain, Effects?
	private Entity entity;
	private Hex hex;
	
	public Tile(Hex hex) {
		this.hex = hex;
		this.entity = null;
	}
	
	public Tile() {
		this.entity = null;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public boolean empty() {
		return entity == null;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public void setHex(Hex hex) {
		this.hex = hex;
	}

	public Hex getHex() {
		return hex;
	}
}
