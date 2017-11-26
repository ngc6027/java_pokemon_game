package commands;

import environment.*;

public class SelectPokemonCommand extends Command{
	
	private int pokemonNum;
	
	public SelectPokemonCommand()
	{
		super(-1);
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
