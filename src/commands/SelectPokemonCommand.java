package commands;

/**
 * The command that assigns a Pokemon to a Player. The number of
 * the Pokemon must be set before execute() is called each time.
 * 
 * @author Michael Foreman
 */
public class SelectPokemonCommand extends Command{
	
	private int pokemonNum;
	
	/**
	 * Instantiates a SelectPokemonCommand. The turn parameter
	 * is unnecessary and defaults to -1 for this command.
	 */
	public SelectPokemonCommand()
	{
		super(-1);
		this.pokemonNum = -1;
	}
	
	/**
	 * Sends the assignPokemon command to the Environment.
	 */
	@Override
	public void execute() {
		env.assignPokemon(pokemonNum);
		this.pokemonNum = -1;
	}
	
	/**
	 * @param pokemonNum the number of the pokemon to assign to the
	 * player whose turn it is.
	 */
	public void setPokemon(int pokemonNum)
	{
		this.pokemonNum = pokemonNum;
	}

}
