package game.entities;

import game.GameState;

public class PlayerEntity implements Entity {

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
	public void act(GameState state) {
		// This is not the player move, this is stuff such a status effects etc
	}
	
	// The player ID is always 0
	public int getId() {
		return 0;
	}

}
