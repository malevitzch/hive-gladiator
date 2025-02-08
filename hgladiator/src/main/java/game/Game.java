package game;
import player.Player;

public class Game {
	Player player;
	public Game(Player p){
		player = p;
	}
	public Game() {
	}
	public void play() { 
		System.out.println("Welcome to the hive");
	}
}
