package game;
import player.Player;
import player.move.Move;

public class Game {
	private Player player;
	private GameState state;
	public Game(Player player){
		this.player = player;
		state = new GameState();
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
