package game.entities.enemy;

import game.entities.Entity;
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
		if(!moveComputed) {
			decideMove();
			moveComputed = true;
		}
		return actionPriority;
	}
	@Override
	public void act() {
		// TODO: die() might be either called here or on cleanup
		if(health <= 0) {
			return;
		}
		// TODO: this should have the general default behavior for acting
		moveComputed = false;
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public int getHealth() {
		return health;
	}
	@Override
	public Tile getTile() {
		return tile;
	}
	@Override
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public EnemyEntity(int id, int actionPriority, GameState state) {
		this.id = id;
		this.actionPriority = actionPriority;
		this.state = state;
	}
	
	// Decide what to do based on game state. Set action priority accordingly
	protected abstract void decideMove();
	
	protected GameState state;
	protected int health;
	private int id;
	private int actionPriority;
	//FIXME: solve the move problem somehow
	private Boolean moveComputed = false;
}
