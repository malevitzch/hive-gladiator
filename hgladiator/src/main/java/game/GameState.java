package game;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

import game.entities.EntityType;
import game.entities.Entity;
import game.entities.PlayerEntity;
import hex.Hex;
import hex.HexBoard;
import hex.HexCoord;
import player.move.Move;

import game.entities.enemy.*;

public class GameState {
	//TODO: Add all the important information about game state
	private int score;
	private int playerHealth;
	private GameConfig config;
	private HexBoard board;
	private PlayerEntity playerEntity;
	
	private LinkedHashMap<Integer, Entity> entities;
	
	private int entityId = 1;
	
	public GameState(GameConfig config) {
		entities = new LinkedHashMap<>();
		this.config = config;
		score = 0;
		playerHealth = this.config.getPlayerHealth();
		int n = config.getMapSize();
		ArrayList<Hex> hexes = new ArrayList<>();
		for(int i = -n; i <= n; i++) {
			for(int j = -n; j <= n; j++) {
				Tile tile = new Tile();
				Hex hex = new Hex(i, j, 0 - i - j, tile);
				tile.setHex(hex);
				hexes.add(hex);
			}
		}
		this.board = new HexBoard(hexes);
		
		// FIXME: The player entity should be instantiated with specific information probably
		// For now though the information is held inside the gameState class
		playerEntity = new PlayerEntity();
		this.getHex(0, 0, 0).getTile().setEntity(playerEntity);
	}
	
	public boolean makeMove(Move playerMove) {
		if(isOver()) return false;
		
		//TODO: Code goes here
		final int playerMovePriority = playerMove.getPriority();
		
		Comparator<Entity> entityCompare = new Comparator<Entity>() {
			@Override
			public int compare(Entity e1, Entity e2) {
				if(e1.getActionPriority() == e2.getActionPriority()) {
					return Integer.compare(e1.getId(), e2.getId());
				}
				return Integer.compare(e1.getActionPriority(), e2.getActionPriority());
			}
		};
		
		ArrayList<Entity> entitiesToAct = new ArrayList<Entity>();
		
		for(Entity entity : entities.values()) {
			entitiesToAct.add(entity);
		}
		
		Collections.sort(entitiesToAct, entityCompare);
		
		boolean playerMoved = false;
		
		for(Entity entity : entitiesToAct) {
			if(entity.getActionPriority() > playerMovePriority && !playerMoved) {
				playerMove.execute(this);
				playerMoved = true;
			}
		}
		
		if(!playerMoved) {
			playerMove.execute(this);
			playerMoved = true;
		}
		
		// TODO: remove this when the game starts to do something
		playerHealth--;
		
		
		// Cleanup phase. Every entity that is dead is removed from the game
		for(Entity entity : entitiesToAct) {
			if(entity.isDead()) removeEntity(entity);
		}
		
		return isOver();
	}
	
	public boolean isOver() {
		return playerHealth <= 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getPlayerHealth() {
		return playerHealth;
	}
	
	//TODO: this might need to handle errors eventually
	public Hex getHex(int q, int r, int s) {
		return board.getHex(q, r, s);
	}
	
	public Hex getHex(HexCoord coords) {
		return board.getHex(coords);
	}
	
	public ArrayList<Hex> getAllHex() {
		return board.getAllHex();
	}
	
	public boolean addEntity(Entity entity, HexCoord coords) {
		Tile targetTile = board.getHex(coords).getTile();
		if(targetTile.getEntity() != null) {
			return false;
		}
		if(entities.containsKey(entity.getId())) {
			return false;
		}
		entities.put(entity.getId(), entity);
		targetTile.setEntity(entity);
		entity.setTile(targetTile);
		return true;
	}
	
	public void removeEntity(Entity entity) {
		int id = entity.getId();
		if(!entities.containsKey(id)) return;
		entities.remove(id);
		entity.getTile().setEntity(null);
	}
	
	public boolean moveEntity(Entity entity, Tile target) {
		if(!target.empty()) {
			return false;
		}
		if(entity.getTile() != null) {
			entity.getTile().setEntity(null);
		}
		
		target.setEntity(entity);
		entity.setTile(target);
		
		return true;
	}
	
	public boolean spawnEntity(EntityType type, Tile tile) {
		
		if(!tile.empty()) {
			return false;
		}
		
		Entity entity;
		switch(type) {
			case null:
				return false;
			case Wanderer:
				entity = new Wanderer(entityId++, this);
				break;
			default:
				return false;
		}
		tile.setEntity(entity);
		
		return true;
	}
	
	// TODO: this might be removed later
	public HexBoard getBoard() {
		return board;
	}
	
	public PlayerEntity getPlayerEntity() {
		return playerEntity;
	}
}
