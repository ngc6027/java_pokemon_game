package environment;

import java.util.ArrayList;

import gameplay.Observer;
import lifeform.*;

public class Environment implements Observer{

	private ArrayList<Player> players;
	private ArrayList<Pokemon> pokemon;
	private volatile static Environment uniqueInstance;
	private Pokemon selectedPokemon;
	
	private int turn;
	
	private Environment()
	{
		this.players = new ArrayList<Player>();
		this.turn = 0;
		this.pokemon = new ArrayList<Pokemon>();
		createAllPokemon();
		this.selectedPokemon = null;
	}
	
	public static Environment getEnvironment()
	{
		synchronized (Environment.class)
		{
			if (uniqueInstance == null)
			{
				new Environment();
			}
		}
		
		return uniqueInstance;
	}
	
	public void addPlayer(Player toAdd)
	{
		this.players.add(toAdd);
	}
	
	public void removePlayer(Player toRemove)
	{
		this.players.remove(toRemove);
	}

	public Player getPlayer()
	{
		Player ret = null;
		
		if(players.get(turn - 1) != null)
		{
			ret =  players.get(turn - 1);
		}
		
		return ret;
	}
	
	@Override
	public void updateTurn(int turn) {
		this.turn = turn;
		
	}

	@Override
	public int getTurn() {
		// TODO Auto-generated method stub
		return turn;
	}
	
	public void setSelectedPokemon(Pokemon poke)
	{
		this.selectedPokemon = poke;
	}
	
	private void createAllPokemon()
	{
		
	}
	
	public Pokemon getPokemon(int index)
	{
		return pokemon.get(index);
	}
	
	public void resetGame()
	{
		//give all pokemon full health
	}
}
