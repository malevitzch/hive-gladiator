package game.entities.enemy;

import game.GameState;
import game.Tile;

import hex.HexCoord;

public class Wanderer extends EnemyEntity {

	public Wanderer(int id, GameState state) {
		super(id, 1, state);
		health = 1;
	}
	
	@Override
	public void act() {
		if(!moveComputed) {
			decideMove();
		}
		super.act();
		Tile target = state.getHex(movePos).getData();
		state.moveEntity(this, target);
		// This is in case the path is blocked and there are no valid moves
		if(movePos == null) return;
	}
	
	@Override
	protected void decideMove() {
		//TODO: get neighbors and decide on the target tile
	}
	
	private HexCoord movePos = null;
}
