package application;

import game.Game;
import game.GameState;
import player.AfkPlayer;
import game.entities.EntityType;

import hex.HexCoord;

public class Main {
    public static void main(String[] args) {
        /*Application App = new Application();
        App.init();
        App.run();
        App.shutdown();*/
    	Game game = new Game(new AfkPlayer());
    	
    	GameState state = game.getState();
    	
    	state.spawnEntity(EntityType.Wanderer, new HexCoord(1, -1, 0));
    	while(!game.isOver()) {
    		game.nextTurn();
    	}
    }
}
