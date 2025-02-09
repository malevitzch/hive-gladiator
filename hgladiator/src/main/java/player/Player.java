package player;

import game.ImmutableGameState;
import player.move.Move;

public abstract interface Player {
	public Move getMove(ImmutableGameState state);
}
