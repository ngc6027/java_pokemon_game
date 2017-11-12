package gameplay;

public interface Observer {

	public abstract void updateTurn(int turn);
	
	public abstract int getTurn();
}
