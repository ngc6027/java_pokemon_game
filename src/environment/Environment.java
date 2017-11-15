package environment;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gameplay.*;
import gui.PokemonImages;
import lifeform.*;

public class Environment implements Observer, Iterator {

	private ArrayList<Player> players;
	private ArrayList<Pokemon> pokemon;
	private volatile static Environment uniqueInstance;
	private PokemonImages images;
	private Pokemon selectedPokemon;
	
	private int turn;
	private int pokemonIterator;
	
	private Timer timer;
	
	private Environment()
	{
		this.players = new ArrayList<Player>();
		createAllPlayers();
		this.turn = 0;
		this.pokemon = new ArrayList<Pokemon>();
		createAllPokemon();
		this.selectedPokemon = null;
		
		this.pokemonIterator = 0;
		
		images = new PokemonImages();
		
		this.timer = new Timer();
		
		timer.register(this);
		
		for(int i = 0; i < players.size(); i++)
		{
			timer.register(players.get(i));
		}
	}
	
	public static Environment getEnvironment()
	{
		if (uniqueInstance == null)
		{
			synchronized (Environment.class)
			{
				if (uniqueInstance == null)
				{
					uniqueInstance = new Environment();
				}
			}
		}
		
		return uniqueInstance;
	}

	public void assignPokemon(int index)
	{		
		this.players.get(turn - 1).addPokemon(this.pokemon.get(index));
		this.timer.updateTurn();
	}
	
	@Override
	public void updateTurn(int turn) {
		this.turn = turn;
	}
	
	private void createAllPokemon()
	{
		// Grass Types
		this.pokemon.add(new Bulbasaur());
		this.pokemon.add(new Ivysaur());
		this.pokemon.add(new Venusaur());
		this.pokemon.add(new Caterpie());
		
		// Fire Types
		this.pokemon.add(new Charmander());
		this.pokemon.add(new Charmeleon());
		this.pokemon.add(new Charizard());
		this.pokemon.add(new Vulpix());
		
		// Water Types
		this.pokemon.add(new Squirtle());
		this.pokemon.add(new Wartortle());
		this.pokemon.add(new Blastoise());
		this.pokemon.add(new Poliwag());
		
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
	
	public boolean hasNextPokemon()
	{
		boolean hasNext = false;
		
		if (this.pokemonIterator < pokemon.size())
		{
			hasNext = true;
		}
		else
		{
			this.pokemonIterator = 0;
		}
		
		return hasNext;
	}
	
	public Pokemon nextPokemon()
	{
		Pokemon p = pokemon.get(this.pokemonIterator);
		this.pokemonIterator++;
		return p;
	}
	
	public ImageIcon getPokemonImage(String name) throws IOException
	{
		return images.getImage(name);
	}
	
	public void registerWithTimer(Observer o)
	{
		this.timer.register(o);
	}
}
