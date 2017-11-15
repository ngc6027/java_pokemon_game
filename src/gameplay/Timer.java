package gameplay;

import java.util.ArrayList;

public class Timer {

	private ArrayList<Observer> observers;
	private int turn;
	
	public Timer()
	{
		this.observers = new ArrayList<Observer>();
		this.turn = 0;
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
		
		//turn++;
		//turn = turn%2;
		
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
