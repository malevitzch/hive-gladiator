package game;
import player.PlayerAgent;
import player.move.Move;

public class Game {
	private PlayerAgent player;
	private GameState state;
	private ImmutableGameState immutableState;
	public Game(PlayerAgent player){
		this.player = player;
		state = new GameState(new GameConfig(10, 3));
		immutableState = new ImmutableGameState(state);
	}
	public boolean isOver() {
		return state.isOver();
	}
	public boolean nextTurn() {
		Move playerMove = player.getMove(immutableState);
		state.makeMove(playerMove);
		return !state.isOver();
	}
	public GameState getState() {
		return state;
	}
}
