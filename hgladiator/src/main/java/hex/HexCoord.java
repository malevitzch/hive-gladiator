package hex;

import java.util.Objects;

public class HexCoord {
	
	public int q, r, s;
	
	public HexCoord(int q, int r, int s) {
		this.q = q;
		this.r = r;
		this.s = s;
	}

	public HexCoord() {
		this.q = this.r = this.s = 0;
	}

	public HexCoord(HexCoord coords) {
		this.q = coords.q;
		this.r = coords.r;
		this.s = coords.s;
	}
	
	public void add(HexCoord coords) {
		this.q += coords.q;
		this.r += coords.r;
		this.s += coords.s;
	}
	
	public static HexCoord sum(HexCoord ... coords) {
		HexCoord ret = new HexCoord();
		for(HexCoord coord : coords) {
			ret.add(coord);
		}
		return ret;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(q, r, s);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		HexCoord coord = (HexCoord) obj;
		
		return this.q == coord.q && this.r == coord.r && this.s == coord.s;
	}
}
