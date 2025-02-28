package game.entities;

import game.GameState;
import game.Tile;

import hex.HexCoord;

public class PlayerEntity implements Entity {
	
	@Override
	public void die() {
		// TODO: implement, this should probably halt the game?
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
	@Override
	public int getId() {
		return 0;
	}
	@Override
	public int getHealth() {
		return state.getPlayerHealth();
	}
	@Override
	public boolean isDead() {
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
	
	protected Tile tile;
	protected boolean dead = false;
	protected GameState state;
}
