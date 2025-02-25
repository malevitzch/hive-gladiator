package player.move;

public interface FastMove extends Move {
	
	default public int getPriority() {
		return 1;
	}

}
