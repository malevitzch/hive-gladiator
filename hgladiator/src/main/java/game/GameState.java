package game;

import player.move.Move;

public class GameState {
	//TODO: Add all the important information about game state
	private int score;
	private int playerHealth;
	
	public GameState() {
		score = 0;
		//TODO: This potentially depends on some settings conditions
		//TODO: Add a settings class that is used to initialize the game state
		playerHealth = 5;
	}
	
	public Boolean isValid(Move move) {
		//TODO: Validate the move legality
		return true;
	}
	public Boolean makeMove(Move player_move) {
		if(!isValid(player_move) || isOver()) return false;
		//TODO: Code goes here
		final int player_move_priority = player_move.getPriority();
		
		// Fast monster moves happen here
		if(player_move_priority == 0) {
			player_move.execute(this);
		}
		// Regular monster moves happen here
		if(player_move_priority == 1) {
			player_move.execute(this);
		}
		// Slow monster moves happen here
		if(player_move_priority == 2) {
			player_move.execute(this);
		}
		
		playerHealth--;
		return true;
	}
	public Boolean isOver() {
		return playerHealth <= 0;
	}
	public int getScore() {
		return score;
	}
	public int getPlayerHealth() {
		return playerHealth;
	}
}
