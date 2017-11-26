package commands;

import environment.Environment;

public class ChangeActivePokemonCommand extends Command {

	private int pokemonNum;
	
	public ChangeActivePokemonCommand(int turn)
	{
		super(turn);
		this.pokemonNum = -1;
	}
	
	@Override
	public void execute() {
		env.changeActivePokemon(pokemonNum, turn);
		this.pokemonNum = -1;

	}
	
	public void setPokemon(int pokemonNum)
	{
		this.pokemonNum = pokemonNum;
	}

}
