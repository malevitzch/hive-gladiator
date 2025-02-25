package player.move;

import game.GameState;
import game.Direction;

public class StepMove implements FastMove {
	private Direction direction;
	
	StepMove(Direction direction) {
		this.direction = direction;
	}
	
	public void execute(GameState state) {
		//TODO: act according to direction
	}

}
