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
		this.turn = 0;
	}
	
	public void setOpponent(Player opp)
	{
		this.opponent = opp;
	}
	
	public void changeActivePokemon(Pokemon poke)
	{
		if (!(poke.getCurrentState() instanceof FaintedState) && (heldPokemon.contains(poke)))
		{
			this.activePokemon = poke;
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
	
	@Override
	public int getTurn()
	{
		return this.turn;
	}
	
}
