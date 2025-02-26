package player.move;

import game.GameState;
import game.Direction;
import game.entities.PlayerEntity;

import game.Tile;
import hex.HexCoord;

public class StepMove implements FastMove {
	private Direction direction;
	
	StepMove(Direction direction) {
		this.direction = direction;
	}
	
	public void execute(GameState state) {
		PlayerEntity player = state.getPlayerEntity();
		HexCoord newPosition = new HexCoord(player.getCoords());
		newPosition.add(direction.getUnitVector());
		
		Tile targetTile = state.getHex(newPosition).getTile();
		
		state.moveEntity(player, targetTile);
	}

}
