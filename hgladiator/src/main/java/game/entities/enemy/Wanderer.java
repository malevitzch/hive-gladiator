package game.entities.enemy;

import game.GameState;

public class Wanderer extends EnemyEntity {

	public Wanderer(int id, GameState state) {
		super(id, 1, state);
		health = 1;
	}
	
	@Override
	public void act() {
		super.act();
		// TODO: make semi-random move
	}
	
	@Override
	protected void decideMove() {
		// TODO: Auto-generated method stub
	}
}
