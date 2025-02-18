package game.entities;

import game.GameState;
import game.Tile;

public abstract class EnemyEntity implements Entity {
	
	Tile tile;
	
	@Override
	public void die() {
		// TODO: possibly remove since it does nothing so far
	}
	@Override
	public int getActionPriority() {
		return actionPriority;
	}
	@Override
	public void act(GameState state) {
		// TODO: this should have the general default behavior for acting
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public Tile getTile() {
		return tile;
	}
	@Override
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public EnemyEntity(int id, int actionPriority) {
		this.id = id;
		this.actionPriority = actionPriority;
	}
	private int id;
	private int actionPriority;

}
