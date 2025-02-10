package player.move;

public interface NormalMove extends Move {
	
	default public int getPriority() {
		return 1;
	}

}
