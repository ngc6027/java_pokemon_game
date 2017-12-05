package environment;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gameplay.*;
import gui.PokemonImages;
import gui.WindowBuilderBattleGui;
import lifeform.*;

/**
 * This class holds all players, Pokemon, and the timer for the game. All
 * actions pass through the environment from the GUIs to the players and 
 * the Pokemon.
 * 
 * @author Michael Foreman
 */
public class Environment implements Observer, Iterator {

	private ArrayList<Player> players;
	private ArrayList<Pokemon> pokemon;
	private volatile static Environment uniqueInstance;
	private PokemonImages images;
	
	private int turn;
	private int pokemonIterator;
	
	private Timer timer;
	

	
	/* ****************************************************************
	 * 																  *
	 * 						  Singleton Pattern                       *
	 *																  *
	 * ****************************************************************/
	
	/**
	 * This instantiates all players, all Pokemon, the timer, and loads
	 * the images for the Pokemon.
	 */

	WindowBuilderBattleGui p1;
	WindowBuilderBattleGui p2;

	private Environment()
	{
		this.players = new ArrayList<Player>();
		createAllPlayers();
		
		this.turn = 0;
		
		this.pokemon = new ArrayList<Pokemon>();
		createAllPokemon();
		
		this.pokemonIterator = 0;
		
		images = new PokemonImages();
		
		this.timer = new Timer();
		
		timer.register(this);
		
		for(int i = 0; i < players.size(); i++)
		{
			timer.register(players.get(i));
		}
		
		p1 = null;
		p2 = null;
		
		resetGame();
	}
	
	/**
	 * @returns the unique instance of Environment
	 */
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

	/* ******************************************************
	 * 						End Singleton					*
	 * ******************************************************/
	
	
	
	/* ****************************************************************
	 * 																  *
	 * 						  Observer Pattern                        *
	 *																  *
	 * ****************************************************************/
	
	/**
	 * Updates which player's turn it is. Called by the timer.
	 */
	@Override
	public void updateTurn(int turn) {
		this.turn = turn;
	}
	
	/**
	 * @return the Environment's understanding of whose turn it is.
	 */
	@Override
	public int getTurn() 
	{
		return this.turn;
	}
	
	/* ******************************************************
	 * 						End Observer					*
	 * ******************************************************/
	
	
	
	/* ****************************************************************
	 * 																  *
	 * 						  Iterator Pattern                        *
	 *																  *
	 * ****************************************************************/
	
	/**
	 * @return whether there is another Pokemon to retrieve from the list.
	 */
	public boolean hasNext()
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
	
	/**
	 * @return the next Pokemon in the list.
	 */
	public Pokemon next()
	{
		Pokemon p = pokemon.get(this.pokemonIterator);
		this.pokemonIterator++;
		return p;
	}
	
	/* ******************************************************
	 * 						End Iterator					*
	 * ******************************************************/

	
	/* ****************************************************************
	 * 																  *
	 * 						  Command Pattern                         *
	 *																  *
	 * ****************************************************************/
	/**
	 * Assigns a Pokemon to the player whose turn it is.
	 * 
	 * @param index the index of the Pokemon to assign.
	 */
	public void assignPokemon(int index)
	{		
		this.players.get(turn).addPokemon(this.pokemon.get(index));	
		
		this.timer.update();
	}
	
	/**
	 * Commands a player's active Pokemon to attack his opponent's
	 * active Pokemon. Must be the player's turn, as determined by
	 * the game's timer. Updates the timer if the command goes through.
	 * 
	 * @param attackNum the number of the active Pokemon's attack
	 * @param playerNum the number of the player who sent the command
	 */
	public void attack(int attackNum, int playerNum)
	{
		// check if it is the player's turn who sent the command
		if(playerNum == this.turn)
		{
			this.players.get(playerNum).attack(attackNum);
			this.timer.update();
			
			this.updateAllPanes();
		}
	}
	
	/**
	 * Changes the active Pokemon of the player. Updates the timer if
	 * the player was able to change their active Pokemon.
	 * 
	 * @param pokemonNum the number of the Pokemon to switch to
	 * @param playerNum the number of the player who sent the command
	 */
	public void changeActivePokemon(int pokemonNum, int playerNum)
	{
		boolean success = false;
		
		// check if it is the player's turn who sent the command
		if(playerNum == this.turn)
		{
			success = this.players.get(playerNum).changeActivePokemon(pokemonNum);
		}
		
		/*
			only update if the player could change their active Pokemon to the
			desired Pokemon.
		*/
		if(success)
		{
			this.timer.update();
		}
		
		updateAllPanes();
		
	}
	
	private void updateAllPanes() {
		if(p1 != null)
		{
			p1.updateAllPanes();
		}
		
		if(p2 != null)
		{
			p2.updateAllPanes();
		}
		
	}

	/**
	 * Registers an Observer with the game's Timer.
	 * @param o
	 */
	public void registerWithTimer(Observer o)
	{
		this.timer.register(o);
	}
	
	/**
	 * Sets the battleGui references
	 * @param gui
	 * @param playerNum
	 */
	public void setBattleGui(WindowBuilderBattleGui gui, int playerNum)
	{
		if(playerNum == 0)
		{
			this.p1 = gui;
		}
		if(playerNum == 1)
		{
			this.p2 = gui;
		}
	}
	
	/**
	 * Returns the requested battleGui reference
	 * @param playerNum
	 * @return
	 */
	public WindowBuilderBattleGui getBattleGui(int playerNum)
	{
		if(playerNum == 0)
		{
			return this.p1;
		}
		if(playerNum == 1)
		{
			return this.p2;
		}
		return null;
	}
	
	
	/* ******************************************************
	 * 						End Command					    *
	 * ******************************************************/
	
	/**
	 * Instantiates all 12 Pokemon for the game.
	 */
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
	
	/**
	 * Instantiates two players for the game. Sets their opponent to the
	 * other player.
	 */
	private void createAllPlayers()
	{
		this.players.add(new Player(0));
		this.players.add(new Player(1));
		
		this.players.get(0).setOpponent(this.players.get(1));
		this.players.get(1).setOpponent(this.players.get(0));
	}
	
	/**
	 * Gets a Pokemon from the array of all Pokemon.
	 * 
	 * @param index the index of the Pokemon to retrieve
	 * @return the desired Pokemon
	 */
	public Pokemon getPokemon(int index)
	{
		Pokemon rc = null;
		
		if((index >= 0) && (index < pokemon.size()))
		{
			rc = pokemon.get(index);
		}
		
		return rc;		
	}
	
	/**
	 * Resets the game to its initial state. Resets the timer to 0,
	 * resets Pokemon to their initial states, and removes all Pokemon
	 * from all players.
	 */
	public void resetGame()
	{
		for(int i = 0; i < players.size(); i++)
		{
			players.get(i).resetGame();
		}
		
		while(this.turn != 0)
		{
			timer.update();
		}
		
		for(int i = 0; i < pokemon.size(); i++)
		{
			pokemon.get(i).resetGame();
		}
	}
	
	/**
	 * @param name the name of the Pokemon whose image should be retrieved
	 * @return the image of the desired Pokemon
	 * @throws IOException
	 */
	public ImageIcon getPokemonImage(String name) throws IOException
	{
		return images.getImage(name);
	}
	
	/**
	 * @param index the Player to retrieve
	 * @return the desired Player
	 */
	public Player getPlayer(int index)
	{
		return players.get(index);
	}
	
	
	/* ******************************************************************************
	 *                        Commands for Command Pattern                          *
	 * ******************************************************************************/
	
//	public void assignPokemon(int index)
//	{		
//		this.players.get(turn).addPokemon(this.pokemon.get(index));	
//		
//		this.timer.update();
//	}
//	
//	public void attack(int attackNum, int turn)
//	{
//		if(turn == this.turn)
//		{
//			this.players.get(turn).attack(attackNum);
//			this.timer.update();
//			
//			p1.updateAllPanes();
//			p2.updateAllPanes();
//		}
//	}
//	
//	public void changeActivePokemon(int pokemonNum, int turn)
//	{
//		boolean success = false;
//		
//		if(turn == this.turn)
//		{
//			success = this.players.get(turn).changeActivePokemon(pokemonNum);
//		}
//		
//		if(success)
//		{
//			this.timer.update();
//			
//		}
//		
//		p1.updateAllPanes();
//		p2.updateAllPanes();
//
//	}	
	
}
