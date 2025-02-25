package hex;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class HexBoard {
	
	Map<HexCoord, Hex> hexMap;
	
	// Not sure if this should be public or private
	public ArrayList<Hex> getHexesFromCoords(ArrayList<HexCoord> coords) {
		ArrayList<Hex> hexes = new ArrayList<Hex>();
		for(HexCoord coord : coords) {
			if(hexMap.containsKey(coord)) {
				hexes.add(hexMap.get(coord));
			}
		}
		return hexes;
	}
	
	public ArrayList<Hex> getNeighbours(Hex hex) {
		return getHexesFromCoords(hex.getNeighbourCoords());
	}
	
	public Hex getHex(int q, int r, int s) {
		return hexMap.get(new HexCoord(q, r, s));
	}
	
	public Hex getHex(HexCoord coords) {
		return hexMap.get(coords);
	}
	
	public ArrayList<Hex> getAllHex() {
		return new ArrayList<Hex>(hexMap.values());
	}
	
	public HexBoard(ArrayList<Hex> hexes) {
		hexMap = new LinkedHashMap<>();
		for(Hex hex : hexes) {
			hexMap.put(hex.getCoords(), hex);
		}
	}
	
}
