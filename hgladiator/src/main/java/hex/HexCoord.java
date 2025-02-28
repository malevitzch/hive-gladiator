package hex;

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
}
