package gameplay;

import java.util.ArrayList;

/**
 * A Timer for keeping track of whose turn it is in the main game
 * and selection stage.
 * 
 * @author Michael Foreman
 */
public class Timer {

	private ArrayList<Observer> observers;
	private int turn;
	
	/**
	 * Instantiates a timer with an empty array list of
	 * Observers. Initializes the turn to player 1.
	 */
	public Timer()
	{
		this.observers = new ArrayList<Observer>();
		this.turn = 0;
	}
	
	/**
	 * Registers an Observer to the Timer.
	 * 
	 * @param toAdd the Observer to add.
	 */
	public void register(Observer toAdd)
	{
		if(!(this.observers.contains(toAdd)))
		{
			this.observers.add(toAdd);
			toAdd.updateTurn(this.turn);
		}
	}
	
	/**
	 * Removes an Observer from the list of Observers.
	 * 
	 * @param toRemove the Observer to remove.
	 */
	public void remove(Observer toRemove)
	{
		this.observers.remove(toRemove);
	}
	
	/**
	 * Updates the turn and notifies Observers of the change.
	 */
	public void update()
	{
		if (this.turn == 0)
		{
			this.turn = 1;
		} 
		else
		{
			this.turn = 0;
		}
		
		notifyObservers();
	}
	
	/**
	 * Notifies the list of Observers that the turn has changed.
	 */
	private void notifyObservers()
	{ 
		for (int i = 0; i < this.observers.size(); i++)
		{
			this.observers.get(i).updateTurn(this.turn);
		}
	}
	
	/**
	 * @return the number of Observers in the array of Observers.
	 */
	public int getNumObservers()
	{
		return this.observers.size();
	}
}
