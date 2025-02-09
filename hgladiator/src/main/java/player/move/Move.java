package player.move;

import game.GameState;

public interface Move {
	
	public abstract void execute(GameState state);
	
	//0 is fast, 1 is normal, 2 is slow
	public abstract int get_priority();
}
