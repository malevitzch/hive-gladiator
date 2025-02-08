package application;

import game.Game;
import player.AfkPlayer;

public class Main {
	public static void main(String[] args) {
		System.out.println("The Hive awaits you, gladiator");
		Game game = new Game(new AfkPlayer());
		game.play();
    }
}
