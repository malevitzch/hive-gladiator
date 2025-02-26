package game.entities.enemy;

import game.entities.Entity;
import game.GameState;
import game.Tile;

import hex.HexCoord;

public abstract class EnemyEntity implements Entity {
	
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
	public Boolean isDead() {
		if(getHealth() <= 0) {
			dead = true;
		}
		return dead;
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
	// TODO: maybe shouldn't be abstract and should just be a default boilerplate implementation
	protected abstract void decideMove();
	
	protected Tile tile;
	protected Boolean dead = false;
	protected GameState state;
	protected int health;
	private int id;
	private int actionPriority;
	protected Boolean moveComputed = false;
}
