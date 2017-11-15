package lifeform;

import java.util.ArrayList;

import states.*;
import gameplay.*;

public class Player implements Observer{

	// Basic variables
	private ArrayList<Pokemon> heldPokemon;
	private int numPokemon;
	private Pokemon activePokemon;
	private Player opponent;
	
	// constant macros
	static final int MAX_POKEMON = 3;
	
	// Observer variables
	private int turn;
	private int id;
	
	public Player(int playerID)
	{
		this.heldPokemon = new ArrayList<Pokemon>();
		this.numPokemon = 0;
		this.activePokemon = null;
		this.opponent = null;
		
		this.id = playerID;
		this.turn = -1;
	}
	
	public void changeActivePokemon(int poke)
	{
		if(poke < 3)
		{
			if (!(heldPokemon.get(poke).getCurrentState() instanceof FaintedState))
			{
				this.activePokemon = heldPokemon.get(poke);
			}
		}
	}
		
	public boolean addPokemon(Pokemon poke) 
	{
		boolean added = false;
		
		if(canAddPokemon())
		{
			added = true;
			this.heldPokemon.add(poke);
			this.numPokemon++;
		}
		
		return (added);
	}
	
	private boolean canAddPokemon()
	{
		boolean canAdd = false;
	
		if(this.numPokemon < MAX_POKEMON)
		{
			canAdd = true;
		}
		
		return(canAdd);
	}
	
	public int getID()
	{
		return this.id;
	}

	@Override
	public void updateTurn(int turn) {
		this.turn = turn;
	}

	public int getTurn() 
	{
		return this.turn;
	}
	
	public Pokemon getPokemon(int index)
	{
		return heldPokemon.get(index);
	}
	
	
	public void resetGame()
	{
		heldPokemon.clear();
		this.numPokemon = heldPokemon.size();
		this.opponent = null;
		this.activePokemon = null;
	}
	
	public int getNumPokemon()
	{
		return this.numPokemon;
	}
	
	public Player getOpponent()
	{
		return this.opponent;
	}
	
	public void setOpponent(Player opp)
	{
		this.opponent = opp;
	}
	
	public Pokemon getActivePokemon()
	{
		return this.activePokemon;
	}
	
	public void setActivePokemon(int index)
	{
		this.activePokemon = heldPokemon.get(index);
	}
	
	
}
