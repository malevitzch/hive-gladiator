package game;

import hex.HexCoord;

public enum Direction {
	NORTH_WEST(new HexCoord(0, -1, 1)),
	NORTH_EAST(new HexCoord(1, -1, 0)),
	WEST(new HexCoord(-1, 0, 1)),
	EAST(new HexCoord(1, 0, -1)),
	SOUTH_WEST(new HexCoord(-1, 1, 0)),
	SOUTH_EAST(new HexCoord(0, 1, -1));
	
	private final HexCoord coords;
	
	private Direction(HexCoord coords) {
		this.coords = coords;
	}
	
	//TODO: This should return immutable coords
    public HexCoord getUnitVector() {
        return new HexCoord(coords);
    }
}
