package player;

import game.GameState;
import player.move.Move;

public abstract class Player {
	public abstract Move makeMove(GameState state);
}
