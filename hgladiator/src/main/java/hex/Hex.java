package hex;

import java.util.ArrayList;
import game.Tile;

public class Hex {
	// Data kept by the Hex
	private Tile tile;
	
	// Coordinates using the Cube coordinate system
	private HexCoord coordinates;
	
	public Hex(int q, int r, int s, Tile tile) {
		coordinates = new HexCoord(q, r, s);
		this.tile = tile;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public HexCoord getCoords() {
		return coordinates;
	}
	
	public int getQ() {
		return coordinates.q;
	}
	
	public int getR() {
		return coordinates.r;
	}
	
	public int getS() {
		return coordinates.s;
	}
	
	public ArrayList<HexCoord> findCoordsInLineAtExactDistance(int n) {
		ArrayList<HexCoord> coordList = new ArrayList<HexCoord>();
		if(n < 0) {
			return coordList;
		}
		if(n == 0) {
			coordList.add(coordinates);
			return coordList;
		}
		
		int q = coordinates.q;
		int r = coordinates.r;
		int s = coordinates.s;
		
		coordList.add(new HexCoord(q, r-n, s+n));
		coordList.add(new HexCoord(q, r+n, s-n));
		coordList.add(new HexCoord(q-n, r, s+n));
		coordList.add(new HexCoord(q+n, r, s-n));
		coordList.add(new HexCoord(q-n, r+n, s));
		coordList.add(new HexCoord(q+n, r-n, s));
		
		return coordList;
	}
	
	public ArrayList<HexCoord> findCoordsInLineAtDistanceInRange(int l, int r) {
		ArrayList<HexCoord> coordList = new ArrayList<HexCoord>();
		
		for(int d = l; d <= r; d++) {
			coordList.addAll(findCoordsInLineAtExactDistance(d));
		}
		
		return coordList;
	}
	
	public ArrayList<HexCoord> getNeighbourCoords() {
		return findCoordsInLineAtExactDistance(1);
	}
	
}
