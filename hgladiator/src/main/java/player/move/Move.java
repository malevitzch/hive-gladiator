package player.move;

import game.GameState;

public interface Move {
	public abstract void execute(GameState state);
}
