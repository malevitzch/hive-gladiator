package game;

import player.move.Move;
import game.entities.Entity;
import hex.HexBoard;
import hex.HexCoord;
import hex.Hex;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GameState {
	//TODO: Add all the important information about game state
	private int score;
	private int playerHealth;
	private GameConfig config;
	private HexBoard<Tile> board;
	
	private LinkedHashMap<Integer, Entity> entities;
	
	private int entityId = 1;
	
	public GameState(GameConfig config) {
		entities = new LinkedHashMap<>();
		this.config = config;
		score = 0;
		playerHealth = this.config.getPlayerHealth();
		int n = config.getMapSize();
		ArrayList<Hex<Tile>> hexes = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				hexes.add(new Hex<>(i, j, 0 - i - j, new Tile()));
			}
		}
		this.board = new HexBoard<>(hexes);
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
					if(e1.getActionPriority() == e2.getActionPriority()) {
						return Integer.compare(e1.getId(), e2.getId());
					}
					return Integer.compare(e1.getActionPriority(), e2.getActionPriority());
				}
			});
		
		// TODO: fill the entity queue by going through every hex in the board
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
	
	//TODO: this might need to handle errors eventually
	public Hex<Tile> getHex(int q, int r, int s) {
		return board.getHex(q, r, s);
	}
	
	public ArrayList<Hex<Tile>> getAllHex() {
		return board.getAllHex();
	}
	
	public Boolean addEntity(Entity entity, HexCoord coords) {
		Tile targetTile = board.getHex(coords).getData();
		if(targetTile.entity != null) {
			return false;
		}
		if(entities.containsKey(entity.getId())) {
			return false;
		}
		entities.put(entity.getId(), entity);
		targetTile.entity = entity;
		entity.setTile(targetTile);
		return true;
	}
	
	public Boolean moveEntity(Entity entity, Tile target) {
		if(target.entity != null) {
			return false;
		}
		if(entity.getTile() != null) {
			entity.getTile().entity = null;
		}
		entity.getTile().entity = null;
		target.entity = entity;
		return true;
	}
}
