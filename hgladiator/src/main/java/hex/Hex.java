package hex;

import java.util.ArrayList;

public class Hex<V> {
	// Data kept by the Hex
	private V data;
	
	// Coordinates using the Cube coordinate system
	private HexCoord coordinates;
	
	public Hex(int q, int r, int s, V data) {
		coordinates = new HexCoord(q, r, s);
	}
	
	public V getData() {
		return data;
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
	
	public ArrayList<HexCoord> getNeighbourCoords() {
		
		ArrayList<HexCoord> coordList = new ArrayList<HexCoord>();
		
		int q = coordinates.q;
		int r = coordinates.r;
		int s = coordinates.s;
		
		coordList.add(new HexCoord(q, r-1, s+1));
		coordList.add(new HexCoord(q, r+1, s-1));
		coordList.add(new HexCoord(q-1, r, s+1));
		coordList.add(new HexCoord(q+1, r, s-1));
		coordList.add(new HexCoord(q-1, r+1, s));
		coordList.add(new HexCoord(q+1, r-1, s));
		
		return coordList;
	}
}
