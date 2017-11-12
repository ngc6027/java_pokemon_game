package lifeform;

import java.util.ArrayList;

import states.*;

public class Player {

	private ArrayList<Pokemon> heldPokemon;
	private int numPokemon;
	private Pokemon activePokemon;
	private Player opponent;
	
	static final int MAX_POKEMON = 3;
	
	public Player()
	{
		this.heldPokemon = new ArrayList<Pokemon>();
		this.numPokemon = 0;
		this.activePokemon = null;
		this.opponent = null;
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
}
