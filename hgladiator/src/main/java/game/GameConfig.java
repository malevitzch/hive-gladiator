package game;

public class GameConfig {
	
	public GameConfig(int playerHealth, int mapSize) {
		this.playerHealth = playerHealth;
		this.mapSize = mapSize;
	}
	
	public int getPlayerHealth() {
		return playerHealth;
	}
	
	public int getMapSize() {
		return mapSize;
	}
	
	private int playerHealth;
	private int mapSize;
}
