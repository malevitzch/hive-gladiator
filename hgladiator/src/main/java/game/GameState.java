package game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

import game.entities.Entity;
import hex.Hex;
import hex.HexBoard;
import hex.HexCoord;
import player.move.Move;

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
		for(int i = -n; i <= n; i++) {
			for(int j = -n; j <= n; j++) {
				hexes.add(new Hex<>(i, j, 0 - i - j, new Tile()));
			}
		}
		this.board = new HexBoard<>(hexes);
	}
	
	//FIXME: This needs to go eventually, the move should just be made but possibly have no effect
	public Boolean isValid(Move move) {
		//TODO: To be fair this should probably just execute 
		return true;
	}
	
	public Boolean makeMove(Move playerMove) {
		if(!isValid(playerMove) || isOver()) return false;
		//TODO: Code goes here
		final int playerMovePriority = playerMove.getPriority();
		
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
		
		for(Entity entity : entities.values()) {
			entitiesToAct.add(entity);
		}
		
		Boolean playerMoved = false;
		
		
		while(!entitiesToAct.isEmpty()) {
			Entity curEntity = entitiesToAct.poll();
			if(curEntity.getActionPriority() > playerMovePriority) {
				playerMove.execute(this);
				playerMoved = true;
			}
			curEntity.act();
		}
		
		if(!playerMoved) {
			playerMove.execute(this);
			playerMoved = true;
		}
		
		// TODO: remove this when the game starts to do something
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
