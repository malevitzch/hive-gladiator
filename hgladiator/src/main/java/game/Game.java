package game;
import player.PlayerAgent;
import player.move.Move;

public class Game {
	private PlayerAgent player;
	private GameState state;
	public Game(PlayerAgent player){
		this.player = player;
		state = new GameState(new GameConfig(10));
	}
	public Boolean isOver() {
		return state.isOver();
	}
	public Boolean nextTurn() {
		Move playerMove = player.getMove(new ImmutableGameState(state));
		state.makeMove(playerMove);
		return !state.isOver();
	}
	public GameState getState() {
		return state;
	}
}
