package game.entities.enemy;

import game.GameState;
import game.Tile;

import hex.HexCoord;
import hex.Hex;

import java.util.ArrayList;

public class Wanderer extends EnemyEntity {

	public Wanderer(int id, GameState state) {
		super(id, 1, state);
		health = 1;
	}
	
	@Override
	public void act() {
		if(!moveComputed) {
			decideMove();
		}
		super.act();
		HexCoord coords = this.getTile().getHex().getCoords();
		System.out.format("Wanderer at position: %d %d %d\n", coords.q, coords.r, coords.s);
		// TODO: tile might be destroyed
		Tile target = state.getHex(movePos).getTile();
		state.moveEntity(this, target);
		// This is in case the path is blocked and there are no valid moves
		if(movePos == null) return;
	}
	
	@Override
	protected void decideMove() {
		
		// This should never happen but I'm guarding my back just in case
		// Maybe should just throw an exception straight up
		if(moveComputed) return;
		
		movePos = null;
		moveComputed = true;
		// TODO: add a more reasonable command that allows getting neighbours of a tile
		ArrayList<Hex> hexes = state.getBoard().getNeighbours(this.getTile().getHex());
		for(Hex hex : hexes) {
			if(hex.getTile().empty()) {
				movePos = hex.getCoords();
				break;
			}
		}
	}
	
	private HexCoord movePos = null;
}
