package gameplay;

/**
 * An interface for an Observer to interact with a Timer for keeping
 * track of time in the game.
 * 
 * @author Michael Foreman
 */
public interface Observer {

	public abstract void updateTurn(int turn);
	
	public abstract int getTurn();
}
