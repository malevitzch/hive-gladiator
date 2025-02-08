package game;
import player.Player;

public class Game {
	Player player;
	GameState state;
	public Game(Player p){
		player = p;
		state = new GameState();
	}
	public Boolean isOver() {
		return state.isOver();
	}
	public Boolean nextTurn() {
		return !state.isOver();
	}
}
