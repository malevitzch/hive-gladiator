package player;

import player.move.WaitMove;

import player.move.Move;
import game.ImmutableGameState;

public class AfkPlayer implements Player {
	public Move getMove(ImmutableGameState state) {
		return new WaitMove();
	}
}
