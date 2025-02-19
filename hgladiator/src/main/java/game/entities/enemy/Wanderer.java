package game.entities.enemy;

import game.GameState;

public class Wanderer extends EnemyEntity {

	public Wanderer(int id) {
		super(id, 1);
	}
	
	@Override
	public void act(GameState state) {
		// TODO: make a random move
	}
}
