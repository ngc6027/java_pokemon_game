package commands;

import environment.Environment;

public class ChangeActivePokemonCommand extends Command {

	private int pokemonNum;
	
	public ChangeActivePokemonCommand()
	{
		this.env = Environment.getEnvironment();
		this.pokemonNum = -1;
	}
	
	@Override
	public void execute() {
		env.changeActivePokemon(pokemonNum);
		this.pokemonNum = -1;

	}
	
	public void setPokemon(int pokemonNum)
	{
		this.pokemonNum = pokemonNum;
	}

}
