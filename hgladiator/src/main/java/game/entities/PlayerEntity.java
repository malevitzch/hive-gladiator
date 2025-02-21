package game.entities;

import game.GameState;
import game.Tile;

public class PlayerEntity implements Entity {

	Tile tile;
	
	@Override
	public void die() {
		// TODO implement, this should probably halt the game?
		// Not yet sure about the ramifications	
	}

	@Override
	public int getActionPriority() {
		// This is the priority of status effects etc. It's 0 for now because it generally should be before all other things
		return 0;
	}

	@Override
	public void act() {
		// This is not the player move, this is stuff such a status effects etc
	}
	
	// The player ID is always 0
	public int getId() {
		return 0;
	}
	
	public int getHealth() {
		return state.getPlayerHealth();
	}
	
	public Tile getTile() {
		return tile;
	}
	
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	protected GameState state;
}
