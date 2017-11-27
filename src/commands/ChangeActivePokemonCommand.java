package commands;

/**
 * The command for switching a player's active Pokemon. This will happen on
 * a player's turn and will count as an action. The pokemonNum should be set
 * before the execute() method is called each time.
 * 
 * @author Michael Foreman
 */
public class ChangeActivePokemonCommand extends Command {

	private int pokemonNum;
	
	/**
	 * Instaniates the ChangePokemonCommand and associates it with
	 * a particular player.
	 * 
	 * @param playerNum the number of the player associated with this command.
	 */
	public ChangeActivePokemonCommand(int playerNum)
	{
		super(playerNum);
		this.pokemonNum = -1;
	}
	
	/**
	 * Sends the change Active Pokemon command to the Environment.
	 */
	@Override
	public void execute() {
		env.changeActivePokemon(pokemonNum, playerNum);
		this.pokemonNum = -1;

	}
	
	/**
	 * @param pokemonNum the number of the Pokemon the player should switch to.
	 */
	public void setPokemon(int pokemonNum)
	{
		this.pokemonNum = pokemonNum;
	}

}
