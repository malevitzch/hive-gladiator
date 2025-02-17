package hex;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class HexBoard<V> {
	
	Map<HexCoord, Hex<V>> hexMap;
	
	// Not sure if this should be public or private
	public ArrayList<Hex<V>> getHexesFromCoords(ArrayList<HexCoord> coords) {
		ArrayList<Hex<V>> hexes = new ArrayList<Hex<V>>();
		for(HexCoord coord : coords) {
			if(hexMap.containsKey(coord)) {
				hexes.add(hexMap.get(coord));
			}
		}
		return hexes;
	}
	
	public ArrayList<Hex<V>> getNeighbours(Hex<V> hex) {
		return getHexesFromCoords(hex.getNeighbourCoords());
	}
	
	public Hex<V> getHex(int q, int r, int s) {
		return hexMap.get(new HexCoord(q, r, s));
	}
	
	public HexBoard(ArrayList<Hex<V>> hexes) {
		hexMap = new LinkedHashMap<>();
		for(Hex<V> hex : hexes) {
			hexMap.put(hex.getCoords(), hex);
		}
	}
	
}
