package gameplay;

import java.util.ArrayList;

public class Timer {

	private ArrayList<Observer> observers;
	private int turn;
	
	public Timer()
	{
		this.observers = new ArrayList<Observer>();
		this.turn = 1;
	}
	
	public void register(Observer toAdd)
	{
		this.observers.add(toAdd);
		toAdd.updateTurn(this.turn);
	}
	
	public void remove(Observer toRemove)
	{
		this.observers.remove(toRemove);
	}
	
	public void updateTurn()
	{
		if (this.turn == 1)
		{
			this.turn = 2;
		} 
		else
		{
			this.turn = 1;
		}
		
		notifyObservers();
	}
	
	private void notifyObservers()
	{ 
		for (int i = 0; i < this.observers.size(); i++)
		{
			this.observers.get(i).updateTurn(this.turn);
		}
	}
	
	public int getNumObservers()
	{
		return this.observers.size();
	}
}
