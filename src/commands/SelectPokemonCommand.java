package commands;

import environment.*;
import lifeform.*;

public class SelectPokemonCommand extends Command{
	
	private Pokemon pokemon;
	
	public SelectPokemonCommand()
	{
		this.env = Environment.getEnvironment();
		this.pokemon = null;
	}
	
	@Override
	public void execute() {
		Player p = env.getPlayer();
		
		if (p != null)
		{
			p.addPokemon(this.pokemon);
		}
		
	}
	
	public void setPokemon(Pokemon p)
	{
		this.pokemon = p;
	}

}
