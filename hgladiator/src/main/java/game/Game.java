package game;
import player.Player;

public class Game {
	Player player;
	GameState state;
	public Game(Player p){
		player = p;
		state = new GameState();
	}
	public void play() { 
		System.out.println("Welcome to the hive");
	}
	public Boolean nextTurn() {
		return !state.isOver();
	}
}
