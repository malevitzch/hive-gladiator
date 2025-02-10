package game;

public class GameConfig {
	
	public GameConfig(int playerHealth) {
		this.playerHealth = playerHealth;
	}
	
	private int playerHealth;
	public int getPlayerHealth() {
		return playerHealth;
	}
	
}
