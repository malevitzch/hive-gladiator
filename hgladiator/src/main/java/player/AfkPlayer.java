package player;

import player.move.WaitMove;
import player.move.Move;
import game.GameState;

public class AfkPlayer implements Player {
	public Move getMove(GameState state) {
		return new WaitMove();
	}
}
