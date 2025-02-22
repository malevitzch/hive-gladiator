package game;

import game.entities.Entity;

public class Tile {
	//TODO: expand this
	// Transformable, Terrain, Effects?
	private Entity entity;
	
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
}
