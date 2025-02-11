package player;

import game.ImmutableGameState;
import player.move.Move;

public interface PlayerAgent {
	public Move getMove(ImmutableGameState state);
}
