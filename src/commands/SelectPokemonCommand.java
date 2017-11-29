package commands;

import environment.*;
import lifeform.Player;

public class SelectPokemonCommand extends Command{
	
	private int pokemonNum;
	
	public SelectPokemonCommand()
	{
		this.env = Environment.getEnvironment();
		this.pokemonNum = -1;
	}
	
	@Override
	public void execute() {
		env.assignPokemon(pokemonNum);
		this.pokemonNum = -1;
	}
	
	public void setPokemon(int pokemonNum)
	{

			this.pokemonNum = pokemonNum;

		
	}

}
