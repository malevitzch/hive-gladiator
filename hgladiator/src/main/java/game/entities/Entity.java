package game.entities;

public interface Entity {
	public void die();
	//This one might be a problem when implementing for players, needs some more thinking
	public int getActionPriority();
	public void act();
}
