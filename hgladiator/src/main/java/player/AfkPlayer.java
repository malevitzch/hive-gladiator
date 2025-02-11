package player;

import player.move.WaitMove;

import player.move.Move;
import game.ImmutableGameState;

public class AfkPlayer implements PlayerAgent {
	@Override
	public Move getMove(ImmutableGameState state) {
		return new WaitMove();
	}
}
