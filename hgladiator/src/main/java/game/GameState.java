package game;

import player.move.Move;

public class GameState {
	private int score;
	//TODO: Add all the important information about game state
	public GameState() {
		score = 0;
	}
	
	public Boolean isValid(Move m) {
		//TODO: Validate the move legality
		return true;
	}
	public Boolean makeMove(Move m) {
		if(!isValid(m)) return false;
		//TODO: Code goes here
		return true;
	}
	public Boolean isOver() {
		return false;
	}
	public int getScore() {
		return score;
	}
}
