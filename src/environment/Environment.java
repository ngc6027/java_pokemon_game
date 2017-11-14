package environment;

import java.util.ArrayList;

import gameplay.*;
import lifeform.*;

public class Environment implements Observer, Iterator{

	private ArrayList<Player> players;
	private ArrayList<Pokemon> pokemon;
	private volatile static Environment uniqueInstance;
	private Pokemon selectedPokemon;
	
	private int turn;
	private int pokemonIterator;
	
	private Environment()
	{
		this.players = new ArrayList<Player>();
		createAllPlayers();
		this.turn = 0;
		this.pokemon = new ArrayList<Pokemon>();
		createAllPokemon();
		this.selectedPokemon = null;
		
		this.pokemonIterator = 0;
	}
	
	public static Environment getEnvironment()
	{
		if (uniqueInstance == null)
		{
			synchronized (Environment.class)
			{
				if (uniqueInstance == null)
				{
					new Environment();
				}
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
		this.pokemon.add(new Bulbasaur());
		this.pokemon.add(new Ivysaur());
		this.pokemon.add(new Venusaur());
	}
	
	private void createAllPlayers()
	{
		this.players.add(new Player(0));
		this.players.add(new Player(1));
	}
	
	public Pokemon getPokemon(int index)
	{
		return pokemon.get(index);
	}
	
	public void resetGame()
	{
		//give all pokemon full health
	}
	
	public boolean hasNext()
	{
		boolean hasNext = false;
		
		if (this.pokemonIterator < pokemon.size())
		{
			hasNext = true;
		}
		
		return hasNext;
	}
	
	public Pokemon next()
	{
		Pokemon p = pokemon.get(this.pokemonIterator);
		this.pokemonIterator++;
		return p;
	}
}
