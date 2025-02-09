package player.move;

public interface NormalMove extends Move {
	
	default public int get_priority() {
		return 1;
	}

}
