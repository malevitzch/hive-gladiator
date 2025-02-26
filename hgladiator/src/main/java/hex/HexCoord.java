package hex;

public class HexCoord {
	public int q, r, s;
	public HexCoord(int q, int r, int s) {
		this.q = q;
		this.r = r;
		this.s = s;
	}
	public HexCoord(HexCoord coords) {
		this.q = coords.q;
		this.r = coords.r;
		this.s = coords.s;
	}
}
