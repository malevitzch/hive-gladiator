package hex;

import java.util.HashMap;
import java.util.ArrayList;

public class HexBoard<V> {
	
	HashMap<HexCoord, Hex<V>> hexMap;
	
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
	
}
