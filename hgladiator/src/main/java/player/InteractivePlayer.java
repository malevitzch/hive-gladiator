package player;

import game.ImmutableGameState;
import player.move.WaitMove;
import player.move.Move;

public class InteractivePlayer implements PlayerAgent {

	@Override
	public Move getMove(ImmutableGameState state) {
		//FIXME: Figure out a reasonable way to get player input
		// The InteractivePlayer should probably attach to the window and get GUI actions from it
		return new WaitMove();
	}
	
}
