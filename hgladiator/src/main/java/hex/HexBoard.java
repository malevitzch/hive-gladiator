package hex;

import java.util.HashMap;
import java.util.ArrayList;

public class HexBoard<V> {
	
	HashMap<HexCoord, Hex<V>> hexes;
	
	public ArrayList<Hex<V>> getNeighbours(Hex<V> hex) {
		ArrayList<Hex<V>> neighbours = new ArrayList<Hex<V>>();
		for(HexCoord coord : hex.getNeighbourCoords()) {
			if(hexes.containsKey(coord)) {
				neighbours.add(hexes.get(coord));
			}
		}
		return neighbours;
	}
	
}
