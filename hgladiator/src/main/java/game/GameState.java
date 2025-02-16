package game;

import player.move.Move;
import game.entities.Entity;

import java.util.PriorityQueue;
import java.util.Comparator;

public class GameState {
	//TODO: Add all the important information about game state
	private int score;
	private int playerHealth;
	private GameConfig config;
	
	public GameState(GameConfig config) {
		this.config = config;
		score = 0;
		playerHealth = this.config.getPlayerHealth();
	}
	
	
	public Boolean isValid(Move move) {
		//TODO: Validate the move legality
		return true;
	}
	public Boolean makeMove(Move player_move) {
		if(!isValid(player_move) || isOver()) return false;
		//TODO: Code goes here
		final int playerMovePriority = player_move.getPriority();
		
		PriorityQueue<Entity> entitiesToAct = new PriorityQueue<Entity>(
			new Comparator<Entity>() {
				@Override
				public int compare(Entity e1, Entity e2) {
					return Integer.compare(e1.getActionPriority(), e2.getActionPriority());
				}
			});
		
		// TODO: fill the entity queue by going through every hex in the board
		// TODO: there is a minor problem with this approach, the enemy move order gets mangled among enemies of the same priority
		while(!entitiesToAct.isEmpty() && entitiesToAct.peek().getActionPriority() <= playerMovePriority) {
			Entity curEntity = entitiesToAct.poll();
			curEntity.act(this);
		}
		// WARNING player might be dead here
		player_move.execute(this);
		
		while(!entitiesToAct.isEmpty()) {
			Entity curEntity = entitiesToAct.poll();
			curEntity.act(this);
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
