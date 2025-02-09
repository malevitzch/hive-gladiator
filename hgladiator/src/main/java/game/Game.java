package game;
import player.Player;
import player.move.Move;

public class Game {
	private Player player;
	private GameState state;
	public Game(Player p){
		player = p;
		state = new GameState();
	}
	public Boolean isOver() {
		return state.isOver();
	}
	public Boolean nextTurn() {
		Move player_move = player.getMove(new ImmutableGameState(state));
		state.makeMove(player_move);
		return !state.isOver();
	}
	public GameState getState() {
		return state;
	}
}
