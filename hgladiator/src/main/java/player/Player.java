package player;

import game.GameState;
import player.move.Move;

public abstract interface Player {
	public Move getMove(GameState state);
}
