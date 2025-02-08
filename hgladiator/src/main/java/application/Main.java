package application;

import game.GameDisplay;
import player.AfkPlayer;
import game.Game;

public class Main {
	public static void main(String[] args) {
		System.out.println("The Hive awaits you, gladiator");
		GameDisplay game = new GameDisplay(new Game(new AfkPlayer()));
		game.run();
    }
}
