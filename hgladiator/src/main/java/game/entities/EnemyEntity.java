package game.entities;

import game.GameState;

public abstract class EnemyEntity implements Entity {
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
	public EnemyEntity(int id, int actionPriority) {
		this.id = id;
		this.actionPriority = actionPriority;
	}
	private int id;
	private int actionPriority;

}
