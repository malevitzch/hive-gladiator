package game;

public class ImmutableGameState {
	private GameState state;
	public ImmutableGameState(GameState state) {
		this.state = state;
	}
	public int getPlayerHealth() {
		return state.getPlayerHealth();
	}
}
